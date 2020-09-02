package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfSpinner;

/**
 * 自定义微调对象
 *
 * @author tiankafei1
 */
public class TiankafeiSpinner extends TiankafeiDesignerVO {

    /**
     * 自定义微调对象
     */
    private TkfSpinner tkfSpinner;

    /**
     * 构造自定义微调对象
     */
    public TiankafeiSpinner() {
        tkfSpinner = new TkfSpinner();
    }

    /**
     * 初始化自定义微调对象
     *
     * @return 自定义微调对象
     */
    public TkfSpinner initTiankafeiSpinner() {
        tkfSpinner.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfSpinner);

        return tkfSpinner;
    }

}
