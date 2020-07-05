//package org.tiankafei.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpCookie;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.tiankafei.gateway.utils.GatewayUtil;
//import org.tiankafei.web.common.api.ApiResult;
//import org.tiankafei.web.common.constants.GatewayConstants;
//import org.tiankafei.web.common.enums.ExceptionEnum;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Component
//public class TokenFilter extends GatewayFilter {
//
//    @Override
//    protected Mono<Void> executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //TODO 基于gateway的token验证在这里执行，token验证成功返回true，失败返回false
//        ApiResult apiResult = executeToken(exchange, chain);
//        if(apiResult == null){
//            log.info("正在执行token验证，token验证通过的url：{}", path);
//            return chain.filter(exchange);
//        }else{
//            log.error("正在执行token验证，token验证没有通过的url：{}", path);
//            // 返回token验证失败
//            return GatewayUtil.returnValue(apiResult, exchange, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    private ApiResult executeToken(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//
//        // 从请求参数中获取
//        String token = request.getQueryParams().getFirst(GatewayConstants.TOKEN_PARAM_NAME);
//        if(StringUtils.isBlank(token)){
//            if(StringUtils.isBlank(token)){
//                // 从cookies中获取
//                HttpCookie first = request.getCookies().getFirst(GatewayConstants.TOKEN_PARAM_NAME);
//                if(first != null){
//                    token = first.getValue();
//                    if(StringUtils.isBlank(token)){
//                        // 从header中获取
//                        token = request.getHeaders().getFirst(GatewayConstants.TOKEN_PARAM_NAME);
//                    }
//                }
//            }
//        }
//
//        if(StringUtils.isBlank(token)){
//            // token验证失败
//            return ApiResult.error(ExceptionEnum.LOGIN_LIMITED_EXCEPTION);
//        }else{
//            // token验证通过
//            return null;
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return GatewayConstants.TOKEN_FILTER_ORDER;
//    }
//}
