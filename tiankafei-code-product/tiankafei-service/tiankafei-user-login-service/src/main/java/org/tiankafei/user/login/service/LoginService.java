package org.tiankafei.user.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface LoginService extends IService<LoginEntity> {

    /**
     * 登录
     *
     * @param loginQueryVo
     * @throws LoginException
     */
    void login(LoginQueryVo loginQueryVo, HttpServletRequest request) throws LoginException;

    /**
     * 注销
     *
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}
