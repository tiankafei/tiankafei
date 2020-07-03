package org.tiankafei.gateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.gateway.constants.GatewayConstants;
import org.tiankafei.web.common.api.ApiResult;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean flag = (boolean) exchange.getAttributes().get(GatewayConstants.EXCLUSTIONS_URL_FLAG);
        String path = exchange.getRequest().getPath().toString();
        if(flag){
            log.info("不需要鉴权的url：{}", path);
            // 跳过url，该url不需要鉴权
            return chain.filter(exchange);
        }else{
            // 执行过滤
            ApiResult apiResult = executeFilter(exchange, chain);
            if(apiResult != null){
                log.error("正在执行鉴权，鉴权没有通过的url：{}", path);
                // 自定义返回结果
                byte[] bits = JSON.toJSONString(apiResult).getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bits);
                return exchange.getResponse().writeWith(Mono.just(buffer));
            }else{
                log.info("正在执行鉴权，鉴权通过的url：{}", path);
                // 继续下一个过滤
                return chain.filter(exchange);
            }
        }
    }

    /**
     * 执行过滤，
     * 如果过滤成功，返回null对象即可，
     * 如果不为空，则直接返回ApiResult对象
     *
     * @param chain
     * @param exchange
     * @return
     */
    protected abstract ApiResult executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) ;

}
