package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum CommonEnum {

    // token的key值
    TOKEN_PARAM("SYS_USER_TOKEN"),
    // token前缀
    TOKEN_PREFIX("Bearer "),
    //    验证码的key前缀
    CAPTCHA_CODE_KEY("captcha_codes:"),
    ;

    private String code;

    CommonEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
