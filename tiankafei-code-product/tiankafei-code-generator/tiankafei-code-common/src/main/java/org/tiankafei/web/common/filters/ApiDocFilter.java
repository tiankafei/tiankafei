package org.tiankafei.web.common.filters;

import com.ruoyi.common.swagger.config.SwaggerProperties;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Component
@Order(value = 2)
@WebFilter(filterName = "apiDocFilter", urlPatterns = {"/doc", "/docs", "/doc.html", "/swagger-ui.html"})
public class ApiDocFilter implements Filter {

    private SwaggerProperties swaggerProperties;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        swaggerProperties = ctx.getBean(SwaggerProperties.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (swaggerProperties.getEnabled()) {
            // 只有在开发模式才提供api文档支持
            chain.doFilter(request, response);
        } else {
            ///
//            // 重定向到错误页面
//            HttpServletResponse servletResponse = (HttpServletResponse) response;
//            servletResponse.sendRedirect("/apiDocError");

            // 请求转发到错误页面
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            servletRequest.getRequestDispatcher("/apiDocError").forward(request, response);
        }
    }

}
