package org.tiankafei.ui.design.againsui;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfMenuBar;

/**
 * 自定义菜单栏对象
 *
 * @author tiankafei
 */
public class TiankafeiMenuBar extends TiankafeiDesignerVO {

    /**
     * 自定义菜单栏对象
     */
    private TkfMenuBar tkfMenuBar;

    /**
     * 本级菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 构造自定义菜单栏对象
     */
    public TiankafeiMenuBar() {
        tkfMenuBar = new TkfMenuBar();
        menuList = Lists.newArrayList();
    }

    /**
     * 初始化自定义菜单栏对象
     *
     * @return 自定义菜单栏对象
     */
    public TkfMenuBar initTiankafeiMenuBar() {
        tkfMenuBar.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件背景色
        tkfMenuBar.setBackground(getBackgroundColor());
        //设置控件前景色
        tkfMenuBar.setForeground(getForegroundColor());
        //初始化菜单
        initTkfMenu(tkfMenuBar, menuList, false);
        return tkfMenuBar;
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

}
