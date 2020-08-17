package org.tiankafei.gateway.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.tiankafei.gateway.vo.GatewayRouteVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.constants.GatewayConstants;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class GatewayUtil {

    /**
     * 路径转换，主要是为了个配置文件中自定义的过滤进行匹配，
     * 之所以加入完整路径是因为，为了防止，不同服务，对应的后缀url一样的情况
     *
     * @param gatewayProperties
     * @param exchange
     * @return
     * @throws Exception
     */
    public static String pathConvert(GatewayProperties gatewayProperties, ServerWebExchange exchange) throws Exception {
        String path = exchange.getRequest().getPath().toString();
        if (path.startsWith("/api")) {
            GatewayRouteVo gatewayRouteVo = null;
            List<GatewayRouteVo> gatewayRouteVoList = joinGatewayRouteVoList(gatewayProperties);
            for (int index = 0, length = gatewayRouteVoList.size(); index < length; index++) {
                GatewayRouteVo tempGatewayRouteVo = gatewayRouteVoList.get(index);
                if (path.startsWith(tempGatewayRouteVo.getPathPrefix())) {
                    gatewayRouteVo = tempGatewayRouteVo;
                    break;
                }
            }
            if (gatewayRouteVo != null) {
                // 把服务名放在当前请求的上下文环境中
                String serviceName = gatewayRouteVo.getServiceName();
                exchange.getAttributes().put(GatewayConstants.SERVICE_PARAM_NAME, serviceName);
            } else {
                throw new Exception("根据当前路径没有找到对应的服务");
            }
            return path;
        } else {
            // 从当前的上下文请求环境上获取服务名
            Object object = exchange.getAttributes().get(GatewayConstants.SERVICE_PARAM_NAME);
            if (object != null) {
                String serviceName = object.toString();
                // 根据服务名，重新组装路径
                return pathJoinServiceName(gatewayProperties, path, serviceName);
            } else {
                // 服务名为空，抛出异常
                throw new Exception("根据当前路径没有找到对应的服务");
            }
        }
    }

    /**
     * 根据服务名，拼接路径
     *
     * @param gatewayProperties
     * @param path
     * @param serviceName
     * @return
     * @throws Exception
     */
    public static String pathJoinServiceName(GatewayProperties gatewayProperties, String path, String serviceName) throws Exception {
        if (path.startsWith("/api")) {
            return path;
        } else {
            GatewayRouteVo gatewayRouteVo = null;
            List<GatewayRouteVo> gatewayRouteVoList = joinGatewayRouteVoList(gatewayProperties);
            for (int index = 0, length = gatewayRouteVoList.size(); index < length; index++) {
                GatewayRouteVo tempGatewayRouteVo = gatewayRouteVoList.get(index);
                if (tempGatewayRouteVo.getServiceName().equalsIgnoreCase(serviceName)) {
                    gatewayRouteVo = tempGatewayRouteVo;
                    break;
                }
            }
            if (gatewayRouteVo != null) {
                return gatewayRouteVo.getPathPrefix() + path.substring(1);
            } else {
                throw new Exception();
            }
        }
    }

    /**
     * 組裝路由数据集合
     *
     * @param gatewayProperties
     * @return
     */
    private static List<GatewayRouteVo> joinGatewayRouteVoList(GatewayProperties gatewayProperties) {
        List<GatewayRouteVo> gatewayRouteVoList = Lists.newArrayList();

        List<RouteDefinition> routes = gatewayProperties.getRoutes();
        routes.stream().forEach(routeDefinition -> {
            GatewayRouteVo gatewayRouteVo = new GatewayRouteVo();
            String url = routeDefinition.getUri().toString();
            String serviceName = url.split("//")[1];
            gatewayRouteVo.setServiceName(serviceName);

            // 设置前缀截取路径的位数
            List<FilterDefinition> filters = routeDefinition.getFilters();
            filters.stream().forEach(filterDefinition -> {
                if ("StripPrefix".equalsIgnoreCase(filterDefinition.getName())) {
                    String stripPrefix = filterDefinition.getArgs().get("_genkey_0");
                    gatewayRouteVo.setStripPrefix(Integer.valueOf(stripPrefix));
                }
            });

            // 设置前置的url path
            List<PredicateDefinition> predicates = routeDefinition.getPredicates();
            predicates.stream().forEach(predicateDefinition -> {
                if ("Path".equalsIgnoreCase(predicateDefinition.getName())) {
                    int number = gatewayRouteVo.getStripPrefix() + 1;
                    String genkey = predicateDefinition.getArgs().get("_genkey_0");
                    String pathPrefix = splitPrefixPath(genkey, number);
                    gatewayRouteVo.setPathPrefix(pathPrefix);
                }
            });
            gatewayRouteVoList.add(gatewayRouteVo);
        });

        return gatewayRouteVoList;
    }

    /**
     * 按照位置切分前缀字符串路径
     *
     * @param path
     * @param number
     * @return
     */
    private static String splitPrefixPath(String path, int number) {
        StringBuilder split = new StringBuilder();
        int count = 0;
        for (int index = 0, length = path.length(); index < length; index++) {
            char c = path.charAt(index);
            split.append(c);
            if (c == '/') {
                count++;
            }
            if (count == number) {
                break;
            }
        }
        return split.toString();
    }

    /**
     * 返回值
     *
     * @param apiResult
     * @param exchange
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange) {
        return returnValue(apiResult, exchange, null);
    }

    /**
     * 返回值
     *
     * @param apiResult
     * @param exchange
     * @param httpStatus
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange, HttpStatus httpStatus) {
        return returnValue(apiResult, exchange, getDefaultCharset(), httpStatus);
    }

    /**
     * **
     * 返回值
     *
     * @param apiResult
     * @param exchange
     * @param charset
     * @param httpStatus
     * @return
     */
    public static Mono<Void> returnValue(ApiResult apiResult, ServerWebExchange exchange, Charset charset, HttpStatus httpStatus) {
        String contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + getDefaultCharset();
        if (charset != null) {
            contentType = MediaType.APPLICATION_JSON_VALUE + ";charset=" + charset;
        }

        // 自定义返回结果
        String returnBody = JSON.toJSONString(apiResult);
        byte[] byteArray = returnBody.getBytes(getDefaultCharset());
        ServerHttpResponse response = exchange.getResponse();

        DataBuffer buffer = response.bufferFactory().wrap(byteArray);
        // 从header中获取
        if (httpStatus != null) {
            response.setStatusCode(httpStatus);
        }
        response.getHeaders().add("Content-Type", contentType);
        return response.writeWith(Mono.just(buffer));
    }

    private static Charset getDefaultCharset() {
        return StandardCharsets.UTF_8;
    }

}
