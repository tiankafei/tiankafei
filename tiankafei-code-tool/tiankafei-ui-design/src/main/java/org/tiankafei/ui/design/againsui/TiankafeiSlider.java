package org.tiankafei.ui.design.againsui;

import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfSlider;

/**
 * 自定义滑块对象
 *
 * @author tiankafei1
 */
public class TiankafeiSlider extends TiankafeiDesignerVO {

    /**
     * 自定义滑块对象
     */
    private TkfSlider tkfSlider;

    /**
     * 构造自定义滑块对象
     */
    public TiankafeiSlider() {
        tkfSlider = new TkfSlider();
    }

    /**
     * 初始化自定义滑块对象
     *
     * @return 自定义滑块对象
     */
    public TkfSlider initTiankafeiSlider() {
        tkfSlider.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfSlider);

        return tkfSlider;
    }

}
