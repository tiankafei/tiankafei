package org.tiankafei.web.common.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.CaptchaGenerateService;

import java.io.OutputStream;

/**
 * @author tiankafei
 * @since 1.0
 */
@Service
public class GenerateHappyCaptchaService implements CaptchaGenerateService {

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length) throws VerificationException {
        try {
            DefaultKaptcha defaultKaptcha = getDefaultKaptcha(width, height, length);

            String captchaCode = defaultKaptcha.createText();
            BufferedImage bufferedImage = defaultKaptcha.createImage(captchaCode);
            ImageIO.write(bufferedImage, "jpg", outputStream);
            return captchaCode;
        } catch (IOException e) {
            e.printStackTrace();
            throw new VerificationException(e.getMessage());
        }
    }

    /**
     * Kaptcha 详细配置表
     * kaptcha.border	图片边框，合法值：yes , no	yes
     * kaptcha.border.color	边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.	black
     * kaptcha.image.width	图片宽	200
     * kaptcha.image.height	图片高	50
     * kaptcha.producer.impl	图片实现类	com.google.code.kaptcha.impl.DefaultKaptcha
     * kaptcha.textproducer.impl	文本实现类	com.google.code.kaptcha.text.impl.DefaultTextCreator
     * kaptcha.textproducer.char.string	文本集合，验证码值从此集合中获取	abcde2345678gfynmnpwx
     * kaptcha.textproducer.char.length	验证码长度	5
     * kaptcha.textproducer.font.names	字体	Arial, Courier
     * kaptcha.textproducer.font.size	字体大小	40px.
     * kaptcha.textproducer.font.color	字体颜色，合法值： r,g,b 或者 white,black,blue.	black
     * kaptcha.textproducer.char.space	文字间隔	2
     * kaptcha.noise.impl	干扰实现类	com.google.code.kaptcha.impl.DefaultNoise
     * kaptcha.noise.color	干扰 颜色，合法值： r,g,b 或者 white,black,blue.	black
     * kaptcha.obscurificator.impl
     * 图片样式：<br />水纹 com.google.code.kaptcha.impl.WaterRipple <br />
     * <p>
     * 鱼眼 com.google.code.kaptcha.impl.FishEyeGimpy <br />
     * <p>
     * 阴影 com.google.code.kaptcha.impl.ShadowGimpy
     * <p>
     * 默认
     * com.google.code.kaptcha.impl.WaterRipple
     * kaptcha.background.impl	背景实现类	com.google.code.kaptcha.impl.DefaultBackground
     * kaptcha.background.clear.from	背景颜色渐变，开始颜色	light grey
     * kaptcha.background.clear.to	背景颜色渐变， 结束颜色	white
     * kaptcha.word.impl	文字渲染器	com.google.code.kaptcha.text.impl.DefaultWordRenderer
     * kaptcha.session.key	session key	KAPTCHA_SESSION_KEY
     * kaptcha.session.date	session date	KAPTCHA_SESSION_DATE
     *
     * @param width
     * @param height
     * @param length
     * @return
     */
    private DefaultKaptcha getDefaultKaptcha(int width, int height, int length) {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "red");
        // 图片宽
        properties.setProperty("kaptcha.image.width", String.valueOf(width));
        // 图片高
        properties.setProperty("kaptcha.image.height", String.valueOf(height));
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", String.valueOf(length));
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.HAPPY_CAPTCHA;
    }

}
