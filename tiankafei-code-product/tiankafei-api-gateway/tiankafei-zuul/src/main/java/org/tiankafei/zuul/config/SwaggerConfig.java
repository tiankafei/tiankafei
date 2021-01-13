package org.tiankafei.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.constants.CommonConstants;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 网关配置swagger服务
 *
 * @author 甜咖啡
 */
@EnableSwagger2
@Component
public class SwaggerConfig {

    @Autowired
    private ZuulProperties properties;

    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            Collection<ZuulProperties.ZuulRoute> values = properties.getRoutes().values();
            values.stream().forEach(route -> resources.add(createResource(route.getServiceId(), route.getServiceId(), "2.0")));
            return resources;
        };
    }

    private SwaggerResource createResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation("/api/" + location + CommonConstants.SWAGGER_PREFIX_URL_V2);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}