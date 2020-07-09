package org.tiankafei.poi.impl;

import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.ExcelReadStyle;
import org.tiankafei.poi.property.WorkbookProperty;

/**
 * @author tiankafei
 */
public abstract class BaseExcelReadStyleImpl implements ExcelReadStyle {

    @Override
    public WorkbookProperty importExcel(Workbook workbook) {
        return null;
    }

}
