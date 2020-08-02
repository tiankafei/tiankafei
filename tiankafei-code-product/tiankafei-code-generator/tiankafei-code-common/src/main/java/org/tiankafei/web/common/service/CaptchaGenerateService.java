package org.tiankafei.web.common.service;

import java.io.OutputStream;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface CaptchaGenerateService {

    /**
     * 获取验证码类型
     *
     * @return
     */
    CaptchaEnum getCaptchaType();

    /**
     * 生成验证码及图片
     *
     * @param outputStream
     * @return
     * @throws VerificationException
     */
    default String buildImage(OutputStream outputStream) throws VerificationException {
        return buildImage(outputStream, 111, 36, 5, CaptchaTypeEnum.DEFAULT);
    }

    /**
     * 生成验证码及图片
     *
     * @param outputStream
     * @param width
     * @param height
     * @param length
     * @return
     * @throws VerificationException
     */
    String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException;

}
