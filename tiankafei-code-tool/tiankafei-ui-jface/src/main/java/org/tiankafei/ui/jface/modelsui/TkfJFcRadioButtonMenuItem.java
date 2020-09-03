package org.tiankafei.ui.jface.modelsui;

import javax.swing.JRadioButtonMenuItem;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义单选菜单项对象
 *
 * @author tiankafei1
 */
public class TkfJFcRadioButtonMenuItem extends JRadioButtonMenuItem {

    private static final long serialVersionUID = 7155271040587024206L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义单选菜单项对象
     */
    public TkfJFcRadioButtonMenuItem() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
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

}
