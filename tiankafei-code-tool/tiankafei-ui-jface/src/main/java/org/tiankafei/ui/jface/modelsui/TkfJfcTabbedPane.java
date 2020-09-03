package org.tiankafei.ui.jface.modelsui;

import javax.swing.JTabbedPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义标签面板对象
 *
 * @author tiankafei1
 */
public class TkfJfcTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 6180608515050945006L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义标签面板对象
     */
    public TkfJfcTabbedPane() {
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
