package org.tiankafei.ui.jface.modelsui;

import javax.swing.JPasswordField;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义密码框对象
 *
 * @author tiankafei
 */
public class TkfJfcPasswordField extends JPasswordField {

    private static final long serialVersionUID = 6278977194556354092L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义密码框对象
     */
    public TkfJfcPasswordField() {
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
