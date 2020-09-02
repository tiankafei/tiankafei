package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfSeparator;

/**
 * 自定义分割器对象
 *
 * @author tiankafei1
 */
public class TiankafeiSeparator extends TiankafeiDesignerVO {

    /**
     * 自定义分割器对象
     */
    private TkfSeparator tkfSeparator;

    /**
     * 构造自定义分割器对象
     */
    public TiankafeiSeparator() {
        tkfSeparator = new TkfSeparator();
    }

    /**
     * 初始化自定义分割器对象
     *
     * @return 自定义分割器对象
     */
    public TkfSeparator initTiankafeiSeparator() {
        tkfSeparator.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfSeparator);

        return tkfSeparator;
    }

}
