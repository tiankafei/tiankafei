package org.tiankafei.ui.design.modelsui;

import javax.swing.JToolBar;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义工具栏对象
 *
 * @author tiankafei
 */
public class TkfToolBar extends JToolBar {

    private static final long serialVersionUID = 8903276282848727987L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义工具栏对象
     */
    public TkfToolBar() {
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
