package org.tiankafei.user.login.service;

import org.tiankafei.web.common.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 */
public interface VerificationService {

    /**
     * 生成验证码
     * @param request
     * @param response
     * @return
     * @throws VerificationException
     */
    String verificationCode(HttpServletRequest request, HttpServletResponse response) throws VerificationException;

}
