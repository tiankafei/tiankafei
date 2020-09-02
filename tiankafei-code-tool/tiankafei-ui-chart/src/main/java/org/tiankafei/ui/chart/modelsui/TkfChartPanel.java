package org.tiankafei.ui.chart.modelsui;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * @author 甜咖啡
 */
public class TkfChartPanel extends ChartPanel {

    private static final long serialVersionUID = 8818311286785571451L;

    public TkfChartPanel(JFreeChart chart) {
        super(chart);
    }

    public TkfChartPanel(JFreeChart chart, boolean useBuffer) {
        super(chart, useBuffer);
    }

    public TkfChartPanel(JFreeChart chart, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips) {
        super(chart, properties, save, print, zoom, tooltips);
    }

    public TkfChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips) {
        super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, save, print, zoom, tooltips);
    }

    public TkfChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean copy, boolean save, boolean print, boolean zoom, boolean tooltips) {
        super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, copy, save, print, zoom, tooltips);
    }
}
