package org.tiankafei.user.login.service;

import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface LoginService {

    /**
     * 登录
     *
     * @param loginParamVo
     * @return
     * @throws Exception
     */
    String login(LoginParamVo loginParamVo) throws Exception;

    /**
     * 注销
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}
