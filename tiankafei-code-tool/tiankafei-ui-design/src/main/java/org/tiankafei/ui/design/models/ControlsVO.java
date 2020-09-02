package org.tiankafei.ui.design.models;

import javax.swing.table.DefaultTableModel;

/**
 * 控件属性对象
 *
 * @author tiankafei1
 */
public class ControlsVO {

    /**
     * 控件禁用与否的标识
     */
    private Boolean enabledFlag;

    /**
     * 控件选中与否的标识
     */
    private Boolean selectedFlag;

    /**
     * 控件显示与否的标识
     */
    private Boolean visibleFlag;

    /**
     * 表格数据模型对象
     */
    private DefaultTableModel tableDataModel;

    /**
     * 构造控件属性对象
     */
    public ControlsVO() {
        enabledFlag = true;
        selectedFlag = false;
        visibleFlag = true;
    }

    /**
     * 获取控件禁用与否的标识
     *
     * @return 控件禁用与否的标识
     */
    public boolean isEnabledFlag() {
        return enabledFlag;
    }

    /**
     * 设置控件禁用与否的标识
     *
     * @param enabledFlag 控件禁用与否的标识
     */
    public void setEnabledFlag(boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    /**
     * 获取控件选中与否的标识
     *
     * @return 控件选中与否的标识
     */
    public boolean isSelectedFlag() {
        return selectedFlag;
    }

    /**
     * 设置控件选中与否的标识
     *
     * @param selectedFlag 控件选中与否的标识
     */
    public void setSelectedFlag(boolean selectedFlag) {
        this.selectedFlag = selectedFlag;
    }

    /**
     * 获取控件显示与否的标识
     *
     * @return 控件显示与否的标识
     */
    public boolean isVisibleFlag() {
        return visibleFlag;
    }

    /**
     * 设置控件显示与否的标识
     *
     * @param visibleFlag 控件显示与否的标识
     */
    public void setVisibleFlag(boolean visibleFlag) {
        this.visibleFlag = visibleFlag;
    }

    /**
     * 获取表格数据模型对象
     *
     * @return 表格数据模型对象
     */
    public DefaultTableModel getTableDataModel() {
        return tableDataModel;
    }

    /**
     * 设置表格数据模型对象
     *
     * @param tableDataModel 表格数据模型对象
     */
    public void setTableDataModel(DefaultTableModel tableDataModel) {
        this.tableDataModel = tableDataModel;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
