package org.tiankafei.ui.design.models;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 菜单对象
 *
 * @author tiankafei
 */
public class MenuVO {

    /**
     * 菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 菜单项集合
     */
    private List<MenuItemVO> menuItemList;

    /**
     * 菜单属性对象
     */
    private TiankafeiMenuAttributeVO tiankafeiMenuAttributeVO;

    /**
     * 构造菜单对象
     */
    public MenuVO() {
        menuList = Lists.newArrayList();
        menuItemList = Lists.newArrayList();
        tiankafeiMenuAttributeVO = new TiankafeiMenuAttributeVO();
    }

    /**
     * 获取菜单集合
     *
     * @return 菜单集合
     */
    public List<MenuVO> getMenuList() {
        return menuList;
    }

    /**
     * 设置菜单集合
     *
     * @param menuList 菜单集合
     */
    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    /**
     * 获取菜单项集合
     *
     * @return 菜单项集合
     */
    public List<MenuItemVO> getMenuItemList() {
        return menuItemList;
    }

    /**
     * 设置菜单项集合
     *
     * @param menuItemList 菜单项集合
     */
    public void setMenuItemList(List<MenuItemVO> menuItemList) {
        this.menuItemList = menuItemList;
    }

    /**
     * 获取菜单属性对象
     *
     * @return 菜单属性对象
     */
    public TiankafeiMenuAttributeVO getTiankafeiMenuAttributeVO() {
        return tiankafeiMenuAttributeVO;
    }

    /**
     * 设置菜单属性对象
     *
     * @param tiankafeiMenuAttributeVO 菜单属性对象
     */
    public void setTiankafeiMenuAttributeVO(TiankafeiMenuAttributeVO tiankafeiMenuAttributeVO) {
        this.tiankafeiMenuAttributeVO = tiankafeiMenuAttributeVO;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
