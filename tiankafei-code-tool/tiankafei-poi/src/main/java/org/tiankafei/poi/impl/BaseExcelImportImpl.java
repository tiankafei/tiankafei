package org.tiankafei.poi.impl;

import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.tiankafei.poi.ExcelImport;
import org.tiankafei.poi.model.SheetData;
import org.tiankafei.poi.model.WorkbookData;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class BaseExcelImportImpl implements ExcelImport<WorkbookData> {

    @Override
    public WorkbookData importExcel(Workbook workbook) {
        WorkbookData workbookData = createWorkbookData();
        List<SheetData> sheetDataList = Lists.newArrayList();

        int numberOfSheets = workbook.getNumberOfSheets();
        for (int index = 0; index < numberOfSheets; index++) {

            Sheet sheet = workbook.getSheetAt(index);
            String sheetName = workbook.getSheetName(index);
            SheetData sheetData = createSheetData(index, sheetName);
            sheetDataList.add(sheetData);




        }
        workbookData.setSheetDataList(sheetDataList);

        return workbookData;
    }
}
