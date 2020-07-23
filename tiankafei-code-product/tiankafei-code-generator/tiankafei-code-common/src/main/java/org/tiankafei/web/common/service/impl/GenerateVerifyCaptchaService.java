package org.tiankafei.web.common.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.param.CaptchaVo;
import org.tiankafei.web.common.service.CaptchaGenerateService;
import org.tiankafei.web.common.utils.CaptchaUtil;
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
    public String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        try {
//            String captcha = VerifyCodeUtils.generateVerifyCode(length);
            CaptchaVo captcha = CaptchaUtil.getCaptcha(captchaTypeEnum);

            VerifyCodeUtils.outputImage(width, height, outputStream, captcha.getExpression());
            return captcha.getCaptcha();
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
