package org.tiankafei.ui.design.againsui.table;

import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTiankafeiTableRendererUtil;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.ControlsVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格单选框渲染工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableRadioRendererUtil extends AbstractTiankafeiTableRendererUtil {

    /**
     * 表格支持选择列时的渲染工具
     * 表格支持选择的时候，且当前列不是选择序号列时，如果选择当前行，则启用，否则禁用
     *
     * @return 控件属性对象
     */
    @Override
    public ControlsVO getTiankafeiTableChooseRenderer(TkfTable tkfTable, TiankafeiTableAttributeVO tiankafeiTableAttributeVO, int currentRowIndex, int currentColumnIndex) {

        return null;
    }

    /**
     * 表格不支持选择列时的渲染工具
     * 表格支持选择的时候，且当前列不是选择序号列时，如果选择当前行，则启用，否则禁用
     *
     * @return 控件属性对象
     */
    @Override
    public ControlsVO getTiankafeiTableNoChooseRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                        TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        controlsVO.setEnabledFlag(true);
        if (tableColumnDTO.getRadioStatusPreviousRow() == row) {
            controlsVO.setSelectedFlag(true);
        } else {
            controlsVO.setSelectedFlag(false);
        }
        if (hasFocus) {
            tableColumnDTO.setRadioStatusPreviousRow(row);
            controlsVO.setSelectedFlag(true);
        }
        return controlsVO;
    }

    /**
     * 当前表格列是选择序号列时的渲染工具
     * 表格支持选择列的时候，且当前列是选择序号列时，则启用；
     * 如果单选可取消则可进行取消，否则一旦选中，就取消不掉了
     *
     * @return 控件属性对象
     */
    @Override
    public ControlsVO getTiankafeiTableColumnNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                            TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        controlsVO.setEnabledFlag(true);
        if (isSelected) {
            //自定义表格属性对象
            TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
            if (tiankafeiTableAttributeVO.isTableCancelChooseFlag()) {
                Boolean b = (Boolean) tableDataModel.getValueAt(row, column);
                controlsVO.setSelectedFlag(b.booleanValue());
            } else {
                controlsVO.setSelectedFlag(true);
            }
        } else {
            controlsVO.setSelectedFlag(false);
        }
        return controlsVO;
    }

    /**
     * 当前表格列不是选择序号列时的渲染工具
     * 表格支持选择列的时候，且当前列不是选择序号列时，
     * 如果当前行被选中，则启用，否则禁用；
     * 如果当前行被选中，上次选择的行等于当前行时，处于选中状态，否则处于非选中状态，如果该行的列获取到焦点时(点击则)，处于选中状态
     * 如果当前行未被选中时，则禁用；上次选择的行等于当前行时，处于选中状态，否则处于非选中状态
     *
     * @return 控件属性对象
     */
    @Override
    public ControlsVO getTiankafeiTableColumnNoNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                              TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        if (tkfTable.getTableChooseColumnValue(row)) {
            controlsVO.setEnabledFlag(true);
            if (tableColumnDTO.getRadioStatusPreviousRow() == row) {
                controlsVO.setSelectedFlag(true);
            } else {
                controlsVO.setSelectedFlag(false);
            }
            if (hasFocus) {
                tableColumnDTO.setRadioStatusPreviousRow(row);
                controlsVO.setSelectedFlag(true);
            }
        } else {
            controlsVO.setEnabledFlag(false);
            if (tableColumnDTO.getRadioStatusPreviousRow() == row) {
                controlsVO.setSelectedFlag(true);
            } else {
                controlsVO.setSelectedFlag(false);
            }
        }
        return controlsVO;
    }

}
