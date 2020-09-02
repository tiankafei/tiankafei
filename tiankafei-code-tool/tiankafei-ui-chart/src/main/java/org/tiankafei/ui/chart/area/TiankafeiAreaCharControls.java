package org.tiankafei.ui.chart.area;

import org.tiankafei.ui.chart.dto.TiankafeiAreaCharDTO;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;

/**
 * 自定义柱状区域面板控件
 *
 * @author 甜咖啡
 */
public class TiankafeiAreaCharControls {

    /**
     * 自定义柱状区域参数对象
     */
    private TiankafeiAreaCharDTO tiankafeiAreaCharDTO;

    /**
     * 构造自定义柱状区域面板控件
     */
    public TiankafeiAreaCharControls() {
        tiankafeiAreaCharDTO = new TiankafeiAreaCharDTO();
    }

    /**
     * 初始化自定义柱状区域面板控件
     *
     * @return 自定义柱状区域面板控件
     */
    public TkfDemoPanel initTiankafeiAreaCharControls() {
        return new TkfDemoPanel();
    }

    /**
     * 获取自定义柱状区域参数对象
     *
     * @return 自定义柱状区域参数对象
     */
    public TiankafeiAreaCharDTO getTiankafeiAreaCharDTO() {
        return tiankafeiAreaCharDTO;
    }

    /**
     * 设置自定义柱状区域参数对象
     *
     * @param tiankafeiAreaCharDTO 自定义柱状区域参数对象
     */
    public void setTiankafeiAreaCharDTO(TiankafeiAreaCharDTO tiankafeiAreaCharDTO) {
        this.tiankafeiAreaCharDTO = tiankafeiAreaCharDTO;
    }
}
