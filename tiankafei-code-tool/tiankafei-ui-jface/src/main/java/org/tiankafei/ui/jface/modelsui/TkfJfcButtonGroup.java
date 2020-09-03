package org.tiankafei.ui.jface.modelsui;

import javax.swing.ButtonGroup;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义按钮组对象
 *
 * @author tiankafei1
 */
public class TkfJfcButtonGroup extends ButtonGroup {

    private static final long serialVersionUID = 286704417412147378L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义按钮组对象
     */
    public TkfJfcButtonGroup() {
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
