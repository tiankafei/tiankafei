package org.tiankafei.user.login.service;

import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

public interface QueryUserService {

    /**
     * 登录时验证用户是否存在
     *
     * @param keywords
     * @return
     * @throws LoginException
     */
    Boolean checkUserExists(String keywords) throws LoginException;

    /**
     * 获取用户登录对象
     *
     * @param keywords
     * @param password
     * @return
     * @throws LoginException
     */
    SysUserLoginQueryVo login(String keywords, String password) throws LoginException;

    /**
     * 获取用户标识，
     *
     * @return
     */
    Integer getUserFlag();

}
