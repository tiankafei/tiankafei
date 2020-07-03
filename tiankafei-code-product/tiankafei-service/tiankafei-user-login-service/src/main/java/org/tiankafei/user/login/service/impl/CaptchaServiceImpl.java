package org.tiankafei.user.login.service.impl;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.web.common.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Override
    public Object createCaptcha(HttpServletRequest request, HttpServletResponse response) throws VerificationException {
        boolean finish = HappyCaptcha.require(request, response).build().finish();
        return finish;
    }

    @Override
    public boolean verifyCaptcha(String captcha, HttpServletRequest request) throws VerificationException {
        boolean flag = HappyCaptcha.verification(request, captcha,true);
        return flag;
    }

    @Override
    public void removeCaptcha(HttpServletRequest request) {
        HappyCaptcha.remove(request);
    }

}
