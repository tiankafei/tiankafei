package org.tiankafei.ui.jface.modelsui;

import javax.swing.JProgressBar;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义滚动条对象
 *
 * @author tiankafei1
 */
public class TkfJfcProgressBar extends JProgressBar {

    private static final long serialVersionUID = -4184165894699026814L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义滚动条对象
     */
    public TkfJfcProgressBar() {
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
