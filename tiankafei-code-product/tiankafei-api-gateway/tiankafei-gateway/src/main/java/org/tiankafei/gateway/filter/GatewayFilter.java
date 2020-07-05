//package org.tiankafei.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.web.server.ServerWebExchange;
//import org.tiankafei.gateway.utils.GatewayUtil;
//import org.tiankafei.web.common.constants.GatewayConstants;
//import reactor.core.publisher.Mono;
//
///**
// * @author tiankafei
// * @since 1.0
// **/
//@Slf4j
//public abstract class GatewayFilter implements GlobalFilter, Ordered {
//
//    protected String path;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        boolean flag = GatewayUtil.checkIsExecuteFilter(exchange);
//        String path = exchange.getRequest().getPath().toString();
//        this.path = path;
//        if(flag){
//            log.info("不需要过滤的url：{}", path);
//            // 跳过url，该url不需要鉴权
//            return chain.filter(exchange);
//        }else{
//            // 执行过滤
//            return executeFilter(exchange, chain);
//        }
//    }
//
//    /**
//     * 执行过滤，
//     * 如果过滤成功，返回null对象即可，
//     * 如果不为空，则直接返回ApiResult对象
//     *
//     * @param chain
//     * @param exchange
//     * @return
//     */
//    protected abstract Mono<Void> executeFilter(ServerWebExchange exchange, GatewayFilterChain chain) ;
//
//}
