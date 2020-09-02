package org.tiankafei.ui.design.againsui;

import java.awt.Component;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;

/**
 * 自定义滚动面板对象
 *
 * @author tiankafei
 */
public class TiankafeiScrollPane extends TiankafeiDesignerVO {

    /**
     * 自定义滚动面板对象
     */
    private TkfScrollPane tkfScrollPane;

    /**
     * 构造自定义滚动面板对象
     */
    public TiankafeiScrollPane() {
        tkfScrollPane = new TkfScrollPane();
        setTopBorderWidth(0);
        setBottomBorderWidth(0);
        setLeftBorderWidth(0);
        setRightBorderWidth(0);
    }

    /**
     * 构造自定义滚动面板对象
     *
     * @param view view控件
     */
    public TiankafeiScrollPane(Component view) {
        tkfScrollPane = new TkfScrollPane(view);
    }

    /**
     * 构造自定义滚动面板对象
     *
     * @param view      view控件
     * @param vsbPolicy 垂直定位
     * @param hsbPolicy 水平定位
     */
    public TiankafeiScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
        tkfScrollPane = new TkfScrollPane(view, vsbPolicy, hsbPolicy);
    }

    /**
     * 初始化自定义滚动面板对象
     *
     * @return 自定义滚动面板对象
     */
    public TkfScrollPane initTiankafeiScrollPane() {
        tkfScrollPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfScrollPane);

        return tkfScrollPane;
    }

}
