package org.tiankafei.user.login.service;

import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.web.common.exception.LoginException;

/**
 * 获取登录信息
 *
 * @author tiankafei
 */
public interface GetLoginService {

    /**
     * 登录时验证用户是否存在
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    Boolean checkSysUserExists(String keywords) throws LoginException;

    /**
     * 获取用户登录信息对象
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    SysUserLoginEntity getLoginEntity(String keywords, String password) throws LoginException;

    /**
     * 获取登录类型
     *
     * @return
     */
    LoginEnums getLoginType();

}
