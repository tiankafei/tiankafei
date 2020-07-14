package org.tiankafei.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.service.CheckExistService;
import org.tiankafei.user.service.SysUserLoginService;
import org.tiankafei.web.common.exception.UserException;

@Service
public class CheckMoreExistService implements CheckExistService {

    @Autowired
    private SysUserLoginService userLoginService;

    /**
     * 验证新增时用户帐号是否存在
     *
     * @param keywords
     * @return
     * @throws UserException
     */
    @Override
    public Boolean checkAddSysUserExists(String keywords) throws UserException {
        return Boolean.FALSE;
    }

    @Override
    public Integer getUserFlag() {
        return UserEnums.MORE.getCode();
    }
}
