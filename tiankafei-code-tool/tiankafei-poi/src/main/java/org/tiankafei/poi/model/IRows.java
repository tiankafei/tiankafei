package org.tiankafei.poi.model;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface IRows {

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
    List<IRow> getRowList();

    /**
     * 设置行集合
     *
     * @param rowList
     */
    void setRowList(List<IRow> rowList);

    /**
     * 添加每一行的行对象
     *
     * @param row
     */
    void addRow(IRow row);

}
