package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.gateway.constants.GatewayConstants;
import org.tiankafei.gateway.properties.ExclusionsUrlsProperties;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class ExclusionsUrlFilter implements GlobalFilter, Ordered, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ExclusionsUrlsProperties exclusionsUrlsProperties = applicationContext.getBean(ExclusionsUrlsProperties.class);
        List<String> urls = exclusionsUrlsProperties.getUrls();

        boolean flag = false;
        String path = exchange.getRequest().getPath().toString();
        if(CollectionUtils.isNotEmpty(urls)){
            for (int index = 0, length = urls.size(); index < length; index++) {
                String url = urls.get(index);
                if(path.startsWith(url)){
                    flag = true;
                }
            }
        }
        exchange.getAttributes().put(GatewayConstants.EXCLUSTIONS_URL_FLAG, flag);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
