package org.tiankafei.ui.jface.modelsui;

import javax.swing.JInternalFrame;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义子窗口对象
 *
 * @author tiankafei1
 */
public class TkfJfcInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 6398256052112335384L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义子窗口对象
     */
    public TkfJfcInternalFrame() {
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
