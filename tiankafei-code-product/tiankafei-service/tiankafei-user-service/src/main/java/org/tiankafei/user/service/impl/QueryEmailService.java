package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.service.QueryUserService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;

@Service
public class QueryEmailService implements QueryUserService {

    @Autowired
    private SysUserLoginService userLoginService;

    @Override
    public Boolean checkUserExists(String keywords) throws LoginException {
        return userLoginService.count(getLambdaQueryWrapper(keywords)) > 0;
    }

    @Override
    public SysUserLoginQueryVo login(String keywords, String password) throws LoginException {
        SysUserLoginEntity sysUserLoginEntity = userLoginService.getOne(getLambdaQueryWrapper(keywords, password));
        return switchObject(sysUserLoginEntity);
    }

    @Override
    public LambdaQueryWrapper<SysUserLoginEntity> getLambdaQueryWrapper(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("邮箱不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(keywords)) {
            lambdaQueryWrapper.eq(SysUserLoginEntity::getEmail, keywords);
        }
        if (StringUtils.isNotBlank(password)) {
            lambdaQueryWrapper.eq(SysUserLoginEntity::getPassword, password);
        }
        return lambdaQueryWrapper;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.EMAIL.getCode();
    }
}
