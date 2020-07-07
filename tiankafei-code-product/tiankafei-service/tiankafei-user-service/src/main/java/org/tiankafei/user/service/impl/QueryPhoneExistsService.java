package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.service.QueryUserExistsService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.web.common.exception.UserException;

@Service
public class QueryPhoneExistsService implements QueryUserExistsService {

    @Autowired
    private SysUserLoginService userLoginService;

    @Override
    public Boolean checkAddSysUserExists(String keywords) throws UserException {
        if(StringUtils.isBlank(keywords)){
            return Boolean.FALSE;
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserLoginEntity::getTelephone, keywords);
        int count = userLoginService.count(lambdaQueryWrapper);
        boolean exists = count > 0;
        if(exists){
            throw new UserException("手机号码已经存在，请重新输入！");
        }
        return Boolean.FALSE;
    }

    @Override
    public Integer getUserFlag() {
        return LoginEnums.PHONE.getCode();
    }
}
