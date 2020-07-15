package org.tiankafei.user.login.service;

import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.param.CaptchaParamVo;

/**
 * @author tiankafei
 */
public interface CaptchaService {

    /**
     * 生成验证码
     *
     * @param uuid
     * @return
     * @throws VerificationException
     */
    CaptchaParamVo createCaptcha(String uuid) throws VerificationException;

    /**
     * 校验验证码
     *
     * @param uuid
     * @param captcha
     * @return
     * @throws VerificationException
     */
    boolean verifyCaptcha(String uuid, String captcha) throws VerificationException;

}
