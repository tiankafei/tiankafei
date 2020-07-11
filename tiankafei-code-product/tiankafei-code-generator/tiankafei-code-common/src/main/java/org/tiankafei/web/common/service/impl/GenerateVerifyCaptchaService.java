package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.CaptchaGenerateService;
import org.tiankafei.web.common.utils.VerifyCodeUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
@Service
public class GenerateVerifyCaptchaService implements CaptchaGenerateService {

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length) throws VerificationException {
        try {
            String captcha = VerifyCodeUtils.generateVerifyCode(length);
            VerifyCodeUtils.outputImage(width, height, outputStream, captcha);
            return captcha;
        } catch (IOException e) {
            e.printStackTrace();
            throw new VerificationException(e.getMessage());
        }
    }

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.RUO_YI_UTIL;
    }
}
