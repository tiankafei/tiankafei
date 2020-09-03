package org.tiankafei.ui.jface.modelsui;

import javax.swing.JScrollBar;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义滚动栏对象
 *
 * @author tiankafei1
 */
public class TkfJfcScrollBar extends JScrollBar {

    private static final long serialVersionUID = 3190210039417287804L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 构造自定义滚动栏对象
     */
    public TkfJfcScrollBar() {
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
