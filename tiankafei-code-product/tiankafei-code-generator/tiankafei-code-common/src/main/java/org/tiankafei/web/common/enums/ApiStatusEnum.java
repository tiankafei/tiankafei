package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum ApiStatusEnum implements BaseEnums {

    /**
     * 失败的状态
     */
    FAIL(0),

    /**
     * 成功的状态
     */
    OK(1),

    /**
     * 发生异常的状态
     */
    ERROR(2),
    ;

    private Integer status;

    private String message;

    ApiStatusEnum(Integer status) {
        this.status = status;
    }

    ApiStatusEnum(Integer status, String message) {
        this(status);
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
