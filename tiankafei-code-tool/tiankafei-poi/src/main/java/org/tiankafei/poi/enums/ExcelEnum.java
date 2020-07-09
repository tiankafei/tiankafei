package org.tiankafei.poi.enums;

public enum ExcelEnum {

    EXCEL_97(2003),
    EXCEL_07(2007),
    EXCEL_BIG(9999),
    ;

    private Integer code;

    ExcelEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
