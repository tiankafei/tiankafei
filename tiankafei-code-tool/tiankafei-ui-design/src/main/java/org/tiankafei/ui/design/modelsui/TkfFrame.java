package org.tiankafei.ui.design.modelsui;

import javax.swing.JFrame;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义窗体对象
 *
 * @author tiankafei
 */
public class TkfFrame extends JFrame {

    private static final long serialVersionUID = -1179634386743302620L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义窗体对象
     */
    public TkfFrame() {
        this("");
    }

    /**
     * 构造自定义窗体对象
     *
     * @param title 窗体标题
     */
    public TkfFrame(String title) {
        super(title);
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
