package org.tiankafei.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.property.BorderProperty;
import org.tiankafei.poi.property.CellProperty;
import org.tiankafei.poi.property.CellStyleProperty;
import org.tiankafei.poi.property.ColProperty;
import org.tiankafei.poi.property.ColsProperty;
import org.tiankafei.poi.property.FontProperty;
import org.tiankafei.poi.property.RowProperty;
import org.tiankafei.poi.property.RowsProperty;
import org.tiankafei.poi.property.SheetProperty;
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

    WorkbookProperty createWorkbookProperty();

    SheetProperty createSheetProperty();

    RowsProperty createRowsProperty();

    RowProperty createRowProperty();

    ColsProperty createColsProperty();

    ColProperty createColProperty();

    CellProperty createCellProperty();

    FontProperty createFontProperty();

    CellStyleProperty createCellStyleProperty();

    BorderProperty createBorderProperty();

}
