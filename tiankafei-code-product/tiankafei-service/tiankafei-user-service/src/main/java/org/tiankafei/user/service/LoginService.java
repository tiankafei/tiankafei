package org.tiankafei.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.param.LoginParamVo;
import org.tiankafei.web.common.exception.LoginException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface LoginService extends IService<SysUserLoginEntity> {

    /**
     * 登录
     *
     * @param loginParamVo
     * @throws LoginException
     */
    String login(LoginParamVo loginParamVo, HttpServletRequest request) throws Exception;

    /**
     * 注销
     *
     * @param userId
     * @throws LoginException
     */
    void logout(String userId) throws LoginException;

}
