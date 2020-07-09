package org.tiankafei.poi.impl;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.ExcelReadStyle;
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
import org.tiankafei.poi.property.impl.BorderBeanInfo;
import org.tiankafei.poi.property.impl.CellBeanInfo;
import org.tiankafei.poi.property.impl.CellStyleBeanInfo;
import org.tiankafei.poi.property.impl.ColBeanInfo;
import org.tiankafei.poi.property.impl.ColsBeanInfo;
import org.tiankafei.poi.property.impl.FontBeanInfo;
import org.tiankafei.poi.property.impl.RowBeanInfo;
import org.tiankafei.poi.property.impl.RowsBeanInfo;
import org.tiankafei.poi.property.impl.SheetBeanInfo;
import org.tiankafei.poi.property.impl.WorkbookBeanInfo;

import java.util.Iterator;

/**
 * @author tiankafei
 */
public abstract class BaseExcelReadStyleImpl implements ExcelReadStyle {

    @Override
    public WorkbookProperty importExcel(Workbook workbook) {
        WorkbookProperty workbookProperty = createWorkbookProperty();

        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while(sheetIterator.hasNext()){
            Sheet sheet = sheetIterator.next();

            SheetProperty sheetProperty = createSheetProperty();
            sheetProperty.setSheetName(sheet.getSheetName());
            workbookProperty.addSheet(sheetProperty);
        }

        return workbookProperty;
    }

    @Override
    public WorkbookProperty createWorkbookProperty() {
        return new WorkbookBeanInfo();
    }

    @Override
    public SheetProperty createSheetProperty() {
        return new SheetBeanInfo();
    }

    @Override
    public RowsProperty createRowsProperty() {
        return new RowsBeanInfo();
    }

    @Override
    public RowProperty createRowProperty() {
        return new RowBeanInfo();
    }

    @Override
    public ColsProperty createColsProperty() {
        return new ColsBeanInfo();
    }

    @Override
    public ColProperty createColProperty() {
        return new ColBeanInfo();
    }

    @Override
    public CellProperty createCellProperty() {
        return new CellBeanInfo();
    }

    @Override
    public FontProperty createFontProperty() {
        return new FontBeanInfo();
    }

    @Override
    public CellStyleProperty createCellStyleProperty() {
        return new CellStyleBeanInfo();
    }

    @Override
    public BorderProperty createBorderProperty() {
        return new BorderBeanInfo();
    }

}
