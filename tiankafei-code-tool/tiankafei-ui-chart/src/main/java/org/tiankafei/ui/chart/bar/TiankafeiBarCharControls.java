package org.tiankafei.ui.chart.bar;

import org.tiankafei.ui.chart.dto.TiankafeiBarCharDTO;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;

/**
 * 自定义柱状图面板控件
 *
 * @author 甜咖啡
 */
public class TiankafeiBarCharControls {

    /**
     * 自定义柱状参数对象
     */
    private TiankafeiBarCharDTO tiankafeiBarCharDTO;

    /**
     * 构造自定义柱状图面板控件对象
     */
    public TiankafeiBarCharControls() {
        tiankafeiBarCharDTO = new TiankafeiBarCharDTO();
    }

    /**
     * 初始化自定义柱状图面板控件
     *
     * @return 自定义柱状图面板控件
     */
    public TkfDemoPanel initTiankafeiBarCharControls() {
        return new TkfDemoPanel();
    }

    /**
     * 获取自定义柱状参数对象
     *
     * @return 自定义柱状参数对象
     */
    public TiankafeiBarCharDTO getTiankafeiBarCharDTO() {
        return tiankafeiBarCharDTO;
    }

    /**
     * 设置自定义柱状参数对象
     *
     * @param tiankafeiBarCharDTO 自定义柱状参数对象
     */
    public void setTiankafeiBarCharDTO(TiankafeiBarCharDTO tiankafeiBarCharDTO) {
        this.tiankafeiBarCharDTO = tiankafeiBarCharDTO;
    }
}
