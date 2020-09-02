package org.tiankafei.ui.design.modelsui;

import javax.swing.JRadioButton;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义单选按钮对象
 *
 * @author tiankafei
 */
public class TkfRadioButton extends JRadioButton {

    private static final long serialVersionUID = 143145859585456484L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义单选按钮对象
     */
    public TkfRadioButton() {
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
