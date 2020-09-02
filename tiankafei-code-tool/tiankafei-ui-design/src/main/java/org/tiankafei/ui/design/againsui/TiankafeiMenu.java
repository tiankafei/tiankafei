package org.tiankafei.ui.design.againsui;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfMenu;

/**
 * 自定义菜单对象
 *
 * @author tiankafei
 */
public class TiankafeiMenu extends TiankafeiDesignerVO {

    /**
     * 自定义菜单对象
     */
    private TkfMenu tkfMenu;

    /**
     * 本级菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 下级菜单集合
     */
    private List<MenuItemVO> menuItemList;

    /**
     * 菜单项是JMenuBar(false)的还是JPopupMenu(true)
     */
    private boolean popupMenuFlag;

    /**
     * 构造自定义菜单对象
     */
    public TiankafeiMenu() {
        tkfMenu = new TkfMenu();
        menuList = Lists.newArrayList();
        menuItemList = Lists.newArrayList();
    }

    /**
     * 初始化自定义菜单对象
     *
     * @return 自定义菜单对象
     * @throws BaseException 自定义异常
     */
    public TkfMenu initTiankafeiMenu() throws BaseException {
        tkfMenu.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfMenu);
        //设置菜单图标
        setImageIcon(tkfMenu);
        //设置菜单文字
        tkfMenu.setText(getText());
        //初始化菜单集合
        initTkfMenu(tkfMenu, menuList, false);
        //初始化菜单项集合
        initTkfMenuItem(tkfMenu, menuItemList, isPopupMenuFlag());
        return tkfMenu;
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

    /**
     * 获取菜单项是JMenuBar(false)的还是JPopupMenu(true)
     *
     * @return 菜单项是JMenuBar(false)的还是JPopupMenu(true)
     */
    public boolean isPopupMenuFlag() {
        return popupMenuFlag;
    }

    /**
     * 设置菜单项是JMenuBar(false)的还是JPopupMenu(true)
     *
     * @param popupMenuFlag 菜单项是JMenuBar(false)的还是JPopupMenu(true)
     */
    public void setPopupMenuFlag(boolean popupMenuFlag) {
        this.popupMenuFlag = popupMenuFlag;
    }
}
