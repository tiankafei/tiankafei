package org.tiankafei.user.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import javax.servlet.http.HttpServletRequest;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.login.param.LoginParamVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface LoginService extends IService<LoginEntity> {

    /**
     * 登录
     *
     * @param loginParamVo
     * @throws LoginException
     */
    void login(LoginParamVo loginParamVo, HttpServletRequest request) throws LoginException;

    /**
     * 注销
     *
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}
