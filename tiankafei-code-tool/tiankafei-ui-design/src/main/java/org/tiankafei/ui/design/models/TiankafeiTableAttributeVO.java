package org.tiankafei.ui.design.models;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;

/**
 * 自定义表格属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiTableAttributeVO implements Serializable {

    private static final long serialVersionUID = 3146962778307994356L;

    /**
     * 是否支持选择的标识
     */
    private Boolean tableChooseFlag;

    /**
     * 支持选择的情况，选取类型
     */
    private Integer tableChooseType;

    /**
     * 是否可以点击取消选择的标识
     */
    private Boolean tableCancelChooseFlag;

    /**
     * 是否需要分页的标识
     */
    private Boolean tablePageFlag;

    /**
     * 表格导出标识
     */
    private Boolean tableExportFlag;

    /**
     * 表格头部背景色
     */
    private Color tableHeaderBackgroundColor;

    /**
     * 表格头部边框背景色
     */
    private Color tableHeaderBorderBackgroundColor;

    /**
     * 表格头部前景色
     */
    private Color tableHeaderForegroundColor;

    /**
     * 表格点击时行的背景色
     */
    private Color tableClickBackgroundColor;

    /**
     * 表格再次点击取消选择的标识
     */
    private Boolean tableClickCancelSelectFlag;

    /**
     * 表格滑动时改变背景色的标识
     */
    private Boolean tableMoveFlag;

    /**
     * 表格鼠标滑动时的背景色
     */
    private Color tableMoveBackgroundColor;

    /**
     * 表格单行背景色
     */
    private Color tableSingleRowBackgroundColor;

    /**
     * 表格双行背景色
     */
    private Color tableDoubleRowBackgroundColor;

    /**
     * 表格头部行高
     */
    private Integer tableHeaderHeight;

    /**
     * 表格的行高
     */
    private Integer tableRowHeight;

    /**
     * 表格的行间距
     */
    private Integer tableRowMargin;

    /**
     * 表格是否显示水平线的标识
     */
    private Boolean tableShowHorizontalLineFlag;

    /**
     * 表格是否显示垂直线的标识
     */
    private Boolean tableShowVerticalLineFlag;

    /**
     * 表格线颜色
     */
    private Color tableGridLineColor;

    /**
     * 表格删除默认回车选中下一行的标识
     */
    private Boolean tableClearSelectNextRowFlag;

    /**
     * 表格选定方式
     */
    private Integer tableSelectionMode;

    /**
     * 表格选择单元格标识
     */
    private Boolean tableSelectedCellFlag;

    /**
     * 表格数据模型
     */
    private AbstractTableModel tableDataModel;

    /**
     * 自定义表格列对象集合
     */
    private List<TableColumnDTO> tableColumnList;

    /**
     * 表格数据集合
     */
    private List<List<Object>> dataListList;

    /**
     * 需要导出的表格数据集合
     */
    private List<List<Object>> exportDataListList;

    /**
     * 表格树数据集合
     */
    private List<TiankafeiTreeDTO> tableTreeList;

    /**
     * 表格对象集合
     */
    private List<TiankafeiTable> tiankafeiTableList;

    /**
     * 构造自定义表格属性对象
     */
    public TiankafeiTableAttributeVO() {
        tableChooseFlag = true;
        tableChooseType = TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX;
        tableCancelChooseFlag = true;
        tablePageFlag = true;
        tableExportFlag = true;
        tableHeaderBackgroundColor = Color.GRAY;
        tableHeaderBorderBackgroundColor = Color.WHITE;
        tableHeaderForegroundColor = Color.BLACK;
        tableClickBackgroundColor = new Color(76, 127, 208);
        tableClickCancelSelectFlag = false;
        tableMoveFlag = false;
        tableMoveBackgroundColor = new Color(165, 189, 233);
        tableSingleRowBackgroundColor = new Color(235, 235, 235);
        tableDoubleRowBackgroundColor = new Color(241, 241, 241);
        tableHeaderHeight = 28;
        tableRowHeight = 30;
        tableRowMargin = 3;
        tableShowHorizontalLineFlag = true;
        tableShowVerticalLineFlag = true;
        tableGridLineColor = Color.BLACK;
        tableClearSelectNextRowFlag = true;
        tableSelectionMode = TiankafeiDesignerConstants.CHOOSE_TABLE_RADIO;
        tableSelectedCellFlag = false;
        tableColumnList = Lists.newArrayList();
        dataListList = Lists.newArrayList();
        exportDataListList = Lists.newArrayList();
        tableTreeList = Lists.newArrayList();
        tiankafeiTableList = Lists.newArrayList();

        tableHeaderBackgroundColor = Color.GREEN;
        tableHeaderBorderBackgroundColor = Color.WHITE;
        tableSingleRowBackgroundColor = Color.WHITE;
        tableDoubleRowBackgroundColor = new Color(213, 255, 255);
        tableGridLineColor = Color.GREEN;
    }

    /**
     * 获取是否支持选择的标识
     *
     * @return 是否支持选择的标识
     */
    public boolean isTableChooseFlag() {
        return tableChooseFlag;
    }

    /**
     * 设置是否支持选择的标识
     *
     * @param tableChooseFlag 是否支持选择的标识
     */
    public void setTableChooseFlag(boolean tableChooseFlag) {
        this.tableChooseFlag = tableChooseFlag;
    }

    /**
     * 支持选择的情况，获取选取类型
     *
     * @return 选取类型
     */
    public int getTableChooseType() {
        return tableChooseType;
    }

    /**
     * 支持选择的情况，设置选取类型
     *
     * @param tableChooseType 选取类型
     */
    public void setTableChooseType(int tableChooseType) {
        this.tableChooseType = tableChooseType;
    }

    /**
     * 获取单选是否可以取消选择的标识
     *
     * @return 单选是否可以取消选择的标识
     */
    public boolean isTableCancelChooseFlag() {
        return tableCancelChooseFlag;
    }

    /**
     * 设置单选是否可以取消选择的标识
     *
     * @param tableCancelChooseFlag 单选是否可以取消选择的标识
     */
    public void setTableCancelChooseFlag(boolean tableCancelChooseFlag) {
        this.tableCancelChooseFlag = tableCancelChooseFlag;
    }

    /**
     * 获取是否需要分页的标识
     *
     * @return 是否需要分页的标识
     */
    public boolean isTablePageFlag() {
        return tablePageFlag;
    }

    /**
     * 设置是否需要分页的标识
     *
     * @param tablePageFlag 是否需要分页的标识
     */
    public void setTablePageFlag(boolean tablePageFlag) {
        this.tablePageFlag = tablePageFlag;
    }

    /**
     * 获取表格导出标识
     *
     * @return 表格导出标识
     */
    public boolean isTableExportFlag() {
        return tableExportFlag;
    }

    /**
     * 设置表格导出标识
     *
     * @param tableExportFlag 表格导出标识
     */
    public void setTableExportFlag(boolean tableExportFlag) {
        this.tableExportFlag = tableExportFlag;
    }

    /**
     * 获取表格头部背景色
     *
     * @return 表格头部背景色
     */
    public Color getTableHeaderBackgroundColor() {
        return tableHeaderBackgroundColor;
    }

    /**
     * 设置表格头部背景色
     *
     * @param tableHeaderBackgroundColor 表格头部背景色
     */
    public void setTableHeaderBackgroundColor(Color tableHeaderBackgroundColor) {
        this.tableHeaderBackgroundColor = tableHeaderBackgroundColor;
    }

    /**
     * 获取表格头部边框背景色
     *
     * @return 表格头部边框背景色
     */
    public Color getTableHeaderBorderBackgroundColor() {
        return tableHeaderBorderBackgroundColor;
    }

    /**
     * 设置表格头部边框背景色
     *
     * @param tableHeaderBorderBackgroundColor 表格头部边框背景色
     */
    public void setTableHeaderBorderBackgroundColor(Color tableHeaderBorderBackgroundColor) {
        this.tableHeaderBorderBackgroundColor = tableHeaderBorderBackgroundColor;
    }

    /**
     * 获取表格头部前景色
     *
     * @return 表格头部前景色
     */
    public Color getTableHeaderForegroundColor() {
        return tableHeaderForegroundColor;
    }

    /**
     * 设置表格头部前景色
     *
     * @param tableHeaderForegroundColor 表格头部前景色
     */
    public void setTableHeaderForegroundColor(Color tableHeaderForegroundColor) {
        this.tableHeaderForegroundColor = tableHeaderForegroundColor;
    }

    /**
     * 获取表格点击时行的背景色
     *
     * @return 表格点击时行的背景色
     */
    public Color getTableClickBackgroundColor() {
        return tableClickBackgroundColor;
    }

    /**
     * 设置表格点击时行的背景色
     *
     * @param tableClickBackgroundColor 表格点击时行的背景色
     */
    public void setTableClickBackgroundColor(Color tableClickBackgroundColor) {
        this.tableClickBackgroundColor = tableClickBackgroundColor;
    }

    /**
     * 获取表格再次点击取消选择的标识
     *
     * @return 表格再次点击取消选择的标识
     */
    public boolean isTableClickCancelSelectFlag() {
        return tableClickCancelSelectFlag;
    }

    /**
     * 设置表格再次点击取消选择的标识
     *
     * @param tableClickCancelSelectFlag 表格再次点击取消选择的标识
     */
    public void setTableClickCancelSelectFlag(boolean tableClickCancelSelectFlag) {
        this.tableClickCancelSelectFlag = tableClickCancelSelectFlag;
    }

    /**
     * 获取表格滑动时改变背景色的标识
     *
     * @return 表格滑动时改变背景色的标识
     */
    public boolean isTableMoveFlag() {
        return tableMoveFlag;
    }

    /**
     * 设置表格滑动时改变背景色的标识
     *
     * @param tableMoveFlag 表格滑动时改变背景色的标识
     */
    public void setTableMoveFlag(boolean tableMoveFlag) {
        this.tableMoveFlag = tableMoveFlag;
    }

    /**
     * 获取表格鼠标滑动时的背景色
     *
     * @return 表格鼠标滑动时的背景色
     */
    public Color getTableMoveBackgroundColor() {
        return tableMoveBackgroundColor;
    }

    /**
     * 设置表格鼠标滑动时的背景色
     *
     * @param tableMoveBackgroundColor 表格鼠标滑动时的背景色
     */
    public void setTableMoveBackgroundColor(Color tableMoveBackgroundColor) {
        this.tableMoveBackgroundColor = tableMoveBackgroundColor;
    }

    /**
     * 获取表格单行背景色
     *
     * @return 表格单行背景色
     */
    public Color getTableSingleRowBackgroundColor() {
        return tableSingleRowBackgroundColor;
    }

    /**
     * 设置表格单行背景色
     *
     * @param tableSingleRowBackgroundColor 表格单行背景色
     */
    public void setTableSingleRowBackgroundColor(Color tableSingleRowBackgroundColor) {
        this.tableSingleRowBackgroundColor = tableSingleRowBackgroundColor;
    }

    /**
     * 获取表格双行背景色
     *
     * @return 表格双行背景色
     */
    public Color getTableDoubleRowBackgroundColor() {
        return tableDoubleRowBackgroundColor;
    }

    /**
     * 设置表格双行背景色
     *
     * @param tableDoubleRowBackgroundColor 表格双行背景色
     */
    public void setTableDoubleRowBackgroundColor(Color tableDoubleRowBackgroundColor) {
        this.tableDoubleRowBackgroundColor = tableDoubleRowBackgroundColor;
    }

    /**
     * 获取表格选定方式
     *
     * @return 表格选定方式
     */
    public int getTableSelectionMode() {
        return tableSelectionMode;
    }

    /**
     * 设置表格选定方式
     *
     * @param tableSelectionMode 表格选定方式
     */
    public void setTableSelectionMode(int tableSelectionMode) {
        this.tableSelectionMode = tableSelectionMode;
    }

    /**
     * 获取表格选择单元格标识
     *
     * @return 表格选择单元格标识
     */
    public boolean isTableSelectedCellFlag() {
        return tableSelectedCellFlag;
    }

    /**
     * 设置表格选择单元格标识
     *
     * @param tableSelectedCellFlag 表格选择单元格标识
     */
    public void setTableSelectedCellFlag(boolean tableSelectedCellFlag) {
        this.tableSelectedCellFlag = tableSelectedCellFlag;
    }

    /**
     * 获取表格头部行高
     *
     * @return 表格头部行高
     */
    public int getTableHeaderHeight() {
        return tableHeaderHeight;
    }

    /**
     * 设置表格头部行高
     *
     * @param tableHeaderHeight 表格头部行高
     */
    public void setTableHeaderHeight(int tableHeaderHeight) {
        this.tableHeaderHeight = tableHeaderHeight;
    }

    /**
     * 获取表格的行高
     *
     * @return 表格的行高
     */
    public int getTableRowHeight() {
        return tableRowHeight;
    }

    /**
     * 设置表格的行高
     *
     * @param tableRowHeight 表格的行高
     */
    public void setTableRowHeight(int tableRowHeight) {
        this.tableRowHeight = tableRowHeight;
    }

    /**
     * 获取表格的行间距
     *
     * @return 表格的行间距
     */
    public int getTableRowMargin() {
        return tableRowMargin;
    }

    /**
     * 设置表格的行间距
     *
     * @param tableRowMargin 表格的行间距
     */
    public void setTableRowMargin(Integer tableRowMargin) {
        this.tableRowMargin = tableRowMargin;
    }

    /**
     * 获取表格是否显示水平线的标识
     *
     * @return 表格是否显示水平线的标识
     */
    public boolean isTableShowHorizontalLineFlag() {
        return tableShowHorizontalLineFlag;
    }

    /**
     * 设置表格是否显示水平线的标识
     *
     * @param tableShowHorizontalLineFlag 表格是否显示水平线的标识
     */
    public void setTableShowHorizontalLineFlag(boolean tableShowHorizontalLineFlag) {
        this.tableShowHorizontalLineFlag = tableShowHorizontalLineFlag;
    }

    /**
     * 获取表格是否显示垂直线的标识
     *
     * @return 表格是否显示垂直线的标识
     */
    public boolean isTableShowVerticalLineFlag() {
        return tableShowVerticalLineFlag;
    }

    /**
     * 设置表格是否显示垂直线的标识
     *
     * @param tableShowVerticalLineFlag 表格是否显示垂直线的标识
     */
    public void setTableShowVerticalLineFlag(boolean tableShowVerticalLineFlag) {
        this.tableShowVerticalLineFlag = tableShowVerticalLineFlag;
    }

    /**
     * 获取表格线颜色
     *
     * @return 表格线颜色
     */
    public Color getTableGridLineColor() {
        return tableGridLineColor;
    }

    /**
     * 设置表格线颜色
     *
     * @param tableGridLineColor 表格线颜色
     */
    public void setTableGridLineColor(Color tableGridLineColor) {
        this.tableGridLineColor = tableGridLineColor;
    }

    /**
     * 获取表格删除默认回车选中下一行的标识
     *
     * @return 表格删除默认回车选中下一行的标识
     */
    public boolean isTableClearSelectNextRowFlag() {
        return tableClearSelectNextRowFlag;
    }

    /**
     * 设置表格删除默认回车选中下一行的标识
     *
     * @param tableClearSelectNextRowFlag 表格删除默认回车选中下一行的标识
     */
    public void setTableClearSelectNextRowFlag(boolean tableClearSelectNextRowFlag) {
        this.tableClearSelectNextRowFlag = tableClearSelectNextRowFlag;
    }

    /**
     * 获取表格数据模型
     *
     * @return 表格数据模型
     */
    public AbstractTableModel getTableDataModel() {
        return tableDataModel;
    }

    /**
     * 设置表格数据模型
     *
     * @param tableDataModel 表格数据模型
     */
    public void setTableDataModel(AbstractTableModel tableDataModel) {
        this.tableDataModel = tableDataModel;
    }

    /**
     * 获取自定义表格列对象集合
     *
     * @return 自定义表格列对象集合
     */
    public List<TableColumnDTO> getTableColumnList() {
        return tableColumnList;
    }

    /**
     * 设置自定义表格列对象集合
     *
     * @param tableColumnList 自定义表格列对象集合
     */
    public void setTableColumnList(List<TableColumnDTO> tableColumnList) {
        this.tableColumnList = tableColumnList;
    }

    /**
     * 获取表格数据集合
     *
     * @return 表格数据集合
     */
    public List<List<Object>> getDataListList() {
        return dataListList;
    }

    /**
     * 设置表格数据集合
     *
     * @param dataListList 表格数据集合
     */
    public void setDataListList(List<List<Object>> dataListList) {
        this.dataListList = dataListList;
    }

    /**
     * 获取需要导出的表格数据集合
     *
     * @return 需要导出的表格数据集合
     */
    public List<List<Object>> getExportDataListList() {
        return exportDataListList;
    }

    /**
     * 设置需要导出的表格数据集合
     *
     * @param exportDataListList 需要导出的表格数据集合
     */
    public void setExportDataListList(List<List<Object>> exportDataListList) {
        this.exportDataListList = exportDataListList;
    }

    /**
     * 获取表格树数据集合
     *
     * @return 表格树数据集合
     */
    public List<TiankafeiTreeDTO> getTableTreeList() {
        return tableTreeList;
    }

    /**
     * 设置表格树数据集合
     *
     * @param tableTreeList 表格树数据集合
     */
    public void setTableTreeList(List<TiankafeiTreeDTO> tableTreeList) {
        this.tableTreeList = tableTreeList;
    }

    /**
     * 获取表格对象集合
     *
     * @return 表格对象集合
     */
    public List<TiankafeiTable> getTiankafeiTableList() {
        return tiankafeiTableList;
    }

    /**
     * 设置表格对象集合
     *
     * @param tiankafeiTableList 表格对象集合
     */
    public void setTiankafeiTableList(List<TiankafeiTable> tiankafeiTableList) {
        this.tiankafeiTableList = tiankafeiTableList;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
