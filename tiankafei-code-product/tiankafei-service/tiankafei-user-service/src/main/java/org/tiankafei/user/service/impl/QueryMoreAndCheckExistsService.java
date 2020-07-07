package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.service.QueryUserAndCheckExistsService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.UserException;

@Service
public class QueryMoreAndCheckExistsService implements QueryUserAndCheckExistsService {

    @Autowired
    private SysUserLoginService userLoginService;

    /**
     * 验证新增时用户帐号是否存在
     * @param keywords
     * @return
     * @throws UserException
     */
    @Override
    public Boolean checkAddSysUserExists(String keywords) throws UserException {
        return Boolean.FALSE;
    }

    /**
     * 验证登录时用户帐号是否存在
     * @param keywords
     * @return
     * @throws LoginException
     */
    @Override
    public Boolean checkLoginSysUserExists(String keywords) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("输入的用户账号不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper
                .and(i -> i.eq(SysUserLoginEntity::getUsername, keywords)
                        .or().eq(SysUserLoginEntity::getEmail, keywords)
                        .or().eq(SysUserLoginEntity::getTelephone, keywords));

        return userLoginService.count(lambdaQueryWrapper) > 0;
    }

    @Override
    public SysUserLoginQueryVo getSysUserLoginQueryVo(String keywords, String password) throws LoginException {
        if (StringUtils.isBlank(keywords)) {
            throw new LoginException("输入的用户账号不能为空");
        }
        LambdaQueryWrapper<SysUserLoginEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper
                .and(i -> i.eq(SysUserLoginEntity::getUsername, keywords)
                        .or().eq(SysUserLoginEntity::getEmail, keywords)
                        .or().eq(SysUserLoginEntity::getTelephone, keywords))
                .eq(SysUserLoginEntity::getPassword, password);

        SysUserLoginEntity sysUserLoginEntity = userLoginService.getOne(lambdaQueryWrapper);
        return getSysUserLoginQueryVo(sysUserLoginEntity);
    }

    @Override
    public Integer getUserFlag() {
        return LoginEnums.MORE.getCode();
    }
}
