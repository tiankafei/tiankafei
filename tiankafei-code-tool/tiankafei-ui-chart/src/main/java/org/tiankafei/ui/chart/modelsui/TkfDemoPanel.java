package org.tiankafei.ui.chart.modelsui;

import com.google.common.collect.Lists;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义图片集面板
 *
 * @author 甜咖啡
 */
public class TkfDemoPanel extends TkfPanel {

    private static final long serialVersionUID = -2366436857737160992L;

    /**
     * 图片面板集合
     */
    private List<JFreeChart> freeChartList;

    /**
     * 构造图片集面板对象
     */
    public TkfDemoPanel() {
        freeChartList = Lists.newArrayList();
    }

    /**
     * 添加图片面板到该对象中
     *
     * @param freeChart 图片面板
     */
    public void addFreeChart(JFreeChart freeChart) {
        freeChartList.add(freeChart);
    }

    /**
     * 获取图片面板集合
     *
     * @return 图片面板集合
     */
    public JFreeChart[] getFreeChartArray() {
        int length = freeChartList.size();
        JFreeChart[] freeChartArray = new JFreeChart[length];
        for (int index = 0; index < length; index++) {
            freeChartArray[index] = freeChartList.get(index);
        }
        return freeChartArray;
    }

    /**
     * 获取图片面板集合
     *
     * @return 图片面板集合
     */
    public List<JFreeChart> getFreeChartList() {
        return freeChartList;
    }

}
