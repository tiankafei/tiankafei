package org.tiankafei.user.login.service;

import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.login.param.LoginQueryVo;
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
     * @param loginQueryVo
     * @return
     */
    LoginEntity getLoginEntity(LoginQueryVo loginQueryVo) throws LoginException;

    /**
     * 获取登录类型
     *
     * @return
     */
    LoginEnums getLoginType();

}
