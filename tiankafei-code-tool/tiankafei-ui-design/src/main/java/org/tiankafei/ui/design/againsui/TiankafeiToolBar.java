package org.tiankafei.ui.design.againsui;

import java.util.List;
import javax.swing.BorderFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiMenuToolBarActoin;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfToolBar;

/**
 * 自定义工具栏对象
 *
 * @author tiankafei
 */
public class TiankafeiToolBar extends TiankafeiDesignerVO {

    /**
     * 自定义工具栏对象
     */
    private TkfToolBar tkfToolBar;

    /**
     * 抽象菜单工具栏集合
     */
    private List<AbstractTiankafeiMenuToolBarActoin> tiankafeiMenuToolBarList;

    /**
     * 构造自定义工具栏对象
     */
    public TiankafeiToolBar() {
        tkfToolBar = new TkfToolBar();
    }

    /**
     * 初始化自定义工具栏对象
     *
     * @return 自定义工具栏对象
     * @throws BaseException 自定义异常
     */
    public TkfToolBar initTiankafeiToolBar() throws BaseException {
        tkfToolBar.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件背景色
        tkfToolBar.setBackground(getBackgroundColor());
        //设置控件前景色
        tkfToolBar.setForeground(getForegroundColor());
        if (CollectionUtils.isNotEmpty(tiankafeiMenuToolBarList)) {
            //初始化工具栏按钮
            for (int i = 0, lem = tiankafeiMenuToolBarList.size(); i < lem; i++) {
                AbstractTiankafeiMenuToolBarActoin abstractTiankafeiMenuToolBarActoin = tiankafeiMenuToolBarList.get(i);
                TkfButton tkfButton = abstractTiankafeiMenuToolBarActoin.initTiankafeiButton();
                tkfButton.setBackground(getBackgroundColor());
                tkfButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                tkfToolBar.add(tkfButton);
            }
        }
        return tkfToolBar;
    }

    /**
     * 获取抽象菜单工具栏集合
     *
     * @return 抽象菜单工具栏集合
     */
    public List<AbstractTiankafeiMenuToolBarActoin> getTiankafeiMenuToolBarList() {
        return tiankafeiMenuToolBarList;
    }

    /**
     * 设置抽象菜单工具栏集合
     *
     * @param tiankafeiMenuToolBarList 抽象菜单工具栏集合
     */
    public void setTiankafeiMenuToolBarList(List<AbstractTiankafeiMenuToolBarActoin> tiankafeiMenuToolBarList) {
        this.tiankafeiMenuToolBarList = tiankafeiMenuToolBarList;
    }

}
