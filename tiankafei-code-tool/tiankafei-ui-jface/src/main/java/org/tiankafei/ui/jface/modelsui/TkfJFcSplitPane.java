package org.tiankafei.ui.jface.modelsui;

import javax.swing.JSplitPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义分割面板对象
 *
 * @author tiankafei1
 */
public class TkfJFcSplitPane extends JSplitPane {

    private static final long serialVersionUID = -6444275696828489986L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义分割面板对象
     */
    public TkfJFcSplitPane() {
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
