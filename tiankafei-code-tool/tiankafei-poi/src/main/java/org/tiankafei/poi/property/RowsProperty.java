package org.tiankafei.poi.property;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface RowsProperty {

    /**
     * 获取行的个数
     *
     * @return
     */
    Integer getRowCount();

    /**
     * 设置行的个数
     *
     * @param rowCount
     */
    void setRowCount(Integer rowCount);

    /**
     * 获取行集合
     *
     * @return
     */
    List<RowProperty> getRowList();

    /**
     * 设置行集合
     *
     * @param rowList
     */
    void setRowList(List<RowProperty> rowList);

    /**
     * 添加每一行的行对象
     *
     * @param row
     */
    void addRow(RowProperty row);

}
