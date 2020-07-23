package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.CaptchaGenerateService;
import org.tiankafei.web.common.utils.CaptchaUtil;
import org.tiankafei.web.common.utils.DefaultHappyCaptcha;

import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
@Service
public class GenerateHappyCaptchaService implements CaptchaGenerateService {

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        String captchaCode = DefaultHappyCaptcha.require(outputStream).width(width).height(height).length(length).type(CaptchaUtil.getCaptchaType(captchaTypeEnum)).build().finish();
        return captchaCode;
    }

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.HAPPY_CAPTCHA;
    }

}
