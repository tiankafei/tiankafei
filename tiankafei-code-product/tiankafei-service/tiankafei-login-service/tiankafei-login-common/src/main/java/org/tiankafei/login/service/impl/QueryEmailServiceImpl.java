package org.tiankafei.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.login.mapper.LoginMapper;
import org.tiankafei.login.service.QueryUserService;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class QueryEmailServiceImpl implements QueryUserService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserLoginVo login(String keywords) throws LoginException {
        UserLoginVo userLoginVo = loginMapper.queryUserLoginFromEmail(keywords);
        return userLoginVo;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.EMAIL.getCode();
    }
}
