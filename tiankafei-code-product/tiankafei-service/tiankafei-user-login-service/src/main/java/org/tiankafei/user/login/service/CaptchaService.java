package org.tiankafei.user.login.service;

import org.tiankafei.web.common.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 */
public interface CaptchaService {

    /**
     * 生成验证码
     * @param request
     * @param response
     * @return
     * @throws VerificationException
     */
    Object createCaptcha(HttpServletRequest request, HttpServletResponse response) throws VerificationException;

    /**
     * 校验验证码
     * @param captcha
     * @param request
     * @return
     * @throws VerificationException
     */
    boolean verifyCaptcha(String captcha, HttpServletRequest request) throws VerificationException;

    /**
     * 删除验证码
     * @param request
     */
    void removeCaptcha(HttpServletRequest request);

}