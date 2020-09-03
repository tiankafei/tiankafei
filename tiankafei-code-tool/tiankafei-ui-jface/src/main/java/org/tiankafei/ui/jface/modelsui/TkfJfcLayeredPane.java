package org.tiankafei.ui.jface.modelsui;

import javax.swing.JLayeredPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义分层面板
 *
 * @author tiankafei1
 */
public class TkfJfcLayeredPane extends JLayeredPane {

    private static final long serialVersionUID = -2952996752801242513L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义分层面板
     */
    public TkfJfcLayeredPane() {
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
