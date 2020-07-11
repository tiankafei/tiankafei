package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 */
public enum CaptchaEnum {

    HAPPY_CAPTCHA("HAPPY_CAPTCHA"),
    RUO_YI_UTIL("RUO_YI_UTIL"),
    ;

    private String code;

    CaptchaEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
