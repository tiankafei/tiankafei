package org.tiankafei.user.login.service;

import javax.servlet.http.HttpServletRequest;
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
     * @throws LoginException
     */
    String login(LoginParamVo loginParamVo, HttpServletRequest request) throws Exception;

    /**
     * 注销
     *
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}