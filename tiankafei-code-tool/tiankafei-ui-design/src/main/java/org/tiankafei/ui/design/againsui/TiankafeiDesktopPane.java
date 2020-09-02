package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfDesktopPane;

/**
 * 自定义桌面面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiDesktopPane extends TiankafeiDesignerVO {

    /**
     * 自定义桌面面板对象
     */
    private TkfDesktopPane tkfDesktopPane;

    /**
     * 构造自定义桌面面板对象
     */
    public TiankafeiDesktopPane() {
        tkfDesktopPane = new TkfDesktopPane();
    }

    /**
     * 初始化自定义桌面面板对象
     *
     * @return 自定义桌面面板对象
     */
    public TkfDesktopPane initTiankafeiDesktopPane() {
        tkfDesktopPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfDesktopPane);

        return tkfDesktopPane;
    }

}
