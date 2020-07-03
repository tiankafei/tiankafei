package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.tiankafei.web.common.constants.GatewayConstants;
import org.tiankafei.gateway.properties.ExclusionsUrlsProperties;
import org.tiankafei.web.common.utils.CommonUtil;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class ExclusionsUrlFilter implements GlobalFilter, Ordered {

    @Autowired
    private ExclusionsUrlsProperties exclusionsUrlsProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> urls = exclusionsUrlsProperties.getUrls();
        String path = exchange.getRequest().getPath().toString();
        boolean flag = CommonUtil.checkUrlStartsWith(urls, path);
        exchange.getAttributes().put(GatewayConstants.EXCLUSTIONS_URL_FLAG, flag);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GatewayConstants.FIRST_FILTER_ORDER;
    }

}
