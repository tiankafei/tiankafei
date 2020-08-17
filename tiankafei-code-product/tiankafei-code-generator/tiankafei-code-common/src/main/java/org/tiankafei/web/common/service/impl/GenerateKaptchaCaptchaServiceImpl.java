package org.tiankafei.web.common.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.param.CaptchaVo;
import org.tiankafei.web.common.service.CaptchaGenerateService;

/**
 * @author tiankafei
 * @since 1.0
 */
@Service
public class GenerateKaptchaCaptchaServiceImpl implements CaptchaGenerateService {

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.KAPTCHA_CAPTCHA;
    }

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        try {
            DefaultKaptcha defaultKaptcha = getDefaultKaptcha(width, height, length, 28);
//            String captcha = defaultKaptcha.createText();
            CaptchaVo captcha = CommonCaptchaUtil.getCaptcha(captchaTypeEnum);

            BufferedImage bufferedImage = defaultKaptcha.createImage(captcha.getExpression());
            ImageIO.write(bufferedImage, "jpg", outputStream);
            return captcha.getCaptcha();
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
    private DefaultKaptcha getDefaultKaptcha(int width, int height, int length, int fontSize) {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 是否有边框 默认为true 我们可以自己设置yes，no
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色 默认为Color.BLACK
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 验证码文本字符颜色 默认为Color.BLACK
//        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.textproducer.font.color", CommonCaptchaUtil.getColorStr());
        // 验证码图片宽度 默认为200
        properties.setProperty("kaptcha.image.width", String.valueOf(width));
        // 验证码图片高度 默认为50
        properties.setProperty("kaptcha.image.height", String.valueOf(height));
        // 验证码文本字符大小 默认为40
        properties.setProperty("kaptcha.textproducer.font.size", String.valueOf(fontSize));
        // KAPTCHA_SESSION_KEY
        properties.setProperty("kaptcha.session.key", "kaptchaCodeMath");
        // 验证码文本生成器
//        properties.setProperty("kaptcha.textproducer.impl", "com.ruoyi.gateway.config.KaptchaTextCreator");
        properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
        // 验证码文本字符间距 默认为2
        properties.setProperty("kaptcha.textproducer.char.space", "3");
        // 验证码文本字符长度 默认为5
        properties.setProperty("kaptcha.textproducer.char.length", String.valueOf(length));
        // 验证码文本字体样式 默认为new Font("Arial", 1, fontSize), new Font("Courier", 1,
        // fontSize)
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        // 验证码噪点颜色 默认为Color.BLACK
        properties.setProperty("kaptcha.noise.color", "white");
        // 干扰实现类
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        // 图片样式 水纹com.google.code.kaptcha.impl.WaterRipple
        // 鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
        // 阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
