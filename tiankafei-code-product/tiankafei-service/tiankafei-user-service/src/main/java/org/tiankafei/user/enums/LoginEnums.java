package org.tiankafei.user.enums;

/**
 * @author tiankafei
 * @since 1.0
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
