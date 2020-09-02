package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfApplet;

/**
 * 自定义小应用程序对象
 *
 * @author tiankafei1
 */
public class TiankafeiApplet extends TiankafeiDesignerVO {

    /**
     * 自定义小应用程序对象
     */
    private TkfApplet tkfApplet;

    /**
     * 构造自定义小应用程序对象
     */
    public TiankafeiApplet() {
        tkfApplet = new TkfApplet();
    }

    /**
     * 初始化自定义小应用程序对象
     *
     * @return 自定义小应用程序对象
     */
    public TkfApplet initTiankafeiApplet() {

        return tkfApplet;
    }

}
