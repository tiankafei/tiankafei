package org.tiankafei.poi.property;

import java.util.List;

/**
 * @author tiankafei
 */
public interface SheetProperty {

    /**
     * 设置sheet的名字
     * @param sheetName
     */
    void setSheetName(String sheetName);

    /**
     * 获取行对象
     *
     * @return
     */
    RowsProperty getRows();

    /**
     * 设置行对象
     *
     * @param rows
     */
    void setRows(RowsProperty rows);

    /**
     * 获取列对象
     *
     * @return
     */
    ColsProperty getCols();

    /**
     * 设置列对象
     *
     * @param cols
     */
    void setCols(ColsProperty cols);

    /**
     * 获取样式集合
     *
     * @return
     */
    List<CellStyleProperty> getCellStyleList();

    /**
     * 设置样式集合
     *
     * @param cellStyleList
     */
    void setCellStyleList(List<CellStyleProperty> cellStyleList);

    /**
     * 添加样式
     *
     * @param cellStyle
     */
    void addCellStyle(CellStyleProperty cellStyle);

}
