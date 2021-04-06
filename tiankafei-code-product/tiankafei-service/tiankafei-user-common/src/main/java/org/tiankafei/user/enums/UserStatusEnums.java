package org.tiankafei.user.enums;

/**
 * @author tiankafei
 * @since 1.0
 */
public enum UserStatusEnums {

    // 启用
    ENABLE("1"),
    // 停用
    DISABLE("2"),
    // 有效期
    EXPIRATION_DATE("3"),
    ;

    private String code;

    UserStatusEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
