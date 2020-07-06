package org.tiankafei.user.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class GetLoginMoreService implements GetLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginEntity getLoginEntity(LoginQueryVo loginQueryVo) throws LoginException {
        String keywords = loginQueryVo.getUserAccount();
        String password = loginQueryVo.getPassword();
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("输入的用户账号不能为空");
        }
        LambdaQueryWrapper<LoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper
                .and(i -> i.eq(LoginEntity::getUsername, keywords)
                        .or().eq(LoginEntity::getEmail, keywords)
                        .or().eq(LoginEntity::getTelephone, keywords))
                .eq(LoginEntity::getPassword, password);

        LoginEntity loginEntity = loginMapper.selectOne(lambdaQueryWrapper);
        return loginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.MORE;
    }

}
