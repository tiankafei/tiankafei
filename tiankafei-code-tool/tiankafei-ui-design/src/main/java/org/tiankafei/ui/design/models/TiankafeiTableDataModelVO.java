package org.tiankafei.ui.design.models;

import javax.swing.table.DefaultTableModel;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格数据模型对象
 *
 * @author tiankafei1
 */
public class TiankafeiTableDataModelVO {

    /**
     * 自定义表格对象
     */
    private TkfTable tkfTable;

    /**
     * 表格数据模型
     */
    private DefaultTableModel tableDataModel;

    /**
     * 表格选择列号
     */
    private Integer tableChooseColumnIndex;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    public TiankafeiTableDataModelVO() {
        tableChooseColumnIndex = -1;
    }

    /**
     * 获取自定义表格对象
     *
     * @return 自定义表格对象
     */
    public TkfTable getTkfTable() {
        return tkfTable;
    }

    /**
     * 设置自定义表格对象
     *
     * @param tkfTable 自定义表格对象
     */
    public void setTkfTable(TkfTable tkfTable) {
        this.tkfTable = tkfTable;
    }

    /**
     * 获取表格数据模型
     *
     * @return 表格数据模型
     */
    public DefaultTableModel getTableDataModel() {
        return tableDataModel;
    }

    /**
     * 设置表格数据模型
     *
     * @param tableDataModel 表格数据模型
     */
    public void setTableDataModel(DefaultTableModel tableDataModel) {
        this.tableDataModel = tableDataModel;
    }

    /**
     * 获取表格选择列号
     *
     * @return 表格选择列号
     */
    public int getTableChooseColumnIndex() {
        return tableChooseColumnIndex;
    }

    /**
     * 设置表格选择列号
     *
     * @param tableChooseColumnIndex 表格选择列号
     */
    public void setTableChooseColumnIndex(int tableChooseColumnIndex) {
        this.tableChooseColumnIndex = tableChooseColumnIndex;
    }

    /**
     * 获取自定义表格属性对象
     *
     * @return 自定义表格属性对象
     */
    public TiankafeiTableAttributeVO getTiankafeiTableAttributeVO() {
        return tiankafeiTableAttributeVO;
    }

    /**
     * 设置自定义表格属性对象
     *
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     */
    public void setTiankafeiTableAttributeVO(TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        this.tiankafeiTableAttributeVO = tiankafeiTableAttributeVO;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
