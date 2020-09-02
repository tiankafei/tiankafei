package org.tiankafei.ui.design.againsui.table;

import javax.swing.table.TableColumn;
import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTableControlsUtil;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 抽象表格控件工具类
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsUtil extends AbstractTableControlsUtil {

    @Override
    public void setTableColumnControlsType(TableColumn tableColumn, TkfTable tkfTable, TableColumnDTO tableColumnDTO) {
        //表格列是否隐藏
        boolean tableColumnHiddenFlag = tableColumnDTO.getHiddenFlag();
        if (tableColumnHiddenFlag) {
            //需要隐藏
            setTableColumnWidth(tableColumn, 0);
        } else {
            //表格最大列宽
            int tableColumnMaxWidth = tableColumnDTO.getMaxWidth();
            //表格最小列宽
            int tableColumnMinWidth = tableColumnDTO.getMinWidth();
            //表格列宽
            int tableColumnWidth = tableColumnDTO.getWidth();
            if (tableColumnWidth != 0) {
                //设置列宽
                tableColumn.setWidth(tableColumnWidth);
                tableColumn.setPreferredWidth(tableColumnWidth);
                //设置最大列
                if (tableColumnMaxWidth != 0) {
                    if (tableColumnMaxWidth > tableColumnWidth) {
                        tableColumn.setMaxWidth(tableColumnMaxWidth);
                    }
                }
                //设置最小列
                if (tableColumnMinWidth < tableColumnWidth) {
                    tableColumn.setMinWidth(tableColumnMinWidth);
                }
            }
        }
    }

}
