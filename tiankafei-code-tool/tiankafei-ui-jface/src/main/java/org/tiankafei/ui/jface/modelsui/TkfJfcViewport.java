package org.tiankafei.ui.jface.modelsui;

import javax.swing.JViewport;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义视图对象
 *
 * @author tiankafei1
 */
public class TkfJfcViewport extends JViewport {

    private static final long serialVersionUID = 4803764361343604619L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义视图对象
     */
    public TkfJfcViewport() {
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
