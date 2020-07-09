package org.tiankafei.web.common.enums;

/**
 * @author 魏双双
 * @since 1.0
 **/
public enum CommonEnum {

//    token的key值
    TOKEN_PARAM("SYS_USER_TOKEN"),
    ;

    private String code;

    CommonEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
