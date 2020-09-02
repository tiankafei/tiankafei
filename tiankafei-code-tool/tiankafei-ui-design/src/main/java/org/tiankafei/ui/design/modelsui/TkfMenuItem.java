package org.tiankafei.ui.design.modelsui;

import javax.swing.JMenuItem;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义菜单项对象
 *
 * @author tiankafei
 */
public class TkfMenuItem extends JMenuItem {

    private static final long serialVersionUID = 8315204103202838841L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 菜单项对象
     */
    private MenuItemVO menuItemVO;

    /**
     * 构造自定义菜单项对象
     */
    public TkfMenuItem() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
        menuItemVO = new MenuItemVO();
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
    }

    /**
     * 获取菜单项对象
     *
     * @return 菜单项对象
     */
    public MenuItemVO getMenuItemVO() {
        return menuItemVO;
    }

    /**
     * 设置菜单项对象
     *
     * @param menuItemVO 菜单项对象
     */
    public void setMenuItemVO(MenuItemVO menuItemVO) {
        this.menuItemVO = menuItemVO;
    }

}
