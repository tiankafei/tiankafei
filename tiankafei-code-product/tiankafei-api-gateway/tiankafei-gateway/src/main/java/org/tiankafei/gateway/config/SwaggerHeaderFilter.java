package org.tiankafei.gateway.config;

import com.ruoyi.common.swagger.constants.SwaggerConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @introduce: swagger请求头过滤器
 * @author: lk
 * @date: 2020/6/4
 **/
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {

    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerConstants.SWAGGER_PREFIX_URL_V2)) {
                return chain.filter(exchange);
            }
            String basePath = path.substring(0, path.lastIndexOf(SwaggerConstants.SWAGGER_PREFIX_URL_V2));
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}