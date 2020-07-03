package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.api.ApiResult;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class AuthFilter extends GatewayFilter {

    /**
     *  1.从请求参数中拿到用户id
     *  2.根据用户id去缓存中获取用户信息
     *  3.如果为空，则返回失败的数据
     *  4.如果不为空，则继续下一个过滤
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    protected ApiResult executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return null;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
