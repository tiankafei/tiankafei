package org.tiankafei.gateway.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.api.ApiResult;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class GatewayUtil {

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
