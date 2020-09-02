package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.againsui.tabbedpane.defaults.TiankafeiTabbedClosedPaneUi;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiTabbedAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTabbedClosedPane;

/**
 * 自定义标签面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiTabbedClosedPane extends TiankafeiDesignerVO {

    /**
     * 自定义标签面板对象
     */
    private TkfTabbedClosedPane tkfTabbedClosedPane;

    /**
     * 自定义标签面板属性对象
     */
    private TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO;

    /**
     * 构造自定义标签面板对象
     */
    public TiankafeiTabbedClosedPane() {
        this(true);
    }

    /**
     * 构造自定义标签面板对象
     *
     * @param showClosedFlag 是否显示关闭图标的标识
     */
    public TiankafeiTabbedClosedPane(boolean showClosedFlag) {
        tiankafeiTabbedAttributeVO = new TiankafeiTabbedAttributeVO();
        tiankafeiTabbedAttributeVO.setShowClosedFlag(showClosedFlag);
        tkfTabbedClosedPane = new TkfTabbedClosedPane(tiankafeiTabbedAttributeVO);
    }

    /**
     * 初始化自定义标签面板对象
     *
     * @return 自定义标签面板对象
     */
    @SuppressWarnings("restriction")
    public TkfTabbedClosedPane initTiankafeiTabbedPane() {
        tkfTabbedClosedPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfTabbedClosedPane);
        if (tkfTabbedClosedPane.getUI() instanceof com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI) {
            //设置自定义可关闭面板的
            tkfTabbedClosedPane.setUI(new org.tiankafei.ui.design.againsui.tabbedpane.windows.TiankafeiTabbedClosedPaneUi(tkfTabbedClosedPane));
        } else if (tkfTabbedClosedPane.getUI() instanceof javax.swing.plaf.metal.MetalTabbedPaneUI) {
            //设置自定义可关闭面板的
            tkfTabbedClosedPane.setUI(new TiankafeiTabbedClosedPaneUi(tkfTabbedClosedPane));
        }
        return tkfTabbedClosedPane;
    }

    /**
     * 获取自定义标签面板属性对象
     *
     * @return 自定义标签面板属性对象
     */
    public TiankafeiTabbedAttributeVO getTiankafeiTabbedAttributeVO() {
        return tiankafeiTabbedAttributeVO;
    }

    /**
     * 设置自定义标签面板属性对象
     *
     * @param tiankafeiTabbedAttributeVO 自定义标签面板属性对象
     */
    public void setTiankafeiTabbedAttributeVO(TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO) {
        this.tiankafeiTabbedAttributeVO = tiankafeiTabbedAttributeVO;
    }

}
