package org.tiankafei.ui.design.againsui;

import java.util.List;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfPopupMenu;

/**
 * 自定义右键菜单对象
 *
 * @author tiankafei
 */
public class TiankafeiPopupMenu extends TiankafeiDesignerVO {

    /**
     * 自定义右键菜单对象
     */
    private TkfPopupMenu tkfPopupMenu;

    /**
     * 本级菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 下级菜单集合
     */
    private List<MenuItemVO> menuItemList;

    /**
     * 构造自定义右键菜单对象
     */
    public TiankafeiPopupMenu() {
        tkfPopupMenu = new TkfPopupMenu();
    }

    /**
     * 初始化自定义右键菜单对象
     *
     * @return 自定义右键菜单对象
     */
    public TkfPopupMenu initTiankafeiPopupMenu() {
        tkfPopupMenu.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfPopupMenu);
        //初始化菜单
        initTkfMenu(tkfPopupMenu, menuList, true);
        //初始化菜单项
        initTkfMenuItem(tkfPopupMenu, menuItemList, true);
        return tkfPopupMenu;
    }

    /**
     * 获取本级菜单集合
     *
     * @return 本级菜单集合
     */
    public List<MenuVO> getMenuList() {
        return menuList;
    }

    /**
     * 设置本级菜单集合
     *
     * @param menuList 本级菜单集合
     */
    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    /**
     * 获取下级菜单集合
     *
     * @return 下级菜单集合
     */
    public List<MenuItemVO> getMenuItemList() {
        return menuItemList;
    }

    /**
     * 设置下级菜单集合
     *
     * @param menuItemList 下级菜单集合
     */
    public void setMenuItemList(List<MenuItemVO> menuItemList) {
        this.menuItemList = menuItemList;
    }

}
