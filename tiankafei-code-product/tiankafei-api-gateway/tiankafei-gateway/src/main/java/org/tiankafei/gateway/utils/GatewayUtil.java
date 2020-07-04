package org.tiankafei.gateway.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.GatewayConstants;
import reactor.core.publisher.Mono;

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
     * 返回值转换
     * @param apiResult
     * @param exchange
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange){
        ServerHttpResponse response = exchange.getResponse();
        // 自定义返回结果
        String returnBody = JSON.toJSONString(apiResult);
        byte[] byteArray = returnBody.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(byteArray);
        return response.writeWith(Mono.just(buffer));
    }

}
