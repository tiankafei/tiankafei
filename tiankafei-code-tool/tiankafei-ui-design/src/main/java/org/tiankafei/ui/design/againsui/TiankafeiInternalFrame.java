package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfInternalFrame;

/**
 * 自定义子窗口对象
 *
 * @author tiankafei1
 */
public class TiankafeiInternalFrame extends TiankafeiDesignerVO {

    /**
     * 自定义子窗口对象
     */
    private TkfInternalFrame tkfInternalFrame;

    /**
     * 构造自定义子窗口对象
     */
    public TiankafeiInternalFrame() {
        tkfInternalFrame = new TkfInternalFrame();
    }

    /**
     * 初始化自定义子窗口对象
     *
     * @return 自定义子窗口对象
     */
    public TkfInternalFrame initTiankafeiInternalFrame() {
        tkfInternalFrame.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfInternalFrame);

        return tkfInternalFrame;
    }

}
