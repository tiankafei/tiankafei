package org.tiankafei.web.common.utils;

import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import java.awt.Font;
import java.io.OutputStream;
import org.tiankafei.web.common.param.CaptchaVo;

/**
 * @author tiankafei
 * @since 1.0
 */
public class DefaultHappyCaptcha {

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

    public String finish() {
        try {
            CaptchaVo captchaVo = CaptchaUtil.getCaptcha(this.type);
            if(this.style.equals(CaptchaStyle.IMG)){
                DefaultCaptcha captcha = new DefaultCaptcha(captchaVo.getExpression());
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                captcha.render(this.outputStream);
                return captchaVo.getCaptcha();
            }else if(this.style.equals(CaptchaStyle.ANIM)){
                DefaultAnimCaptcha captcha = new DefaultAnimCaptcha(captchaVo.getExpression());
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                captcha.render(this.outputStream);
                return captchaVo.getCaptcha();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private DefaultHappyCaptcha(Builder builder){
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
        private Font font = Fonts.getInstance().zhFont();
        private int width = 160;
        private int height = 50;
        private int length = 5;
        private final OutputStream outputStream;

        public Builder(OutputStream outputStream){
            this.outputStream = outputStream;
        }

        public DefaultHappyCaptcha build(){
            return new DefaultHappyCaptcha(this);
        }

        public Builder type(CaptchaType type){
            this.type = type;
            return this;
        }

        public Builder style(CaptchaStyle style){
            this.style = style;
            return this;
        }

        public Builder width(int width){
            this.width = width;
            return this;
        }

        public Builder height(int height){
            this.height = height;
            return this;
        }

        public Builder length(int length){
            this.length = length;
            return this;
        }
        public Builder font(Font font){
            this.font = font;
            return this;
        }
    }

}
