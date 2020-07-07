package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.mapper.LoginMapper;
import org.tiankafei.user.service.GetLoginService;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class GetLoginMoreService implements GetLoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Boolean checkSysUserExists(String keywords) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("输入的用户账号不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper
                .and(i -> i.eq(SysUserLoginEntity::getUsername, keywords)
                        .or().eq(SysUserLoginEntity::getEmail, keywords)
                        .or().eq(SysUserLoginEntity::getTelephone, keywords));

        return loginMapper.selectCount(lambdaQueryWrapper) > 0;
    }

    @Override
    public SysUserLoginEntity getLoginEntity(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("输入的用户账号不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper
                .and(i -> i.eq(SysUserLoginEntity::getUsername, keywords)
                        .or().eq(SysUserLoginEntity::getEmail, keywords)
                        .or().eq(SysUserLoginEntity::getTelephone, keywords))
                .eq(SysUserLoginEntity::getPassword, password);

        SysUserLoginEntity userLoginEntity = loginMapper.selectOne(lambdaQueryWrapper);
        return userLoginEntity;
    }

    @Override
    public LoginEnums getLoginType() {
        return LoginEnums.MORE;
    }

}
