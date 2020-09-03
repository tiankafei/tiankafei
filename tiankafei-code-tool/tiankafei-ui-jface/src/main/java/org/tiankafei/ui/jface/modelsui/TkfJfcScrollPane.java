package org.tiankafei.ui.jface.modelsui;

import java.awt.Component;
import javax.swing.JScrollPane;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义滚动面板对象
 *
 * @author tiankafei
 */
public class TkfJfcScrollPane extends JScrollPane {

    private static final long serialVersionUID = -2255962728234752998L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义滚动面板对象
     */
    public TkfJfcScrollPane() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 构造自定义滚动面板对象
     *
     * @param view the component to display in the scrollpane's viewport
     */
    public TkfJfcScrollPane(Component view) {
        super(view);
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
    }

    /**
     * 构造自定义滚动面板对象
     *
     * @param view      the component to display in the scrollpanes viewport
     * @param vsbPolicy an integer that specifies the vertical scrollbar policy
     * @param hsbPolicy an integer that specifies the horizontal scrollbar policy
     */
    public TkfJfcScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);
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
