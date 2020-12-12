package org.tiankafei.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @introduce: SwaggerProvider
 * @author: lk
 * @date: 2020/6/4
 **/
@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {

    public static final String API_URI = "/v2/api-docs";
    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        //取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition))));
        return resources;
    }

    private SwaggerResource swaggerResource(RouteDefinition routeDefinition) {
        FilterDefinition filterDefinition = routeDefinition.getFilters().get(0);
        Map<String, String> filterDefinitionArgs = filterDefinition.getArgs();
        String stripPrefix = filterDefinitionArgs.get("_genkey_0");

        PredicateDefinition predicateDefinition = routeDefinition.getPredicates().get(0);
        Map<String, String> predicateDefinitionArgs = predicateDefinition.getArgs();
        String url = predicateDefinitionArgs.get("_genkey_0");

        StringBuffer urlPrefix = new StringBuffer();
        String[] split = url.split("/");
        for (int i = 1; i <= Integer.valueOf(stripPrefix); i++) {
            urlPrefix.append("/").append(split[i]);
        }
        urlPrefix.append("/v2/api-docs");

        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(routeDefinition.getId());
        swaggerResource.setLocation(urlPrefix.toString());
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;

    }
}