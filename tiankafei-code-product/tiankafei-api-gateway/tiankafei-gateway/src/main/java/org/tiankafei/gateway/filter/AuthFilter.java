package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.GatewayConstants;
import org.tiankafei.web.common.enums.ExceptionEnum;
import org.tiankafei.web.common.utils.CommonUtil;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
public class AuthFilter extends GatewayFilter {
    @Override
    protected String getName() {
        return "鉴权";
    }

    @Override
    protected Mono<Void> checkFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Mono<Void> voidMono = super.checkFilter(exchange, chain);
        if (voidMono == null) {
            List<String> authUrls = exclusionsUrlsProperties.getAuthUrls();
            boolean flag = CommonUtil.checkUrlStartsWith(authUrls, currentPath);
            if (flag) {
                log.info("不需要{}的url：{}", getName(), currentPath);
                voidMono = chain.filter(exchange);
            }
        }
        return voidMono;
    }

    /**
     * 1.从请求参数中拿到用户id
     * 2.根据用户id去缓存中获取用户信息
     * 3.如果为空，则返回失败的数据
     * 4.如果不为空，则继续下一个过滤
     *
     * @return
     */
    @Override
    protected ApiResult executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean flag = RandomUtils.nextBoolean();
        if (flag) {
            // 鉴权通过
            return null;
        } else {
            // 鉴权失败
            return ApiResult.error(ExceptionEnum.LOGIN_AUTHENTICATION_EXCEPTION);
        }
    }

    @Override
    public int getOrder() {
        return GatewayConstants.AUTH_FILTER_ORDER;
    }

}
