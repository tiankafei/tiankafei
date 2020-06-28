package org.tiankafei.poi.model;

import java.util.List;

/**
 * @author tiankafei
 */
public interface IRow {

    /**
     * 获取行索引位置
     *
     * @return
     */
    Integer getRowIndex();

    /**
     * 设置行索引位置
     *
     * @param rowIndex
     */
    void setRowIndex(Integer rowIndex);

    /**
     * 获取列集合
     *
     * @return
     */
    List<ICell> getCellList();

    /**
     * 设置列结合
     *
     * @param cellList
     */
    void setCellList(List<ICell> cellList);

    /**
     * 添加单元格对象
     *
     * @param cell
     */
    void addCell(ICell cell);

}
