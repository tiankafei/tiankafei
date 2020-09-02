package org.tiankafei.ui.design.againsui.abstractinterface;

import javax.swing.table.TableColumn;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 抽象表格控件工具类
 *
 * @author tiankafei1
 */
public abstract class AbstractTableControlsUtil {

    /**
     * 设置表格列控件
     *
     * @param tableColumn    表格列对象
     * @param tkfTable       表格对象
     * @param tableColumnDTO 自定义表格列对象
     */
    public abstract void setTableColumnControlsType(TableColumn tableColumn, TkfTable tkfTable, TableColumnDTO tableColumnDTO);

    /**
     * 设置表格列宽
     *
     * @param tableColumn 表格列对象
     * @param width       表格列宽
     */
    public void setTableColumnWidth(TableColumn tableColumn, int width) {
        tableColumn.setWidth(width);
        tableColumn.setPreferredWidth(width);
        tableColumn.setMinWidth(width);
        tableColumn.setMaxWidth(width);
    }

    /**
     * 获取表格列是否隐藏的标识
     *
     * @param tableColumnDTO 表格列对象
     * @param tkfTable       表格对象
     * @return 表格列是否隐藏的标识
     */
    public boolean isTableColumnHiddenFlag(TableColumnDTO tableColumnDTO, TkfTable tkfTable) {
        //表格列是否隐藏
        boolean hiddenFlag = false;
        //表格属性对象
        TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tkfTable.getTiankafeiTableAttributeVO();
        if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
            //当前表格属性是单选时，且当前表格是单选或复选时，需要隐藏，否则根据列对象判断是否隐藏
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tiankafeiTableAttributeVO.getTableChooseType()) {
                if (tableColumnDTO.getNumberFlag()) {
                    hiddenFlag = false;
                } else {
                    if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tableColumnDTO.getControlsType()
                            || TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tableColumnDTO.getControlsType()) {
                        hiddenFlag = true;
                    } else {
                        hiddenFlag = tableColumnDTO.getHiddenFlag();
                    }
                }
            }
        } else {
            hiddenFlag = tableColumnDTO.getHiddenFlag();
        }
        return hiddenFlag;
    }

}
