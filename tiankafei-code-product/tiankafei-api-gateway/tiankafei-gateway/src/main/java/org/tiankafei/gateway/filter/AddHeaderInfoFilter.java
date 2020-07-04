package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.constants.GatewayConstants;
import org.tiankafei.web.common.utils.SequenceUtil;
import reactor.core.publisher.Mono;

/**
 * 添加头信息
 *
 * @author tiankafei
 */
@Slf4j
@Component
public class AddHeaderInfoFilter extends GatewayFilter {
    @Override
    protected Mono<Void> executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String value = SequenceUtil.generatorStrId();
        log.info("执行了添加header信息的过滤器：添加的header值为：{}", value);
        //向headers中添加属性，记得build
        ServerHttpRequest host = exchange.getRequest().mutate().header(GatewayConstants.ADD_HREADER_PARAM_NAME, value).build();
        //将现在的request 变成 change对象
        ServerWebExchange build = exchange.mutate().request(host).build();
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return GatewayConstants.ADD_HEADER_FILTER_ORDER;
    }
}
