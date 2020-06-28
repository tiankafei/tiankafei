package org.tiankafei.springbootdemo.config;

import org.tiankafei.springbootdemo.filter.SpringBootCustomFilter;
import org.tiankafei.springbootdemo.filter.SpringBootFilter;
import org.tiankafei.springbootdemo.listener.SpringBootListener;
import org.tiankafei.springbootdemo.servlet.SpringBootServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Configuration
public class SpringBootConfig {

    @Bean
    public ServletRegistrationBean<SpringBootServlet> springBootServlet(){
        ServletRegistrationBean<SpringBootServlet> bean = new ServletRegistrationBean<>(new SpringBootServlet());
        bean.setLoadOnStartup(1);
        bean.addUrlMappings("/hello");
        bean.setOrder(1);
        bean.setName("springBootServlet");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<SpringBootFilter> springBootFilter(){
        FilterRegistrationBean<SpringBootFilter> bean = new FilterRegistrationBean<>(new SpringBootFilter());
        bean.setOrder(1);
        bean.addUrlPatterns("/hello");
        bean.setName("springBootFilter");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<SpringBootCustomFilter> springBootCustomFilter(){
        FilterRegistrationBean<SpringBootCustomFilter> bean = new FilterRegistrationBean<>(new SpringBootCustomFilter());
        bean.setOrder(2);
        bean.addUrlPatterns("/hello");
        bean.setName("springBootCustomFilter");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<SpringBootListener> springBootListener(){
        ServletListenerRegistrationBean<SpringBootListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new SpringBootListener());
        bean.setOrder(1);
        return bean;
    }

}
