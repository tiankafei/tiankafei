package org.tiankafei.ui.design.againsui;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.models.MenuItemVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfMenuItem;

/**
 * 自定义菜单项对象
 *
 * @author tiankafei
 */
public class TiankafeiMenuItem extends TiankafeiDesignerVO {

    /**
     * 自定义菜单项对象
     */
    private TkfMenuItem tkfMenuItem;

    /**
     * 菜单项对象
     */
    private MenuItemVO menuItemVO;

    /**
     * 构造自定义菜单项对象
     */
    public TiankafeiMenuItem() {
        tkfMenuItem = new TkfMenuItem();
        menuItemVO = new MenuItemVO();
    }

    /**
     * 初始化自定义菜单项对象
     *
     * @return 自定义菜单项对象
     * @throws BaseException 自定义异常
     */
    public TkfMenuItem initTiankafeiMenuItem() throws BaseException {
        tkfMenuItem.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        tkfMenuItem.setMenuItemVO(getMenuItemVO());
        //设置控件属性
        setComponentParam(tkfMenuItem);
        //设置菜单图标
        setImageIcon(tkfMenuItem);
        //设置按钮文本
        tkfMenuItem.setText(getText());

        if (menuItemVO.getHotKey() != -1) {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(menuItemVO.getHotKey(), KeyEvent.ALT_DOWN_MASK, false);
            tkfMenuItem.setAccelerator(keyStroke);
        }

        return tkfMenuItem;
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
