package org.tiankafei.login.service;

import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
public interface QueryUserService {

    /**
     * 获取用户登录对象
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    UserLoginVo login(String keywords) throws LoginException;

    /**
     * 获取用户标识，
     *
     * @return
     */
    Integer getUserFlag();

}
