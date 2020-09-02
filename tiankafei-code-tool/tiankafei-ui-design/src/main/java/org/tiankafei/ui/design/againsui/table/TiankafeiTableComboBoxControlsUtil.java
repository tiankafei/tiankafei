package org.tiankafei.ui.design.againsui.table;

import java.util.List;
import javax.swing.table.TableColumn;
import org.tiankafei.base.dto.CodeNameDTO;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTableControlsUtil;
import org.tiankafei.ui.design.againsui.table.editor.TiankafeiTableComboBoxCellEditor;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格下拉控件工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableComboBoxControlsUtil extends AbstractTableControlsUtil {

    @Override
    public void setTableColumnControlsType(TableColumn tableColumn, TkfTable tkfTable, TableColumnDTO tableColumnDTO) {
        //表格列是否隐藏
        boolean tableColumnHiddenFlag = isTableColumnHiddenFlag(tableColumnDTO, tkfTable);
        if (tableColumnHiddenFlag) {
            //需要隐藏
            setTableColumnWidth(tableColumn, 0);
        } else {
            //创建多选渲染器
            List<CodeNameDTO> codeNameList = tableColumnDTO.getCodeNameList();
            TiankafeiTableComboBoxCellEditor tiankafeiTableComboBoxCellEditor = new TiankafeiTableComboBoxCellEditor(codeNameList.toArray());
            tableColumn.setCellEditor(tiankafeiTableComboBoxCellEditor);
            //创建单选编辑器

            //设置表格列宽
            setTableColumnWidth(tableColumn, tableColumnDTO.getWidth());
        }
    }

}
