package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiSplitPanelAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfSplitPane;

/**
 * 自定义分割面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiSplitPane extends TiankafeiDesignerVO {

    /**
     * 自定义分割面板对象
     */
    private TkfSplitPane tkfSplitPane;

    /**
     * 自定义分割面板参数对象
     */
    private TiankafeiSplitPanelAttributeVO tiankafeiSplitPanelAttributeVO;

    /**
     * 构造自定义分割面板对象
     */
    public TiankafeiSplitPane() {
        tkfSplitPane = new TkfSplitPane();
        tiankafeiSplitPanelAttributeVO = new TiankafeiSplitPanelAttributeVO();
    }

    /**
     * 初始化自定义分割面板对象
     *
     * @return 自定义分割面板对象
     */
    public TkfSplitPane initTiankafeiSplitPane() {
        tkfSplitPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfSplitPane);

        tkfSplitPane.setOneTouchExpandable(tiankafeiSplitPanelAttributeVO.isSplitBorderFoldFlag());
        if (tiankafeiSplitPanelAttributeVO.isSplitBorderFoldFlag()) {
            tkfSplitPane.setDividerSize(tiankafeiSplitPanelAttributeVO.getSplitBordeSize());
        }
        return tkfSplitPane;
    }

    /**
     * 获取自定义分割面板参数对象
     *
     * @return 自定义分割面板参数对象
     */
    public TiankafeiSplitPanelAttributeVO getTiankafeiSplitPanelAttributeVO() {
        return tiankafeiSplitPanelAttributeVO;
    }

    /**
     * 设置自定义分割面板参数对象
     *
     * @param tiankafeiSplitPanelAttributeVO 自定义分割面板参数对象
     */
    public void setTiankafeiSplitPanelAttributeVO(TiankafeiSplitPanelAttributeVO tiankafeiSplitPanelAttributeVO) {
        this.tiankafeiSplitPanelAttributeVO = tiankafeiSplitPanelAttributeVO;
    }
}
