package org.tiankafei.poi;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author tiankafei
 */
public interface ExcelImport<T> extends Import {

    /**
     * 导入excel
     * @param workbook
     * @return
     */
    T importExcel(Workbook workbook);

}
