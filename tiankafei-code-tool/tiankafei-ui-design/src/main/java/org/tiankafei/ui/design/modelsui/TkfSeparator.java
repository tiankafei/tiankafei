package org.tiankafei.ui.design.modelsui;

import javax.swing.JSeparator;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义分割器对象
 *
 * @author tiankafei1
 */
public class TkfSeparator extends JSeparator {

    private static final long serialVersionUID = 3315738659014618215L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义分割器对象
     */
    public TkfSeparator() {
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
