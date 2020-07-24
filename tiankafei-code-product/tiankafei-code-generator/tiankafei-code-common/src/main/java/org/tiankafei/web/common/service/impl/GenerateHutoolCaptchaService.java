package org.tiankafei.web.common.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import java.io.OutputStream;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.CaptchaGenerateService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Service
public class GenerateHutoolCaptchaService implements CaptchaGenerateService {

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.HUTOOL;
    }

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(width, height, length, 4);
        captcha.write(outputStream);
        return captcha.getCode();
    }
}
