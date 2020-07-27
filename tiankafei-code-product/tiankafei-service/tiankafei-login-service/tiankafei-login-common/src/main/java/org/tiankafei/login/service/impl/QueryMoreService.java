package org.tiankafei.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.login.mapper.LoginMapper;
import org.tiankafei.login.service.QueryUserService;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class QueryMoreService implements QueryUserService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public SysUserLoginQueryVo login(String keywords) throws LoginException {
        SysUserLoginQueryVo sysUserLoginQueryVo = loginMapper.queryUserLoginFromMore(keywords);
        return sysUserLoginQueryVo;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.MORE.getCode();
    }
}
