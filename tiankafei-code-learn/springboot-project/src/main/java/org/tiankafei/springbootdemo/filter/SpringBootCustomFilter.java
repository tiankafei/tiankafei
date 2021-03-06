package org.tiankafei.springbootdemo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Slf4j
//@WebFilter(filterName = "springBootCustomFilter", urlPatterns = "/*")
public class SpringBootCustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("执行了 springBootCustomFilter 的初始化--------------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("执行了 springBootCustomFilter 的过滤：doFilter--------------------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
