package org.tiankafei.poi.model;

import java.util.List;

/**
 * @author tiankafei
 */
public interface ISheet {

    /**
     * 获取行对象
     *
     * @return
     */
    IRows getRows();

    /**
     * 设置行对象
     *
     * @param rows
     */
    void setRows(IRows rows);

    /**
     * 获取列对象
     *
     * @return
     */
    ICols getCols();

    /**
     * 设置列对象
     *
     * @param cols
     */
    void setCols(ICols cols);

    /**
     * 获取样式集合
     *
     * @return
     */
    List<ICellStyle> getCellStyleList();

    /**
     * 设置样式集合
     *
     * @param cellStyleList
     */
    void setCellStyleList(List<ICellStyle> cellStyleList);

    /**
     * 添加样式
     *
     * @param cellStyle
     */
    void addCellStyle(ICellStyle cellStyle);

}
