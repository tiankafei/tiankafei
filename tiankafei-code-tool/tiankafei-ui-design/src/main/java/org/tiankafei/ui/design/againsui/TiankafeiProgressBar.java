package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfProgressBar;

/**
 * 自定义滚动条对象
 *
 * @author tiankafei1
 */
public class TiankafeiProgressBar extends TiankafeiDesignerVO {

    /**
     * 自定义滚动条对象
     */
    private TkfProgressBar tkfProgressBar;

    /**
     * 构造自定义滚动条对象
     */
    public TiankafeiProgressBar() {
        tkfProgressBar = new TkfProgressBar();
    }

    /**
     * 初始化自定义滚动条对象
     *
     * @return 自定义滚动条对象
     */
    public TkfProgressBar initTiankafeiProgressBar() {
        tkfProgressBar.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfProgressBar);

        return tkfProgressBar;
    }

}
