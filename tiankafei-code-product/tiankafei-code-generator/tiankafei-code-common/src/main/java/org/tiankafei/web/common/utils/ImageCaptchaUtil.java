package org.tiankafei.web.common.utils;

import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.core.AnimCaptcha;
import com.ramostear.captcha.core.Captcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.tiankafei.web.common.enums.CommonEnum;
import org.tiankafei.web.common.exception.VerificationException;

import java.awt.Font;
import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ImageCaptchaUtil {

    private CaptchaType type;
    private CaptchaStyle style;
    private Font font;
    private int width;
    private int height;
    private int length;
    private OutputStream outputStream;

    public static Builder require(OutputStream outputStream){
        return new Builder(outputStream);
    }

    /**
     * 获取验证码的key值
     * @param uuid
     * @return
     */
    public static String getCaptchaKey(String uuid){
        return CommonEnum.CAPTCHA_CODE_KEY.getCode() + uuid;
    }

    public String finish() throws VerificationException {
        try {
            if(this.style.equals(CaptchaStyle.IMG)){
                Captcha captcha = new Captcha();
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                String captchaCode = captcha.getCaptchaCode();
                captcha.render(outputStream);
                return captchaCode;
            }else if(this.style.equals(CaptchaStyle.ANIM)){
                AnimCaptcha captcha = new AnimCaptcha();
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                String captchaCode = captcha.getCaptchaCode();
                captcha.render(outputStream);
                return captchaCode;
            }else{
                throw new VerificationException("验证码生成错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new VerificationException("验证码生成错误");
        }

    }

    private ImageCaptchaUtil(Builder builder){
        this.type = builder.type;
        this.style = builder.style;
        this.font = builder.font;
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.outputStream = builder.outputStream;
    }

    public static class Builder{
        private CaptchaType type = CaptchaType.DEFAULT;
        private CaptchaStyle style = CaptchaStyle.IMG;
        private Font font = Fonts.getInstance().defaultFont();
        private int width = 160;
        private int height = 50;
        private int length = 5;
        private OutputStream outputStream;

        public Builder(OutputStream outputStream){
            this.outputStream = outputStream;
        }

        public ImageCaptchaUtil build(){
            return new ImageCaptchaUtil(this);
        }

        public ImageCaptchaUtil.Builder type(CaptchaType type){
            this.type = type;
            return this;
        }

        public ImageCaptchaUtil.Builder style(CaptchaStyle style){
            this.style = style;
            return this;
        }

        public ImageCaptchaUtil.Builder width(int width){
            this.width = width;
            return this;
        }

        public ImageCaptchaUtil.Builder height(int height){
            this.height = height;
            return this;
        }

        public ImageCaptchaUtil.Builder length(int length){
            this.length = length;
            return this;
        }
        public ImageCaptchaUtil.Builder font(Font font){
            this.font = font;
            return this;
        }
    }

}
