package org.tiankafei.gateway.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
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
        // 自定义返回结果
        byte[] bits = JSON.toJSONString(apiResult).getBytes(StandardCharsets.UTF_8);
        return returnValue(bits, exchange);
    }

    /**
     * 返回值转换
     * @param object
     * @param exchange
     * @return
     */
    public static Mono<Void> returnValue(Object object, ServerWebExchange exchange){
        // 自定义返回结果
        byte[] bits = JSON.toJSONString(object).getBytes(StandardCharsets.UTF_8);
        return returnValue(bits, exchange);
    }

    /**
     * 返回值
     * @param bits
     * @param exchange
     * @return
     */
    private static Mono<Void> returnValue(byte[] bits, ServerWebExchange exchange){
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bits);
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }

}
