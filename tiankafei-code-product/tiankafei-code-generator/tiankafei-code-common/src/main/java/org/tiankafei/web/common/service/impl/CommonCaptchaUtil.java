package org.tiankafei.web.common.service.impl;

import com.ramostear.captcha.core.Captcha;
import com.ramostear.captcha.support.CaptchaType;
import java.awt.Color;
import java.security.SecureRandom;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.enums.CommonEnum;
import org.tiankafei.web.common.param.CaptchaVo;

/**
 * 生成验证码工具类
 *
 * @author tiankafei
 * @since 1.0
 */
public class CommonCaptchaUtil {

    private CommonCaptchaUtil(){}

    public static final SecureRandom RANDOM = new SecureRandom();

    public static Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.BLACK};

    public static String[] colorStrs = new String[]{"blue", "red", "black"};

    /**
     * 随机获取颜色
     *
     * @return
     */
    public static String getColorStr() {
        return CommonCaptchaUtil.colorStrs[RANDOM.nextInt(CommonCaptchaUtil.colorStrs.length)];
    }

    /**
     * 随机获取颜色
     *
     * @return
     */
    public static Color getColor() {
        return CommonCaptchaUtil.colors[RANDOM.nextInt(CommonCaptchaUtil.colors.length)];
    }

    /**
     * 获取验证码的key值
     *
     * @param uuid
     * @return
     */
    public static String getCaptchaKey(String uuid) {
        return CommonEnum.CAPTCHA_CODE_KEY.getCode() + uuid;
    }

    /**
     * 获取验证码
     *
     * @param captchaTypeEnum
     * @return
     */
    public static CaptchaVo getCaptcha(CaptchaTypeEnum captchaTypeEnum) {
        Captcha captcha = new Captcha();
        captcha.setType(getCaptchaType(captchaTypeEnum));
        String captchaCode = captcha.getCaptchaCode();
        String expression = String.valueOf(captcha.getExpr());
        return new CaptchaVo().setCaptcha(captchaCode).setExpression(expression);
    }

    /**
     * 获取验证码
     *
     * @param captchaType
     * @return
     */
    public static CaptchaVo getCaptcha(CaptchaType captchaType) {
        Captcha captcha = new Captcha();
        captcha.setType(captchaType);
        String captchaCode = captcha.getCaptchaCode();
        String expression = String.valueOf(captcha.getExpr());
        return new CaptchaVo().setCaptcha(captchaCode).setExpression(expression);
    }

    /**
     * 获取验证码类型
     *
     * @param captchaTypeEnum
     * @return
     */
    public static CaptchaType getCaptchaType(CaptchaTypeEnum captchaTypeEnum) {
        String name = CaptchaType.DEFAULT.name();
        switch (captchaTypeEnum) {
            case DEFAULT:
                name = CaptchaType.DEFAULT.name();
                break;
            case ARITHMETIC:
                name = CaptchaType.ARITHMETIC.name();
                break;
            case ARITHMETIC_ZH:
                name = CaptchaType.ARITHMETIC_ZH.name();
                break;
            case NUMBER:
                name = CaptchaType.NUMBER.name();
                break;
            case NUMBER_ZH_CN:
                name = CaptchaType.NUMBER_ZH_CN.name();
                break;
            case NUMBER_ZH_HK:
                name = CaptchaType.NUMBER_ZH_HK.name();
                break;
            case WORD:
                name = CaptchaType.WORD.name();
                break;
            case WORD_UPPER:
                name = CaptchaType.WORD_UPPER.name();
                break;
            case WORD_LOWER:
                name = CaptchaType.WORD_LOWER.name();
                break;
            case WORD_NUMBER_UPPER:
                name = CaptchaType.WORD_NUMBER_UPPER.name();
                break;
            case WORD_NUMBER_LOWER:
                name = CaptchaType.WORD_NUMBER_LOWER.name();
                break;
            case CHINESE:
                name = CaptchaType.CHINESE.name();
                break;
            default:
                break;
        }
        CaptchaType captchaType = CaptchaType.valueOf(name);
        return captchaType;
    }

}
