package org.tiankafei.ui.chart.line;

import org.tiankafei.ui.chart.dto.TiankafeiLineCharDTO;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;

/**
 * 自定义线形面板控件
 *
 * @author 甜咖啡
 */
public class TiankafeiLineCharControls {

    /**
     * 自定义线形参数对象
     */
    private TiankafeiLineCharDTO tiankafeiLineCharVO;

    /**
     * 自定义线形面板
     */
    private TiankafeiLineCharPanel tiankafeiLineCharPanel;

    /**
     * 构造自定义线形面板控件对象
     */
    public TiankafeiLineCharControls() {
        tiankafeiLineCharVO = new TiankafeiLineCharDTO();
        tiankafeiLineCharPanel = new TiankafeiLineCharPanel();
    }

    /**
     * 初始化线形面板控件
     *
     * @return 线形面板控件
     */
    public TkfDemoPanel initTiankafeiLineCharControls() {
        tiankafeiLineCharPanel.setTiankafeiLineCharVO(tiankafeiLineCharVO);
        tiankafeiLineCharPanel.initTiankafeiLineCharPanel();
        return tiankafeiLineCharPanel;
    }

    /**
     * 获取自定义线形参数对象
     *
     * @return 自定义线形参数对象
     */
    public TiankafeiLineCharDTO getTiankafeiLineCharVO() {
        return tiankafeiLineCharVO;
    }

    /**
     * 设置自定义线形参数对象
     *
     * @param tiankafeiLineCharVO 自定义线形参数对象
     */
    public void setTiankafeiLineCharVO(TiankafeiLineCharDTO tiankafeiLineCharVO) {
        this.tiankafeiLineCharVO = tiankafeiLineCharVO;
    }
}
