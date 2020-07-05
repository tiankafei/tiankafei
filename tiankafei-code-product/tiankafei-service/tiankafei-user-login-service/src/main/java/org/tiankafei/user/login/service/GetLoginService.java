package org.tiankafei.user.login.service;

import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.web.common.exception.LoginException;

/**
 * 获取登录信息
 *
 * @author tiankafei
 */
public interface GetLoginService {

    /**
     * 获取用户登录信息对象
     *
     * @param keywords
     * @param passwrod
     * @return
     */
    LoginEntity getLoginEntity(String keywords, String passwrod) throws LoginException;

}
