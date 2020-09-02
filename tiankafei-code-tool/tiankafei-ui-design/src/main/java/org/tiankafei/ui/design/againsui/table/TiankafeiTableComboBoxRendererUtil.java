package org.tiankafei.ui.design.againsui.table;

import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTiankafeiTableRendererUtil;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.ControlsVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格下拉框渲染工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableComboBoxRendererUtil extends AbstractTiankafeiTableRendererUtil {

    @Override
    public ControlsVO getTiankafeiTableChooseRenderer(TkfTable tkfTable, TiankafeiTableAttributeVO tiankafeiTableAttributeVO, int currentRowIndex, int currentColumnIndex) {

        return null;
    }

    @Override
    public ControlsVO getTiankafeiTableNoChooseRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                        TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        controlsVO.setEnabledFlag(true);
        return controlsVO;
    }

    @Override
    public ControlsVO getTiankafeiTableColumnNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                            TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        controlsVO.setEnabledFlag(true);
        return controlsVO;
    }

    /**
     * 表格支持选择的时候，且当前列不是选择序号列时，如果选择当前行，则启用，否则禁用
     */
    @Override
    public ControlsVO getTiankafeiTableColumnNoNumberRenderer(TkfTable tkfTable, AbstractTableModel tableDataModel,
                                                              TableColumnDTO tableColumnDTO, boolean isSelected, boolean hasFocus, int row, int column) {
        ControlsVO controlsVO = new ControlsVO();
        if (tkfTable.getTableChooseColumnValue(row)) {
            controlsVO.setEnabledFlag(true);
        } else {
            controlsVO.setEnabledFlag(false);
        }
        return controlsVO;
    }

}
