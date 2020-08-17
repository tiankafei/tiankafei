package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 */
public enum CaptchaEnum {

    /**
     * happy的验证码工具类
     */
    HAPPY_CAPTCHA("HAPPY_CAPTCHA"),

    /**
     * google的验证码工具类
     */
    KAPTCHA_CAPTCHA("KAPTCHA_CAPTCHA"),

    /**
     * 若依验证码的工具类
     */
    RUO_YI_UTIL("RUO_YI_UTIL"),

    /**
     * 基于hutool的验证码工具类
     */
    HUTOOL("HUTOOL"),
    ;

    private String code;

    CaptchaEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
