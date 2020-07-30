package org.tiankafei.web.common.enums;

/**
 * @author tiankafei
 * @since 1.0
 **/
public enum DistributedIdEnum {

    // MyBatisPlusSnowflake 的雪花算法
    MYBATIS_PLUS_SNOWFLAKE(1);
    ;

    private Integer code;

    DistributedIdEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
