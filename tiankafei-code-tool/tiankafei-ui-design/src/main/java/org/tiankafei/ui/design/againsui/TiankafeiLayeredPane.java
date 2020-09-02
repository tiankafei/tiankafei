package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfLayeredPane;

/**
 * 自定义分层面板
 *
 * @author tiankafei1
 */
public class TiankafeiLayeredPane extends TiankafeiDesignerVO {

    /**
     * 自定义分层面板
     */
    private TkfLayeredPane tkfLayeredPane;

    /**
     * 构造自定义分层面板
     */
    public TiankafeiLayeredPane() {
        tkfLayeredPane = new TkfLayeredPane();
    }

    /**
     * 初始化自定义分层面板
     *
     * @return 自定义分层面板
     */
    public TkfLayeredPane initTiankafeiLayeredPane() {
        tkfLayeredPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfLayeredPane);

        return tkfLayeredPane;
    }

}
