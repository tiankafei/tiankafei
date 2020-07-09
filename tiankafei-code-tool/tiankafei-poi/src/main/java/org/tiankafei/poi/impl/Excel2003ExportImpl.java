package org.tiankafei.poi.impl;

import org.tiankafei.poi.enums.PoiEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Excel2003ExportImpl extends BaseExcelExportImpl {
    @Override
    public String getFileSuffix() {
        return PoiEnum.EXCEL_2003_SUFFIX.getCode();
    }
}
