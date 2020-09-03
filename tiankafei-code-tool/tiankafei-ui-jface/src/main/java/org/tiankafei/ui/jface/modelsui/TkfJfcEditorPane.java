package org.tiankafei.ui.jface.modelsui;

import javax.swing.JEditorPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义编辑面板对象
 *
 * @author tiankafei1
 */
public class TkfJfcEditorPane extends JEditorPane {

    private static final long serialVersionUID = 1837589280120340029L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义编辑面板对象
     */
    public TkfJfcEditorPane() {
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
