package org.tiankafei.ui.design.againsui.table.renderer;

import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTiankafeiTableRendererUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableRadioRendererUtil;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.ControlsVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfRadioButton;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 实现自己的单选表格单元格渲染
 *
 * @author tiankafei
 */
public class TiankafeiTableRadioCellRenderer extends TkfRadioButton implements TableCellRenderer {

    private static final long serialVersionUID = -2439128678615219058L;

    /**
     * 自定义表格对象
     */
    private TkfTable tkfTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 构造单选表格单元格渲染对象
     *
     * @param tkfTable 表格对象
     */
    public TiankafeiTableRadioCellRenderer(TkfTable tkfTable) {
        this.tkfTable = tkfTable;
        this.tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
    }

    /**
     * 获取单选表格单元格渲染后的控件
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int number = 2;
        if (row % number == 0) {
            setBackground(tiankafeiTableAttributeVO.getTableDoubleRowBackgroundColor());
        } else {
            setBackground(tiankafeiTableAttributeVO.getTableSingleRowBackgroundColor());
        }
        //自定义表格列对象集合
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        //表格数据模型
        AbstractTableModel tableDataModel = tiankafeiTableAttributeVO.getTableDataModel();
        //控件属性对象
        ControlsVO controlsVO = null;
        AbstractTiankafeiTableRendererUtil abstractTiankafeiTableRendererUtil = new TiankafeiTableRadioRendererUtil();
        TableColumnDTO tableColumnDTO = tableColumnList.get(column);
        if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
            if (tableColumnDTO.getNumberFlag()) {
                controlsVO = abstractTiankafeiTableRendererUtil.getTiankafeiTableColumnNumberRenderer(tkfTable, tableDataModel, tableColumnDTO, isSelected, hasFocus, row, column);
            } else {
                controlsVO = abstractTiankafeiTableRendererUtil.getTiankafeiTableColumnNoNumberRenderer(tkfTable, tableDataModel, tableColumnDTO, isSelected, hasFocus, row, column);
            }
        } else {
            controlsVO = abstractTiankafeiTableRendererUtil.getTiankafeiTableNoChooseRenderer(tkfTable, tableDataModel, tableColumnDTO, isSelected, hasFocus, row, column);
        }
        this.setEnabled(controlsVO.isEnabledFlag());
        this.setSelected(controlsVO.isSelectedFlag());
        tableDataModel.setValueAt(controlsVO.isSelectedFlag(), row, column);
        setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        return this;
    }

}