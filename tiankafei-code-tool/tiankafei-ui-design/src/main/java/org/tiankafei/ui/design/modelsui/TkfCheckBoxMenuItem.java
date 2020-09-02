package org.tiankafei.ui.design.modelsui;

import javax.swing.JCheckBoxMenuItem;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义复选框菜单项对象
 *
 * @author tiankafei1
 */
public class TkfCheckBoxMenuItem extends JCheckBoxMenuItem {

    private static final long serialVersionUID = 2502877541569918395L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义复选框菜单项对象
     */
    public TkfCheckBoxMenuItem() {
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
