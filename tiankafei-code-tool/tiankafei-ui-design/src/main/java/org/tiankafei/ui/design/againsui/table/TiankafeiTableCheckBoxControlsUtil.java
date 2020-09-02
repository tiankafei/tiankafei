package org.tiankafei.ui.design.againsui.table;

import javax.swing.table.TableColumn;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTableControlsUtil;
import org.tiankafei.ui.design.againsui.table.editor.TiankafeiTableCellEditor;
import org.tiankafei.ui.design.againsui.table.renderer.TiankafeiTableCheckBoxCellRenderer;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.modelsui.TkfCheckBox;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格复选控件工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableCheckBoxControlsUtil extends AbstractTableControlsUtil {

    @Override
    public void setTableColumnControlsType(TableColumn tableColumn, TkfTable tkfTable, TableColumnDTO tableColumnDTO) {
        //表格列是否隐藏
        boolean tableColumnHiddenFlag = isTableColumnHiddenFlag(tableColumnDTO, tkfTable);
        if (tableColumnHiddenFlag) {
            //需要隐藏
            setTableColumnWidth(tableColumn, 0);
        } else {
            //创建多选渲染器
            TiankafeiTableCheckBoxCellRenderer tiankafeiTableCheckCellRenderer = new TiankafeiTableCheckBoxCellRenderer(tkfTable);
            tableColumn.setCellRenderer(tiankafeiTableCheckCellRenderer);
            //创建单选编辑器
            TiankafeiTableCellEditor tiankafeiTableCellEditor = new TiankafeiTableCellEditor(new TkfCheckBox());
            tableColumn.setCellEditor(tiankafeiTableCellEditor);
            //设置表格列宽
            setTableColumnWidth(tableColumn, tableColumnDTO.getWidth());
        }
    }

}
