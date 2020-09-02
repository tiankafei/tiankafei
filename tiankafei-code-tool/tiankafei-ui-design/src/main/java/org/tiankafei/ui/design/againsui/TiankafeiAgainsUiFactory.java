package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.againsui.abstractinterface.AbstractTableControlsUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableCheckBoxControlsUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableComboBoxControlsUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableControlsUtil;
import org.tiankafei.ui.design.againsui.table.TiankafeiTableRadioControlsUtil;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;

/**
 * 自定义客户端UI工厂类
 *
 * @author tiankafei1
 */
public class TiankafeiAgainsUiFactory {

    /**
     * 获取抽象表格控件工具类对象
     *
     * @param controlsType 控件类型
     * @return 抽象表格控件工具类对象
     */
    public static AbstractTableControlsUtil getAbstractTableControlsUtil(int controlsType) {
        AbstractTableControlsUtil abstractTableControlsUtil = null;

        if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == controlsType) {
            abstractTableControlsUtil = new TiankafeiTableRadioControlsUtil();
        } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == controlsType) {
            abstractTableControlsUtil = new TiankafeiTableCheckBoxControlsUtil();
        } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_COMBOBOX == controlsType) {
            abstractTableControlsUtil = new TiankafeiTableComboBoxControlsUtil();
        } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_NO == controlsType) {
            abstractTableControlsUtil = new TiankafeiTableControlsUtil();
        } else {
            abstractTableControlsUtil = new TiankafeiTableControlsUtil();
        }

        return abstractTableControlsUtil;
    }

}
