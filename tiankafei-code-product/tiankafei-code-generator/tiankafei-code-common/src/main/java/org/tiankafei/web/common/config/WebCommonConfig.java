package org.tiankafei.web.common.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configurable
@ComponentScan(basePackages = "org.tiankafei.web.common")
public class WebCommonConfig {

    @Bean
    public PathMatcher pathMatcher(){
        PathMatcher pathMatcher = new AntPathMatcher();
        return pathMatcher;
    }

}
