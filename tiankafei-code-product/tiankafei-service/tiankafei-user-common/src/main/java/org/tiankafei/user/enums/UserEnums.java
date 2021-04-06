package org.tiankafei.user.enums;

/**
 * @author tiankafei
 * @since 1.0
 */
public enum UserEnums {

    // 按用户名
    USER_NAME(1),
    // 按邮箱
    EMAIL(2),
    // 按手机号码
    PHONE(3),
    // 按用户名或邮箱或手机号码
    MORE(4),
    ;

    private int code;

    UserEnums(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
