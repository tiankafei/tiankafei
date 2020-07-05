package org.tiankafei.gateway.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.GatewayConstants;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class GatewayUtil {

    /**
     * 检查是否需要执行次过滤，配置了不过滤的url，不走所有的过滤
     * @param exchange
     * @return
     */
    public static boolean checkIsExecuteFilter(ServerWebExchange exchange){
        boolean flag = Boolean.FALSE;
        Object object = exchange.getAttributes().get(GatewayConstants.EXCLUSTIONS_URL_FLAG);
        if(object instanceof Boolean){
            flag = Boolean.valueOf(object.toString());
        }
        return flag;
    }

    /**
     * 设置不需要过滤的标识
     * @param exchange
     */
    public static void setNoExecFilter(ServerWebExchange exchange){
        exchange.getAttributes().put(GatewayConstants.EXCLUSTIONS_URL_FLAG, Boolean.TRUE);
    }

    /**
     * 返回值
     * @param apiResult
     * @param exchange
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange){
        return returnValue(apiResult, exchange, null);
    }

    /**
     * 返回值
     * @param apiResult
     * @param exchange
     * @param httpStatus
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange, HttpStatus httpStatus){
        return returnValue(apiResult, exchange, getDefaultCharset(), httpStatus);
    }

    /**
     * **
     * 返回值
     * @param apiResult
     * @param exchange
     * @param charset
     * @param httpStatus
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange, Charset charset, HttpStatus httpStatus){
        String contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + getDefaultCharset();
        if(charset != null){
            contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + charset;
        }

        // 自定义返回结果
        String returnBody = JSON.toJSONString(apiResult);
        byte[] byteArray = returnBody.getBytes(getDefaultCharset());
        ServerHttpResponse response = exchange.getResponse();

        DataBuffer buffer = response.bufferFactory().wrap(byteArray);
        // 从header中获取
        if(httpStatus != null){
            response.setStatusCode(httpStatus);
        }
        response.getHeaders().add("Content-Type", contentType);
        return response.writeWith(Mono.just(buffer));
    }

    private static Charset getDefaultCharset(){
        return StandardCharsets.UTF_8;
    }

}
