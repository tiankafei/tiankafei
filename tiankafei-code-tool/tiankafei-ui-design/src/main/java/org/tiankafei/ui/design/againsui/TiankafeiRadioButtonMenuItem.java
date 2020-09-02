package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfRadioButtonMenuItem;

/**
 * 自定义单选菜单项对象
 *
 * @author tiankafei1
 */
public class TiankafeiRadioButtonMenuItem extends TiankafeiDesignerVO {

    /**
     * 自定义单选菜单项对象
     */
    private TkfRadioButtonMenuItem tkfRadioButtonMenuItem;

    /**
     * 构造自定义单选菜单项对象
     */
    public TiankafeiRadioButtonMenuItem() {
        tkfRadioButtonMenuItem = new TkfRadioButtonMenuItem();
    }

    /**
     * 初始化自定义单选菜单项对象
     *
     * @return 自定义单选菜单项对象
     */
    public TkfRadioButtonMenuItem initTiankafeiRadioButtonMenuItem() {
        tkfRadioButtonMenuItem.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfRadioButtonMenuItem);

        return tkfRadioButtonMenuItem;
    }

}
