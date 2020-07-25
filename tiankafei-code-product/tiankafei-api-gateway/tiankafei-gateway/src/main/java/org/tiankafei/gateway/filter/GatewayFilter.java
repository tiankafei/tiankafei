//package org.tiankafei.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.http.HttpProperties;
//import org.springframework.cloud.gateway.config.GatewayProperties;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.web.server.ServerWebExchange;
//import org.tiankafei.gateway.properties.ExclusionsUrlsProperties;
//import org.tiankafei.gateway.utils.GatewayUtil;
//import org.tiankafei.web.common.api.ApiResult;
//import org.tiankafei.web.common.enums.ExceptionEnum;
//import org.tiankafei.web.common.utils.CommonUtil;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
///**
// * @author tiankafei
// * @since 1.0
// **/
//@Slf4j
//public abstract class GatewayFilter implements GlobalFilter, Ordered {
//
//    protected abstract String getName();
//
//    @Autowired
//    protected ExclusionsUrlsProperties exclusionsUrlsProperties;
//
//    @Autowired
//    protected HttpProperties httpProperties;
//
//    @Autowired
//    protected GatewayProperties gatewayProperties;
//
//    protected String currentPath;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        try {
//            String path = GatewayUtil.pathConvert(gatewayProperties, exchange);
//            this.currentPath = path;
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 请求路径错误
//            ApiResult apiResult = ApiResult.error(ExceptionEnum.REQUEST_URL_TOKEN_EXCEPTION);
//            return GatewayUtil.returnValue(apiResult, exchange);
//        }
//
//        // 执行过滤器校验是否需要执行
//        Mono<Void> voidMono = checkFilter(exchange, chain);
//        if (voidMono != null) {
//            return voidMono;
//        }
//
//        // 执行过滤
//        ApiResult apiResult = executeFilter(exchange, chain);
//        if (apiResult == null) {
//            // 执行其他过滤
//            log.info("正在执行{}，{}通过的url：{}", getName(), getName(), currentPath);
//            return chain.filter(exchange);
//        } else {
//            log.error("正在执行{}，{}没有通过的url：{}", getName(), getName(), currentPath);
//            // 过滤失败，返回结果
//            return GatewayUtil.returnValue(apiResult, exchange);
//        }
//    }
//
//    /**
//     * 当前过滤器是否需要执行，
//     * 如果需要执行，则返回null,
//     * 如果不需要执行，继续执行下一个过滤器，则chain.filter(exchange);
//     *
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    protected Mono<Void> checkFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        List<String> urls = exclusionsUrlsProperties.getUrls();
//        boolean flag = CommonUtil.checkUrlStartsWith(urls, currentPath);
//        if (flag) {
//            log.info("{} 没有执行过滤的url：{}", getName(), currentPath);
//            return chain.filter(exchange);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * 执行过滤
//     *
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    protected abstract ApiResult executeFilter(ServerWebExchange exchange, GatewayFilterChain chain);
//
//}
