package org.tiankafei.web.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.tiankafei.web.common.config.TokenConfig;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class BaseController {

    @Autowired
    protected TokenConfig tokenConfig;

    /**
     * 获取token
     *
     * @return
     */
    public String getToken() {
        return tokenConfig.getToken();
    }

    /**
     * 获取当前请求
     *
     * @return request
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取当前请求
     *
     * @return response
     */
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

}
