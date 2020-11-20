package org.tiankafei.poi.enums;

public enum ExcelSuffixEnum {

    EXCEL_2003_SUFFIX(".xls"),
    EXCEL_2007_SUFFIX(".xlsx"),
    EXCEL_9999_SUFFIX(".xlsx"),
    WORD_2003_SUFFIX(".doc"),
    WORD_2007_SUFFIX(".docx"),
    PDF_SUFFIX(".pdf"),
    ;

    private String code;

    ExcelSuffixEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
