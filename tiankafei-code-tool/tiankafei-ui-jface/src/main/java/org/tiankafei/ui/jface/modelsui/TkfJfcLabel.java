package org.tiankafei.ui.jface.modelsui;

import javax.swing.JLabel;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义标签对象
 *
 * @author tiankafei
 */
public class TkfJfcLabel extends JLabel {

    private static final long serialVersionUID = 7414575046070842415L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义标签对象
     */
    public TkfJfcLabel() {
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
