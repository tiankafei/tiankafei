package org.tiankafei.web.common.service;

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

    Integer getType();

}
