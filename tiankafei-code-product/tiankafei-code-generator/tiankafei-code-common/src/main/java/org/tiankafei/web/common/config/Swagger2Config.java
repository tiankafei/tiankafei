package org.tiankafei.web.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.properties.SwaggerProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Profile(CommonConstant.ACTIVE_PROFILE_DEV)
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

    @Autowired
    protected Environment environment;

    @Resource
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        boolean devFlag = Boolean.FALSE;
        List<String> profiles = Arrays.asList(environment.getActiveProfiles());
        for (int index = 0, length = profiles.size(); index < length; index++) {
            String profile = profiles.get(index);
            if(CommonConstant.ACTIVE_PROFILE_DEV.equalsIgnoreCase(profile)){
                devFlag = Boolean.TRUE;
            }
        }
        return new Docket(DocumentationType.SWAGGER_2)
                // 是否启用Swagger
                .enable(devFlag)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("org.tiankafei"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title(swaggerProperties.getTitle())
                // 描述
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl(swaggerProperties.getUrl())
                // 作者信息
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                // 版本
                .version(swaggerProperties.getVersion())
                .build();
    }

}