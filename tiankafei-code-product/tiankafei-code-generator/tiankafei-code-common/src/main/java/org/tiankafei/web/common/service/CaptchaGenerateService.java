package org.tiankafei.web.common.service;

import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.exception.VerificationException;

import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface CaptchaGenerateService {

    /**
     * 生成验证码及图片
     *
     * @param outputStream
     * @return
     * @throws VerificationException
     */
    default String buildImage(OutputStream outputStream) throws VerificationException {
        return buildImage(outputStream, 111, 36, 5);
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
    String buildImage(OutputStream outputStream, int width, int height, int length) throws VerificationException;

    /**
     * 获取验证码类型
     *
     * @return
     */
    CaptchaEnum getCaptchaType();

}
