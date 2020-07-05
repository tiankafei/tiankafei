package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ExceptionEnum implements BaseEnums {

    REQUEST_PARAM_EXCEPTION(null, "请求参数校验异常!"),
    EXCEPTION(null, "系统异常!"),
    DAO_EXCEPTION(null, "数据库处理异常!"),
    NOT_FOUND(null, "你请求的资源不存在!"),

    LOGIN_AUTHENTICATION_EXCEPTION(5001, "登陆授权异常"),
    LOGIN_LIMITED_EXCEPTION(5002, "登录人数过多，请稍后再试"),
    LOGIN_TOKEN_EXCEPTION(5003, "请求中没有携带tonken信息"),
    REQUEST_URL_TOKEN_EXCEPTION(5004, "请求路径错误"),
    ;

    private Integer status;

    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    ExceptionEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public Integer getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
