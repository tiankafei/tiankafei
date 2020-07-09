package org.tiankafei.web.common.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 获取token
 *
 * @author 魏双双
 * @since 1.0
 **/
public interface QueryTokenService {

    /**
     * 获取token
     * @return
     */
    String getToken();

    /**
     * 从哪里获取token信息的类型
     * @return
     */
    Integer getType();

    /**
     * 获取request请求对戏
     * @return
     */
    default HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
