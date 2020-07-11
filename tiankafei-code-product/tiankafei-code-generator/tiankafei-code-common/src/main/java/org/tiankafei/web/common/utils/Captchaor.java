package org.tiankafei.web.common.utils;

import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.exception.VerificationException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
public class Captchaor {

    private int width;

    private int height;

    private int length;

    private OutputStream outputStream;

    /**
     * 生成验证码及图片
     *
     * @param outputStream
     * @return
     * @throws VerificationException
     */
    public static String buildImage(OutputStream outputStream) throws VerificationException {
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
    public static String buildImage(OutputStream outputStream, int width, int height, int length) throws VerificationException {
        return new Builder(outputStream).setWidth(width).setHeight(height).setLength(length).build().finish();
    }

    private String finish() throws VerificationException {
        try {
            String captcha = CaptchaCodeUtil.generateVerifyCode(length);
            CaptchaCodeUtil.outputImage(width, height, outputStream, captcha);
            return captcha;
        } catch (IOException e) {
            e.printStackTrace();
            throw new VerificationException(e.getMessage());
        }
    }

    private Captchaor(Builder builder){
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.outputStream = builder.outputStream;
    }

    @Data
    @Accessors(chain = true)
    private static class Builder {
        private int width = 160;
        private int height = 50;
        private int length = 5;
        private OutputStream outputStream;

        public Builder(OutputStream outputStream){
            this.outputStream = outputStream;
        }

        public Captchaor build(){
            return new Captchaor(this);
        }

    }

}
