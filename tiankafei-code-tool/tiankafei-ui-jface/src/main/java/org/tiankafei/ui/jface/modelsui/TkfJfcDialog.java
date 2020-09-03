package org.tiankafei.ui.jface.modelsui;

import javax.swing.JDialog;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义对话框对象
 *
 * @author tiankafei1
 */
public class TkfJfcDialog extends JDialog {

    private static final long serialVersionUID = 6931564250301463231L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义对话框对象
     */
    public TkfJfcDialog() {
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
