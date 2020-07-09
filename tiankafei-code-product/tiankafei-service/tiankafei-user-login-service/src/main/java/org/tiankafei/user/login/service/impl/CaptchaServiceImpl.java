package org.tiankafei.user.login.service.impl;

import com.ramostear.captcha.HappyCaptcha;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.web.common.exception.VerificationException;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class CaptchaServiceImpl implements CaptchaService {

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @return
     * @throws VerificationException
     */
    @Override
    public Object createCaptcha(HttpServletRequest request, HttpServletResponse response) throws VerificationException {
        // 先删除
        removeCaptcha(request);
        // 再创建
        boolean finish = HappyCaptcha.require(request, response).build().finish();
        return finish;
    }

    /**
     * 校验验证码
     *
     * @param captcha
     * @param request
     * @return
     * @throws VerificationException
     */
    @Override
    public boolean verifyCaptcha(String captcha, HttpServletRequest request) throws VerificationException {
        boolean flag = HappyCaptcha.verification(request, captcha, true);
        return flag;
    }

    /**
     * 删除验证码
     *
     * @param request
     */
    @Override
    public void removeCaptcha(HttpServletRequest request) {
        HappyCaptcha.remove(request);
    }

}
