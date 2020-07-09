package org.tiankafei.poi.property;

import java.util.List;

/**
 * @author tiankafei
 */
public interface RowProperty {

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
    List<CellProperty> getCellList();

    /**
     * 设置列结合
     *
     * @param cellList
     */
    void setCellList(List<CellProperty> cellList);

    /**
     * 添加单元格对象
     *
     * @param cell
     */
    void addCell(CellProperty cell);

}
