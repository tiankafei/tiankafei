package org.tiankafei.ui.jface.modelsui;

import javax.swing.JPanel;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义面板对象
 *
 * @author tiankafei
 */
public class TkfJfcPanel extends JPanel {

    private static final long serialVersionUID = -8440344021521698666L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义面板对象
     */
    public TkfJfcPanel() {
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
