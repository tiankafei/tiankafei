package org.tiankafei.web.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tiankafei.web.common.filters.ApiDocFilter;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configuration
public class CommonWebConfig {

    @Bean
    public FilterRegistrationBean<ApiDocFilter> apiDocFilter() {
        FilterRegistrationBean<ApiDocFilter> bean = new FilterRegistrationBean<>(new ApiDocFilter());
        bean.setOrder(2);
        bean.addUrlPatterns("/doc");
        bean.addUrlPatterns("/docs");
        bean.addUrlPatterns("/doc.html");
        bean.addUrlPatterns("/swagger-ui.html");
        bean.setName("apiDocFilter");
        return bean;
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
//        corsConfiguration.setMaxAge(300L);
//
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

}
