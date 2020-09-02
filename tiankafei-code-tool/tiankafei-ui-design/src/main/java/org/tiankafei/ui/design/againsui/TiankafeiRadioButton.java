package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfRadioButton;

/**
 * 自定义单选按钮对象
 *
 * @author tiankafei
 */
public class TiankafeiRadioButton extends TiankafeiDesignerVO {

    /**
     * 自定义单选按钮对象
     */
    private TkfRadioButton tkfRadioButton;

    /**
     * 构造自定义单选按钮对象
     */
    public TiankafeiRadioButton() {
        tkfRadioButton = new TkfRadioButton();
    }

    /**
     * 初始化自定义单选按钮对象
     *
     * @return 自定义单选按钮对象
     */
    public TkfRadioButton initTiankafeiRadioButton() {
        tkfRadioButton.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfRadioButton);

        return tkfRadioButton;
    }

}
