package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfTabbedPane;

/**
 * 自定义标签面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiTabbedPane extends TiankafeiDesignerVO {

    /**
     * 自定义标签面板对象
     */
    private TkfTabbedPane tkfTabbedPane;

    /**
     * 构造自定义标签面板对象
     */
    public TiankafeiTabbedPane() {
        tkfTabbedPane = new TkfTabbedPane();

    }

    /**
     * 初始化自定义标签面板对象
     *
     * @return 自定义标签面板对象
     */
    public TkfTabbedPane initTiankafeiTabbedPane() {
        tkfTabbedPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfTabbedPane);

        return tkfTabbedPane;
    }

}
