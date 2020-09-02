package org.tiankafei.ui.report.panel.utils.htmldrawer;

import com.fr.base.Constants;
import com.fr.report.CellElement;

/**
 * @author 甜咖啡
 */
public abstract class AbstractTiankafeiDrawer {

    /**
     * 绘制html内容
     *
     * @param cellElement 单元格对象
     * @return html内容
     */
    public abstract String drawerHtmlContent(CellElement cellElement);

    /**
     * 获取是否可编辑标识
     *
     * @param cellElement 单元格
     * @return 是否可编辑标识
     */
    public boolean isEditFlag(CellElement cellElement) {
        boolean editFlag = true;
        if (cellElement.getCellGUIAttr().getEditableState() == Constants.EDITABLE_STATE_FALSE) {
            editFlag = false;
        }
        return editFlag;
    }

    /**
     * 获取input输入框控件的编辑状态html
     *
     * @param cellElement 单元格对象
     * @return input输入框控件的编辑状态html
     */
    public String getInputControlState(CellElement cellElement) {
        StringBuffer buffer = new StringBuffer();
        if (!isEditFlag(cellElement)) {
            buffer.append(" readonly ");
        }
        return buffer.toString();
    }

    /**
     * 获取select选择框控件的编辑状态html
     *
     * @param cellElement 单元格对象
     * @return input输入框控件的编辑状态html
     */
    public String getSelectControlState(CellElement cellElement) {
        StringBuffer buffer = new StringBuffer();
        if (!isEditFlag(cellElement)) {
            buffer.append(" disabled ");
        }
        return buffer.toString();
    }

}
