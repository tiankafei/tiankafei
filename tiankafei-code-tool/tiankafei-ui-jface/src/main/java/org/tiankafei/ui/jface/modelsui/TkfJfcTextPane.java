package org.tiankafei.ui.jface.modelsui;

import javax.swing.JTextPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义文本面板对象
 *
 * @author tiankafei1
 */
public class TkfJfcTextPane extends JTextPane {

    private static final long serialVersionUID = 5213117932889579912L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义文本面板对象
     */
    public TkfJfcTextPane() {
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
