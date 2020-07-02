package org.tiankafei.web.common.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tiankafei.web.common.constants.CommonConstant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class ApiDocFilter implements Filter {

    private Environment environment;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        environment = ctx.getBean(Environment.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> profiles = Arrays.asList(activeProfiles);
        if(profiles.contains(CommonConstant.ACTIVE_PROFILE_DEV)){
            // 只有在开发模式才提供api文档支持
            chain.doFilter(request, response);
        }else{
//            // 重定向到错误页面
//            HttpServletResponse servletResponse = (HttpServletResponse) response;
//            servletResponse.sendRedirect("/apiDocError");

            // 请求转发到错误页面
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            servletRequest.getRequestDispatcher("/apiDocError").forward(request, response);
        }
    }

}
