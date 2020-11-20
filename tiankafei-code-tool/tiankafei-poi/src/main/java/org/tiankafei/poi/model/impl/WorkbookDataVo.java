package org.tiankafei.poi.model.impl;

import org.tiankafei.poi.model.SheetData;
import org.tiankafei.poi.model.WorkbookData;

import java.util.List;

/**
 * workbook数据对象
 * @author 甜咖啡
 */
public class WorkbookDataVo implements WorkbookData {

    private List<SheetData> sheetDataList;

    @Override
    public List<SheetData> getSheetDataList() {
        return this.sheetDataList;
    }

    @Override
    public void setSheetDataList(List<SheetData> sheetDataList) {
        this.sheetDataList = sheetDataList;
    }
}
