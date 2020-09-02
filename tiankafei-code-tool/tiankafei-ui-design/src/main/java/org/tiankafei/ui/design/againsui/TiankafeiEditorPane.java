package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfEditorPane;

/**
 * 自定义编辑面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiEditorPane extends TiankafeiDesignerVO {

    /**
     * 自定义编辑面板对象
     */
    private TkfEditorPane tkfEditorPane;

    /**
     * 构造自定义编辑面板对象
     */
    public TiankafeiEditorPane() {
        tkfEditorPane = new TkfEditorPane();
    }

    /**
     * 初始化自定义编辑面板对象
     *
     * @return 自定义编辑面板对象
     */
    public TkfEditorPane initTiankafeiEditorPane() {
        tkfEditorPane.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfEditorPane);

        return tkfEditorPane;
    }

}
