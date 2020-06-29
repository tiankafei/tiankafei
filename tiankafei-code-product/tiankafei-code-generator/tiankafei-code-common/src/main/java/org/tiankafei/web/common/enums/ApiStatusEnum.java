package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ApiStatusEnum implements BaseEnums {

    FAIL("0"),
    OK("1"),
    ERROR("2"),
    ;

    private String status;

    private String message;

    ApiStatusEnum(String status) {
        this.status = status;
    }

    ApiStatusEnum(String status, String message) {
        this(status);
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
