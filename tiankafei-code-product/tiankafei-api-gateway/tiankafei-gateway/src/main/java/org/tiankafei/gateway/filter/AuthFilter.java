package org.tiankafei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.gateway.properties.ExclusionsUrlsProperties;
import org.tiankafei.gateway.utils.GatewayUtil;
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

    @Autowired
    private ExclusionsUrlsProperties exclusionsUrlsProperties;

    @Override
    protected Mono<Void> executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> authUrls = exclusionsUrlsProperties.getAuthUrls();
        String path = exchange.getRequest().getPath().toString();
        boolean flag = CommonUtil.checkUrlStartsWith(authUrls, path);
        if(flag){
            log.info("不需要鉴权的url：{}", path);
            return chain.filter(exchange);
        }else{
            // 目前随机鉴权成功或者失败
            //TODO 开始执行鉴权的逻辑
            ApiResult apiResult = executeAuth();
            if(apiResult == null){
                log.info("正在执行鉴权，鉴权通过的url：{}", path);
                return chain.filter(exchange);
            }else{
                log.error("正在执行鉴权，鉴权没有通过的url：{}", path);
                // 返回鉴权失败
                return GatewayUtil.returnValue(apiResult, exchange);
            }
        }
    }

    @Override
    public int getOrder() {
        return GatewayConstants.AUTH_FILTER_ORDER;
    }

    /**
     *  1.从请求参数中拿到用户id
     *  2.根据用户id去缓存中获取用户信息
     *  3.如果为空，则返回失败的数据
     *  4.如果不为空，则继续下一个过滤
     *
     * @return
     */
    private ApiResult executeAuth(){
        boolean flag = Boolean.TRUE;
        if(flag){
            // 鉴权通过
            return null;
        }else{
            // 鉴权失败
            return ApiResult.error(ExceptionEnum.LOGIN_AUTHENTICATION_EXCEPTION);
        }
    }
}
