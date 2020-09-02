package org.tiankafei.ui.chart.modelsui;

import java.awt.Font;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 * @author 甜咖啡
 */
public class TkfFreeChart extends JFreeChart {

    private static final long serialVersionUID = 7653980039536109185L;

    public TkfFreeChart(Plot plot) {
        super(plot);
    }

    public TkfFreeChart(String title, Plot plot) {
        super(title, plot);
    }

    public TkfFreeChart(String title, Font titleFont, Plot plot, boolean createLegend) {
        super(title, titleFont, plot, createLegend);
    }
}
