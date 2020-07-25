//package org.tiankafei.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.tiankafei.web.common.api.ApiResult;
//import org.tiankafei.web.common.constants.GatewayConstants;
//import org.tiankafei.web.common.enums.ExceptionEnum;
//
///**
// * 限流过滤器
// *
// * @author tiankafei
// */
//@Slf4j
//@Component
//public class LimitedFilter extends GatewayFilter {
//    @Override
//    protected String getName() {
//        return "限流";
//    }
//
//    @Override
//    protected ApiResult executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        boolean flag = RandomUtils.nextBoolean();
//        if (flag) {
//            // 限流通过
//            return null;
//        } else {
//            // 限流失败
//            return ApiResult.error(ExceptionEnum.LOGIN_LIMITED_EXCEPTION);
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return GatewayConstants.LIMITED_FILTER_ORDER;
//    }
//
//}
