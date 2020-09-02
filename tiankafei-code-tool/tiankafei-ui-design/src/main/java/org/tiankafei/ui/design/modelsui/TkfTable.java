package org.tiankafei.ui.design.modelsui;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.ui.design.againsui.TiankafeiAgainsUiFactory;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTableControlsUtil;
import org.tiankafei.ui.design.againsui.table.renderer.TiankafeiTableHeaderRenderer;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTableDataModelVO;

/**
 * 自定义表格对象
 *
 * @author tiankafei
 */
public class TkfTable extends JTable {

    private static final long serialVersionUID = -8260011025925867892L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 其他表格对象集合
     */
    private List<TkfTable> tkfTableList;

    /**
     * 构造自定义表格对象
     */
    public TkfTable() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
        tiankafeiTableAttributeVO = new TiankafeiTableAttributeVO();
        tkfTableList = Lists.newArrayList();
    }

    /**
     * 获取选择列值
     *
     * @param row 当前行
     * @return 选择列值
     */
    public boolean getTableChooseColumnValue(int row) {
        //自定义表格数据模型对象
        TiankafeiTableDataModelVO tiankafeiTableDataModelVO = getTiankafeiTableDataModelVO();
        //表格数据模型
        DefaultTableModel tableDataModel = tiankafeiTableDataModelVO.getTableDataModel();
        //表格选择列号
        int tableChooseColumnIndex = tiankafeiTableDataModelVO.getTableChooseColumnIndex();
        //选择列值
        Boolean currentRowValue = (Boolean) tableDataModel.getValueAt(row, tableChooseColumnIndex);
        return currentRowValue.booleanValue();
    }

    /**
     * 获取自定义表格数据模型对象
     *
     * @return 自定义表格数据模型对象
     */
    public TiankafeiTableDataModelVO getTiankafeiTableDataModelVO() {
        TiankafeiTableDataModelVO tiankafeiTableDataModelVO = getTableColumnDataModel(this);
        if (tiankafeiTableDataModelVO == null) {
            if (CollectionUtils.isNotEmpty(tkfTableList)) {
                for (int index = 0, length = tkfTableList.size(); index < length; index++) {
                    TkfTable tkfTable = (TkfTable) tkfTableList.get(index);
                    tiankafeiTableDataModelVO = getTableColumnDataModel(tkfTable);
                    if (tiankafeiTableDataModelVO != null) {
                        break;
                    }
                }
            }
        }
        return tiankafeiTableDataModelVO;
    }

    /**
     * 获取自定义表格数据模型对象
     *
     * @param tkfTable 自定义表格对象
     * @return 自定义表格数据模型对象
     */
    private TiankafeiTableDataModelVO getTableColumnDataModel(TkfTable tkfTable) {
        //自定义表格属性对象
        TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
        //自定义表格列对象集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        //选择列号
        int tableChooseColumnIndex = -1;
        //获取选择列号
        for (int tableColumnIndex = 0, tableColumnLength = tableColumnList.size(); tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(tableColumnIndex);
            if (tableColumnDTO.getNumberFlag()) {
                tableChooseColumnIndex = tableColumnIndex;
                break;
            }
        }
        //自定义表格数据模型对象
        TiankafeiTableDataModelVO tiankafeiTableDataModelVO = null;
        if (tableChooseColumnIndex != -1) {
            //表格数据模型
            DefaultTableModel tableDataModel = (DefaultTableModel) tiankafeiTableAttributeVO.getTableDataModel();
            tiankafeiTableDataModelVO = new TiankafeiTableDataModelVO();
            tiankafeiTableDataModelVO.setTkfTable(tkfTable);
            tiankafeiTableDataModelVO.setTableDataModel(tableDataModel);
            tiankafeiTableDataModelVO.setTableChooseColumnIndex(tableChooseColumnIndex);
            tiankafeiTableDataModelVO.setTiankafeiTableAttributeVO(tiankafeiTableAttributeVO);
        }
        return tiankafeiTableDataModelVO;
    }

    /**
     * 还原表格列值和上一次选择的行
     *
     * @param currentRowIndex 点击的当前行
     */
    public void restoreTableColumnValueAndPreviousRow(int currentRowIndex) {
        restoreTableColumnValueAndPreviousRow(this, currentRowIndex);
        if (CollectionUtils.isNotEmpty(tkfTableList)) {
            for (int tableIndex = 0, tableLength = tkfTableList.size(); tableIndex < tableLength; tableIndex++) {
                TkfTable tkfTable = tkfTableList.get(tableIndex);
                restoreTableColumnValueAndPreviousRow(tkfTable, currentRowIndex);
            }
        }
    }

    /**
     * 还原表格列值和上一次选择的行
     *
     * @param tkfTable        表格对象
     * @param currentRowIndex 点击的当前行
     */
    private void restoreTableColumnValueAndPreviousRow(TkfTable tkfTable, int currentRowIndex) {
        //自定义表格属性对象
        TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
        //表格数据模型对象
        DefaultTableModel tableDataModel = (DefaultTableModel) tiankafeiTableAttributeVO.getTableDataModel();
        //自定义表格列对象集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();

        for (int tableColumnIndex = 0, tableColumnLength = tableColumnList.size(); tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(tableColumnIndex);
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tableColumnDTO.getControlsType()) {
                tableDataModel.setValueAt(false, currentRowIndex, tableColumnIndex);
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tableColumnDTO.getControlsType()) {
                Boolean value = (Boolean) tableDataModel.getValueAt(currentRowIndex, tableColumnIndex);
                if (value.booleanValue()) {
                    tableColumnDTO.setRadioStatusPreviousRow(-1);
                }
            }
        }
    }

    /**
     * 填充表格数据
     *
     * @param dataListList 填充的数据集合
     */
    public void fillTableData(List<List<Object>> dataListList) {
        DefaultTableModel tableDataModel = (DefaultTableModel) tiankafeiTableAttributeVO.getTableDataModel();
        tableDataModel.setRowCount(0);
        for (int rowIndex = 0, rowLength = dataListList.size(); rowIndex < rowLength; rowIndex++) {
            List<Object> dataList = dataListList.get(rowIndex);
            Vector<Object> vector = new Vector<Object>();
            for (int colIndex = 0, colLength = dataList.size(); colIndex < colLength; colIndex++) {
                vector.add(dataList.get(colIndex));
            }
            tableDataModel.addRow(vector);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        if (CollectionUtils.isNotEmpty(tableColumnList)) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(column);
            return tableColumnDTO.getEditableFlag();
        } else {
            return false;
        }
    }

    /**
     * 初始化表格列渲染
     */
    public void initTableColumnModel() {
        //设置表格列渲染
        TableColumnModel tableColumnModel = getColumnModel();
        //自定义表格列对象集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        for (int tableColumnIndex = 0, tableColumnLength = tableColumnList.size(); tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(tableColumnIndex);
            //当前列对象
            TableColumn tableColumn = tableColumnModel.getColumn(tableColumnIndex);
            //当前列控件类型
            int tableColumnControlsType = tableColumnDTO.getControlsType();
            //表格选择列类型
            if (tableColumnDTO.getNumberFlag()) {
                if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
                    tableColumnDTO.setWidth(40);
                    tableColumnControlsType = tiankafeiTableAttributeVO.getTableChooseType();
                    tableColumnDTO.setTableColumnControlsType(tableColumnControlsType);
                } else {
                    tableColumnDTO.setWidth(50);
                }
            }
            //设置表格列属性
            AbstractTableControlsUtil abstractTableControlsUtil = TiankafeiAgainsUiFactory.getAbstractTableControlsUtil(tableColumnControlsType);
            abstractTableControlsUtil.setTableColumnControlsType(tableColumn, this, tableColumnDTO);

            TiankafeiTableHeaderRenderer tiankafeiTableHeaderRenderer = new TiankafeiTableHeaderRenderer(tiankafeiTableAttributeVO);
            tableColumn.setHeaderRenderer(tiankafeiTableHeaderRenderer);
        }
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
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

    /**
     * 获取其他表格对象集合
     *
     * @return 其他表格对象集合
     */
    public List<TkfTable> getTkfTableList() {
        return tkfTableList;
    }

    /**
     * 设置其他表格对象集合
     *
     * @param tkfTableList 其他表格对象集合
     */
    public void setTkfTableList(List<TkfTable> tkfTableList) {
        this.tkfTableList = tkfTableList;
    }

}
