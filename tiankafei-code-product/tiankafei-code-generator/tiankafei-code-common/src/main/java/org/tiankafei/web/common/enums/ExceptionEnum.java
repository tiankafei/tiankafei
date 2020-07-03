package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ExceptionEnum implements BaseEnums {

    REQUEST_PARAM_EXCEPTION("", "请求参数校验异常!"),
    EXCEPTION("", "系统异常!"),
    DAO_EXCEPTION("", "数据库处理异常!"),
    NOT_FOUND("", "你请求的资源不存在!"),

    LOGIN_AUTHENTICATION_EXCEPTION("5000", "登陆授权异常"),
    ;

    private String status;

    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    ExceptionEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
