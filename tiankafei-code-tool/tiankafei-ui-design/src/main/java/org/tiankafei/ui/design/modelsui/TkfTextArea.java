package org.tiankafei.ui.design.modelsui;

import javax.swing.JTextArea;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义文本域对象
 *
 * @author tiankafei
 */
public class TkfTextArea extends JTextArea {

    private static final long serialVersionUID = -25653547855856375L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义文本域对象
     */
    public TkfTextArea() {
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
