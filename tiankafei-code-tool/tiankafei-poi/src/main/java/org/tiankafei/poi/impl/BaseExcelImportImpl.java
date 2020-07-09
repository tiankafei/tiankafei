package org.tiankafei.poi.impl;

import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.ExcelImport;
import org.tiankafei.poi.model.WorkBookData;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class BaseExcelImportImpl implements ExcelImport<WorkBookData> {

    @Override
    public WorkBookData importExcel(Workbook workbook) {
        return null;
    }
}
