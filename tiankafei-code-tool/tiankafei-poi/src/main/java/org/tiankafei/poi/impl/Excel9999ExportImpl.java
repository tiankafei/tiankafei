package org.tiankafei.poi.impl;

import org.tiankafei.poi.enums.ExcelSuffixEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel9999ExportImpl extends BaseExcelExportImpl {
    @Override
    public String getFileSuffix() {
        return ExcelSuffixEnum.EXCEL_9999_SUFFIX.getCode();
    }
}
