package org.tiankafei.user.login.enums;

/**
 * @author tiankafei
 */
public enum LoginEnums {

    USER_NAME(1),
    EMAIL(2),
    PHONE(3),
    MORE(4),
    ;

    private int code;

    LoginEnums(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
