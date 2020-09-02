package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfTextArea;

/**
 * 自定义文本域对象
 *
 * @author tiankafei
 */
public class TiankafeiTextArea extends TiankafeiDesignerVO {

    /**
     * 自定义文本域对象
     */
    private TkfTextArea tkfTextArea;

    /**
     * 构造自定义文本域对象
     */
    public TiankafeiTextArea() {
        tkfTextArea = new TkfTextArea();
    }

    /**
     * 初始化自定义文本域对象
     *
     * @return 自定义文本域对象
     */
    public TkfTextArea initTiankafeiTextArea() {
        tkfTextArea.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfTextArea);

        return tkfTextArea;
    }

}
