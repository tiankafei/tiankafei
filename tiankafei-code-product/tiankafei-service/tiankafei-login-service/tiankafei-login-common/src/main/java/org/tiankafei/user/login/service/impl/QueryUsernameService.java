package org.tiankafei.user.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.service.QueryUserService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class QueryUsernameService implements QueryUserService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public SysUserLoginQueryVo login(String keywords) throws LoginException {
        SysUserLoginQueryVo sysUserLoginQueryVo = loginMapper.queryUserLoginFromUsername(keywords);
        return sysUserLoginQueryVo;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.USER_NAME.getCode();
    }
}
