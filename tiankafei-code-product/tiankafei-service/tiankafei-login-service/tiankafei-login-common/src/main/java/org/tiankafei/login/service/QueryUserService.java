package org.tiankafei.login.service;

import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

public interface QueryUserService {

    /**
     * 获取用户登录对象
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    SysUserLoginQueryVo login(String keywords) throws LoginException;

    /**
     * 获取用户标识，
     *
     * @return
     */
    Integer getUserFlag();

}
