package org.tiankafei.ui.design.modelsui;

import javax.swing.JMenu;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义菜单对象
 *
 * @author tiankafei
 */
public class TkfMenu extends JMenu {

    private static final long serialVersionUID = 6737845283367526761L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义菜单对象
     */
    public TkfMenu() {
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
