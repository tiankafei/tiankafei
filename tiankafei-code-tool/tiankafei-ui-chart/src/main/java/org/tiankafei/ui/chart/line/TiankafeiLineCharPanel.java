package org.tiankafei.ui.chart.line;

import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.tiankafei.ui.chart.dto.TiankafeiAxisDTO;
import org.tiankafei.ui.chart.dto.TiankafeiAxixPointDTO;
import org.tiankafei.ui.chart.dto.TiankafeiLineCharDTO;
import org.tiankafei.ui.chart.modelsui.TkfChartPanel;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;
import org.tiankafei.ui.chart.modelsui.TkfFreeChart;

/**
 * 自定义线形面板
 *
 * @author 甜咖啡
 */
public class TiankafeiLineCharPanel extends TkfDemoPanel {

    private static final long serialVersionUID = 6476341102778047459L;

    /**
     * 自定义线形参数对象
     */
    private TiankafeiLineCharDTO tiankafeiLineCharVO;

    /**
     * 构造自定义线形面板对象
     */
    public TiankafeiLineCharPanel() {
        tiankafeiLineCharVO = new TiankafeiLineCharDTO();
    }

    /**
     * 初始化自定义线形面板
     */
    public void initTiankafeiLineCharPanel() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        List<TiankafeiAxisDTO> tiankafeiAxisList = tiankafeiLineCharVO.getTiankafeiAxisList();
        for (int index = 0, length = tiankafeiAxisList.size(); index < length; index++) {
            TiankafeiAxisDTO tiankafeiAxisDTO = tiankafeiAxisList.get(index);
            XYSeries xySeries = createXySeries(tiankafeiAxisDTO);
            xySeriesCollection.addSeries(xySeries);
        }

        NumberAxis xNumberAxis = new NumberAxis(tiankafeiLineCharVO.getxLabel());
        xNumberAxis.setAutoRangeIncludesZero(false);
        NumberAxis yNumberAxis = new NumberAxis(tiankafeiLineCharVO.getyLabel());
        yNumberAxis.setAutoRangeIncludesZero(false);

        XYPlot xyPlot = new XYPlot(xySeriesCollection, xNumberAxis, yNumberAxis, new XYSplineRenderer());
        xyPlot.setBackgroundPaint(Color.lightGray);
        xyPlot.setDomainGridlinePaint(Color.white);
        xyPlot.setRangeGridlinePaint(Color.white);
        xyPlot.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));

        TkfFreeChart tkfFreeChart = new TkfFreeChart("XYSplineRenderer", TkfFreeChart.DEFAULT_TITLE_FONT, xyPlot, true);
        addFreeChart(tkfFreeChart);
        ChartUtilities.applyCurrentTheme(tkfFreeChart);
        TkfChartPanel tkfChartPanel = new TkfChartPanel(tkfFreeChart);
        add(tkfChartPanel);
    }

    /**
     * 创建轴线
     *
     * @param tiankafeiAxisDTO 图形的轴对象
     * @return 轴线
     */
    private XYSeries createXySeries(TiankafeiAxisDTO tiankafeiAxisDTO) {
        XYSeries xySeries = new XYSeries(tiankafeiAxisDTO.getTitle());
        List<TiankafeiAxixPointDTO> tiankafeiAxixPointList = tiankafeiAxisDTO.getTiankafeiAxixPointList();
        for (int index = 0, length = tiankafeiAxixPointList.size(); index < length; index++) {
            TiankafeiAxixPointDTO tiankafeiAxixPointDTO = tiankafeiAxixPointList.get(index);
            xySeries.add(tiankafeiAxixPointDTO.getxPointValue(), tiankafeiAxixPointDTO.getyPointValue());
        }
        return xySeries;
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
