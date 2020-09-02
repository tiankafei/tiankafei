package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfTextPane;

/**
 * 自定义文本面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiTextPane extends TiankafeiDesignerVO {

    /**
     * 自定义文本面板对象
     */
    private TkfTextPane tkfTextPane;

    /**
     * 构造自定义文本面板对象
     */
    public TiankafeiTextPane() {
        tkfTextPane = new TkfTextPane();
    }

    /**
     * 初始化自定义文本面板对象
     *
     * @return 自定义文本面板对象
     */
    public TkfTextPane initTiankafeiTextPane() {
        tkfTextPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfTextPane);

        return tkfTextPane;
    }

}
