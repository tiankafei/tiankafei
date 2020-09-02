package org.tiankafei.ui.design.modelsui;

import javax.swing.JCheckBox;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义复选按钮
 *
 * @author tiankafei
 */
public class TkfCheckBox extends JCheckBox {

    private static final long serialVersionUID = -7727500050515922846L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义复选按钮
     */
    public TkfCheckBox() {
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
