package org.tiankafei.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.property.WorkbookProperty;

/**
 * @author tiankafei
 */
public interface ExcelReadStyle extends ExcelImport<WorkbookProperty> {

    /**
     * 导入解析excel
     * @param workbook
     * @return
     */
    @Override
    WorkbookProperty importExcel(Workbook workbook);
}
