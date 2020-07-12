package org.tiankafei.user.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.user.login.service.QueryUserService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class QueryPhoneService implements QueryUserService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Boolean checkUserExists(String keywords) throws LoginException {
        SysUserLoginQueryVo sysUserLoginQueryVo = loginMapper.queryUserLoginFromTelephone(new LoginParamVo().setKeywords(keywords));
        return sysUserLoginQueryVo == null;
    }

    @Override
    public SysUserLoginQueryVo login(String keywords, String password) throws LoginException {
        SysUserLoginQueryVo sysUserLoginQueryVo = loginMapper.queryUserLoginFromTelephone(new LoginParamVo().setKeywords(keywords).setPassword(password));
        return sysUserLoginQueryVo;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.PHONE.getCode();
    }
}
