package org.tiankafei.ui.design.againsui.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTiankafeiTableRendererUtil;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.ControlsVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTableDataModelVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格渲染工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableRendererUtil extends AbstractTiankafeiTableRendererUtil {

    @Override
    public ControlsVO getTiankafeiTableChooseRenderer(TkfTable tkfTable, TiankafeiTableAttributeVO currentTiankafeiTableAttributeVO, int currentRowIndex, int currentColumnIndex) {
        //当前表格所在的表格数据模型对象
        AbstractTableModel currentTableDataModel = tkfTable.getTiankafeiTableAttributeVO().getTableDataModel();
        //表格列对象集合
        List<TableColumnDTO> currentTableColumnList = currentTiankafeiTableAttributeVO.getTableColumnList();
        //点击当前表格列对象
        TableColumnDTO currentTableColumnDTO = currentTableColumnList.get(currentColumnIndex);
        if (currentTiankafeiTableAttributeVO.isTableChooseFlag()) {
            //更改表格选择列值标识
            boolean updateTableChooseColumnValueflag = false;
            //自定义表格数据模型对象
            TiankafeiTableDataModelVO tiankafeiTableDataModelVO = tkfTable.getTiankafeiTableDataModelVO();
            //选择序号列所在的表格属性对象
            TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tiankafeiTableDataModelVO.getTiankafeiTableAttributeVO();
            //选择序号列所在的表格数据模型对象
            AbstractTableModel tableDataModel = tiankafeiTableAttributeVO.getTableDataModel();
            //选择序号列所在的表格选择列号
            int tableChooseColumnIndex = tiankafeiTableDataModelVO.getTableChooseColumnIndex();
            //选择序号列所在的表格选择列值
            Boolean value = (Boolean) tableDataModel.getValueAt(currentRowIndex, tableChooseColumnIndex);
            //表格选择序号列的选择类型
            int tableChooseType = tiankafeiTableAttributeVO.getTableChooseType();
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tableChooseType) {
                if (TiankafeiDesignerConstants.CHOOSE_TYPE_NO == currentTableColumnDTO.getControlsType()) {
                    //当点击的没有绑定控件时，需要更改选择列的值
                    updateTableChooseColumnValueflag = true;
                    if (value.booleanValue()) {
                        //如果选择列的值是true的时候，还原表格列值和上一次选择的行
                        tkfTable.restoreTableColumnValueAndPreviousRow(currentRowIndex);
                    }
                } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == currentTableColumnDTO.getControlsType()) {
                    //更改表格复选列值得标识
                    boolean updateTableCheckBoxColumnValueflag = false;
                    if (currentTableColumnDTO.getNumberFlag()) {
                        updateTableCheckBoxColumnValueflag = true;
                    } else {
                        //当点击的是复选框控件时，更改当前复选框值
                        if (value.booleanValue()) {
                            updateTableCheckBoxColumnValueflag = true;
                        }
                    }
                    if (updateTableCheckBoxColumnValueflag) {
                        Boolean currentValue = (Boolean) currentTableDataModel.getValueAt(currentRowIndex, currentColumnIndex);
                        currentTableDataModel.setValueAt(!currentValue.booleanValue(), currentRowIndex, currentColumnIndex);
                    }
                }
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tableChooseType) {
                updateTableChooseColumnValueflag = true;
            }
            //更改表格选择列值
            if (updateTableChooseColumnValueflag) {
                if (tiankafeiTableAttributeVO.isTableCancelChooseFlag()) {
                    tableDataModel.setValueAt(!value.booleanValue(), currentRowIndex, tableChooseColumnIndex);
                } else {
                    tableDataModel.setValueAt(true, currentRowIndex, tableChooseColumnIndex);
                }
            }
        } else {
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == currentTableColumnDTO.getControlsType()) {
                Boolean currentValue = (Boolean) currentTableDataModel.getValueAt(currentRowIndex, currentColumnIndex);
                currentTableDataModel.setValueAt(!currentValue.booleanValue(), currentRowIndex, currentColumnIndex);
            }
        }

        //刷新延迟问题
        tkfTable.updateUI();
        List<TkfTable> tkfTableList = tkfTable.getTkfTableList();
        for (int i = 0, lem = tkfTableList.size(); i < lem; i++) {
            tkfTableList.get(i).updateUI();
        }
        return null;
    }

    @Override
    public ControlsVO getTiankafeiTableNoChooseRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                        TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {

        return null;
    }

    @Override
    public ControlsVO getTiankafeiTableColumnNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                            TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {

        return null;
    }

    @Override
    public ControlsVO getTiankafeiTableColumnNoNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                              TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {

        return null;
    }

}
