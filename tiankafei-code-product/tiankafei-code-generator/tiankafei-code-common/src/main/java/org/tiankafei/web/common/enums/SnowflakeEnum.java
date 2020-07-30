package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum SnowflakeEnum {

    // mybatis_plus 的雪花算法
    MYBATIS_PLUS(1);
    ;

    private Integer code;

    SnowflakeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
