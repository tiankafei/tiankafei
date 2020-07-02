package org.tiankafei.user.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface LoginService extends IService<LoginQueryVo> {

    /**
     * 登录
     * @param loginQueryVo
     * @throws LoginException
     */
    void login(LoginQueryVo loginQueryVo) throws LoginException;

    /**
     * 注销
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}
