package org.tiankafei.ui.design.againsui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义面板对象
 *
 * @author tiankafei
 */
public class TiankafeiPanel extends TiankafeiDesignerVO {

    /**
     * 自定义面板对象
     */
    private TkfPanel tkfPanel;

    /**
     * 构造自定义面板对象
     */
    public TiankafeiPanel() {
        tkfPanel = new TkfPanel();
        setTopBorderWidth(0);
        setBottomBorderWidth(0);
        setLeftBorderWidth(0);
        setRightBorderWidth(0);
        tkfPanel.setLayout(new BorderLayout());
    }

    /**
     * 初始化自定义面板对象
     *
     * @return 自定义面板对象
     */
    public TkfPanel initTiankafeiPanel() {
        tkfPanel.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfPanel);

        return tkfPanel;
    }

    /**
     * 设置布局
     *
     * @param layout 布局管理器
     */
    public void setLayout(LayoutManager layout) {
        tkfPanel.setLayout(layout);
    }

}
