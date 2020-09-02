package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfScrollBar;

/**
 * 自定义滚动栏对象
 *
 * @author tiankafei1
 */
public class TiankafeiScrollBar extends TiankafeiDesignerVO {

    /**
     * 自定义滚动栏对象
     */
    private TkfScrollBar tkfScrollBar;

    /**
     * 构造自定义滚动栏对象
     */
    public TiankafeiScrollBar() {
        tkfScrollBar = new TkfScrollBar();
    }

    /**
     * 初始化自定义滚动栏对象
     *
     * @return 自定义滚动栏对象
     */
    public TkfScrollBar initTiankafeiScrollBar() {
        tkfScrollBar.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfScrollBar);

        return tkfScrollBar;
    }

}
