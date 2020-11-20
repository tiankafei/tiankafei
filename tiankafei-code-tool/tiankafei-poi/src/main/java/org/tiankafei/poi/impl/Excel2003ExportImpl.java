package org.tiankafei.poi.impl;

import org.tiankafei.poi.enums.ExcelSuffixEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel2003ExportImpl extends BaseExcelExportImpl {
    @Override
    public String getFileSuffix() {
        return ExcelSuffixEnum.EXCEL_2003_SUFFIX.getCode();
    }
}
