//package org.tiankafei.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.tiankafei.gateway.utils.GatewayUtil;
//import org.tiankafei.web.common.api.ApiResult;
//import org.tiankafei.web.common.constants.GatewayConstants;
//import org.tiankafei.web.common.enums.ExceptionEnum;
//import reactor.core.publisher.Mono;
//
///**
// * 限流过滤器
// *
// * @author tiankafei
// */
//@Slf4j
//@Component
//public class LimitedFilter extends GatewayFilter {
//
//    @Override
//    protected Mono<Void> executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //TODO 基于gateway的限流在这里执行，限流成功返回true，失败返回false
//        ApiResult apiResult = executeLimited();
//        if(apiResult == null){
//            log.info("正在执行限流，限流通过的url：{}", path);
//            return chain.filter(exchange);
//        }else{
//            log.error("正在执行限流，限流没有通过的url：{}", path);
//            // 返回限流失败
//            return GatewayUtil.returnValue(apiResult, exchange);
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return GatewayConstants.LIMITED_FILTER_ORDER;
//    }
//
//    private ApiResult executeLimited(){
//        boolean flag = RandomUtils.nextBoolean();
//        if(flag){
//            // 限流通过
//            return null;
//        }else{
//            // 限流失败
//            return ApiResult.error(ExceptionEnum.LOGIN_LIMITED_EXCEPTION);
//        }
//    }
//
//}
