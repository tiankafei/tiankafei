package org.tiankafei.base.base.enums;

/**
 * 时间类型的枚举类
 *
 * @author tiankafei
 * @since 1.0
 **/
public enum DateTimeEnum {

    YYYY_MM_DDHH_MM_SS("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DDHH_MM("yyyy-MM-dd HH:mm"),
    YYYY_MM_DDHH("yyyy-MM-dd HH"),
    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM("yyyy-MM"),
    YYYY("yyyy"),
    YYYY_NAME_MM_NAME_DDHH_NAME_MM_NAME_SS("yyyy年MM月dd日 HH时mm分ss秒"),
    YYYY_NAME_MM_NAME_DDHH_NAME_MM("yyyy年MM月dd日 HH时mm分"),
    YYYY_NAME_MM_NAME_DDHH("yyyy年MM月dd日 HH时"),
    YYYY_NAME_MM_NAME_DD("yyyy年MM月dd日"),
    YYYY_NAME_MM("yyyy年MM月"),
    YYYY_NAME("yyyy年"),
    YYYY_1_MM_1_DDHH_1_MM_1_SS("yyyy/MM/dd HH:mm:ss"),
    YYYY_1_MM_1_DDHH_1_MM("yyyy/MM/dd HH:mm"),
    YYYY_1_MM_1_DDHH("yyyy/MM/dd HH"),
    YYYY_1_MM_1_DD("yyyy/MM/dd"),
    YYYY_1_MM("yyyy/MM"),
    YYYYMMDDHHMMSS("yyyyMMddHHmmss"),
    YYYYMMDDHHMM("yyyyMMddHHmm"),
    YYYYMMDDHH("yyyyMMddHH"),
    YYYYMMDD("yyyyMMdd"),
    YYYYMM("yyyyMM"),
    ORA_YYYY_MM_DDHH_MM_SS("'yy-mm-dd hh24:mi:ss'"),
    ORA_YYYY_MM_DDHH_MM("'yy-mm-dd hh24:mi'"),
    ORA_YYYY_MM_DDHH("'yy-mm-dd hh24'"),
    ORA_YYYY_MM_DD("'yy-mm-dd'"),
    ORA_YYYY_MM("'yy-mm'"),
    ORA_YYYY("'yy'");

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    DateTimeEnum(String code) {
        this.code = code;
    }
}
