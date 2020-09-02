package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfCheckBoxMenuItem;

/**
 * 自定义复选框菜单项对象
 *
 * @author tiankafei1
 */
public class TiankafeiCheckBoxMenuItem extends TiankafeiDesignerVO {

    /**
     * 自定义复选框菜单项对象
     */
    private TkfCheckBoxMenuItem tkfCheckBoxMenuItem;

    /**
     * 构造自定义复选框菜单项对象
     */
    public TiankafeiCheckBoxMenuItem() {
        tkfCheckBoxMenuItem = new TkfCheckBoxMenuItem();
    }

    /**
     * 初始化自定义复选框菜单项对象
     *
     * @return 自定义复选框菜单项对象
     */
    public TkfCheckBoxMenuItem initTiankafeiCheckBoxMenuItem() {
        tkfCheckBoxMenuItem.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfCheckBoxMenuItem);

        return tkfCheckBoxMenuItem;
    }

}
