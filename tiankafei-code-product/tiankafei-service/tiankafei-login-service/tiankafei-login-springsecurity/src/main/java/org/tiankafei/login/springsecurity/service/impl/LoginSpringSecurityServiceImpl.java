package org.tiankafei.login.springsecurity.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.login.service.LoginService;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.exception.LoginException;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Service
public class LoginSpringSecurityServiceImpl implements LoginService {

    @Override
    public String login(LoginParamVo loginParamVo) throws Exception {
        return null;
    }

    @Override
    public void logout(String userId) throws LoginException {

    }
}
