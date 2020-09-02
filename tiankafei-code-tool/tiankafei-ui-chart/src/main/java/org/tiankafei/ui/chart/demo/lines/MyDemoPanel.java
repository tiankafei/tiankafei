package org.tiankafei.ui.chart.demo.lines;

import java.awt.Color;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;

/**
 * @author 甜咖啡
 */
public class MyDemoPanel extends TkfDemoPanel {

    private static final long serialVersionUID = 4165119801446273202L;

    private XYDataset data1 = createSampleData();

    public MyDemoPanel() {
        super();
        add(createContent());
    }

    private XYDataset createSampleData() {
        XYSeriesCollection localXySeriesCollection = new XYSeriesCollection();

        XYSeries localXySeries1 = new XYSeries("Series 1");
        localXySeries1.add(2.0D, 56.270000000000003D);
        localXySeries1.add(3.0D, 41.32D);
        localXySeries1.add(4.0D, 31.449999999999999D);
        localXySeries1.add(5.0D, 30.050000000000001D);
        localXySeries1.add(6.0D, 24.690000000000001D);
        localXySeries1.add(7.0D, 19.780000000000001D);
        localXySeries1.add(8.0D, 20.940000000000001D);
        localXySeries1.add(9.0D, 16.73D);
        localXySeries1.add(10.0D, 14.210000000000001D);
        localXySeries1.add(11.0D, 12.44D);
        localXySeriesCollection.addSeries(localXySeries1);

        XYSeries localXySeries2 = new XYSeries("Series 2");
        localXySeries2.add(11.0D, 56.270000000000003D);
        localXySeries2.add(10.0D, 41.32D);
        localXySeries2.add(9.0D, 31.449999999999999D);
        localXySeries2.add(8.0D, 30.050000000000001D);
        localXySeries2.add(7.0D, 24.690000000000001D);
        localXySeries2.add(6.0D, 19.780000000000001D);
        localXySeries2.add(5.0D, 20.940000000000001D);
        localXySeries2.add(4.0D, 16.73D);
        localXySeries2.add(3.0D, 14.210000000000001D);
        localXySeries2.add(2.0D, 12.44D);
        localXySeriesCollection.addSeries(localXySeries2);

        return localXySeriesCollection;
    }

    private JTabbedPane createContent() {
        JTabbedPane localTabbedPane = new JTabbedPane();
        localTabbedPane.add("Splines:", createChartPanel1());
        localTabbedPane.add("Lines:", createChartPanel2());
        return localTabbedPane;
    }

    private ChartPanel createChartPanel1() {
        NumberAxis localNumberAxis1 = new NumberAxis("X");
        localNumberAxis1.setAutoRangeIncludesZero(false);
        NumberAxis localNumberAxis2 = new NumberAxis("Y");
        localNumberAxis2.setAutoRangeIncludesZero(false);
        XYSplineRenderer localXySplineRenderer = new XYSplineRenderer();
        XYPlot localXyPlot = new XYPlot(this.data1, localNumberAxis1, localNumberAxis2, localXySplineRenderer);
        localXyPlot.setBackgroundPaint(Color.lightGray);
        localXyPlot.setDomainGridlinePaint(Color.white);
        localXyPlot.setRangeGridlinePaint(Color.white);
        localXyPlot.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
        JFreeChart localFreeChart = new JFreeChart("XySplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, localXyPlot, true);
        addFreeChart(localFreeChart);
        ChartUtilities.applyCurrentTheme(localFreeChart);
        ChartPanel localChartPanel = new ChartPanel(localFreeChart);
        return localChartPanel;
    }

    private ChartPanel createChartPanel2() {
        NumberAxis localNumberAxis1 = new NumberAxis("X");
        localNumberAxis1.setAutoRangeIncludesZero(false);
        NumberAxis localNumberAxis2 = new NumberAxis("Y");
        localNumberAxis2.setAutoRangeIncludesZero(false);
        XYLineAndShapeRenderer localXyLineAndShapeRenderer = new XYLineAndShapeRenderer();
        XYPlot localXyPlot = new XYPlot(this.data1, localNumberAxis1, localNumberAxis2, localXyLineAndShapeRenderer);
        localXyPlot.setBackgroundPaint(Color.lightGray);
        localXyPlot.setDomainGridlinePaint(Color.white);
        localXyPlot.setRangeGridlinePaint(Color.white);
        localXyPlot.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
        JFreeChart localFreeChart = new JFreeChart("XyLineAndShapeRenderer", JFreeChart.DEFAULT_TITLE_FONT, localXyPlot, true);
        addFreeChart(localFreeChart);
        ChartUtilities.applyCurrentTheme(localFreeChart);
        ChartPanel localChartPanel = new ChartPanel(localFreeChart);
        return localChartPanel;
    }
}
