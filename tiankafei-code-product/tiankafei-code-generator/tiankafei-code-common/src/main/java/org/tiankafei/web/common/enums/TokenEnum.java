package org.tiankafei.web.common.enums;

/**
 * @author 魏双双
 * @since 1.0
 **/
public enum TokenEnum {

    // 从请求头中获取token信息
    HEADER(1),
    // 从cookies中获取token信息
    COOKIES(2),
    // 从请求参数中获取token信息
    REQUEST_PARAM(3),
    // 从session中获取token信息（需要做session同步）
    SESSION(5),
    ;

    private Integer code;

    TokenEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
