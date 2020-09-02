package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfPasswordField;

/**
 * 自定义密码框对象
 *
 * @author tiankafei
 */
public class TiankafeiPasswordField extends TiankafeiDesignerVO {

    /**
     * 自定义密码框对象
     */
    private TkfPasswordField tkfPasswordField;

    /**
     * 构造自定义密码框对象
     */
    public TiankafeiPasswordField() {
        tkfPasswordField = new TkfPasswordField();
    }

    /**
     * 初始化自定义密码框对象
     *
     * @return 自定义密码框对象
     */
    public TkfPasswordField initTiankafeiPasswordField() {
        tkfPasswordField.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfPasswordField);

        return tkfPasswordField;
    }

}
