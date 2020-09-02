package org.tiankafei.ui.chart.dto;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 自定义线形参数对象
 *
 * @author 甜咖啡
 */
public class TiankafeiLineCharDTO extends TiankafeiChartDTO {

    /**
     * x轴下面显示标签
     */
    private String xLabel;

    /**
     * y轴下面显示标签
     */
    private String yLabel;

    /**
     * 图形轴集合
     */
    private List<TiankafeiAxisDTO> tiankafeiAxisList;

    /**
     * 构造自定义线形参数对象
     */
    public TiankafeiLineCharDTO() {
        tiankafeiAxisList = Lists.newArrayList();
    }

    /**
     * 获取x轴下面显示标签
     *
     * @return x轴下面显示标签
     */
    public String getxLabel() {
        return xLabel;
    }

    /**
     * 设置x轴下面显示标签
     *
     * @param xLabel x轴下面显示标签
     */
    public void setxLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    /**
     * 获取y轴下面显示标签
     *
     * @return y轴下面显示标签
     */
    public String getyLabel() {
        return yLabel;
    }

    /**
     * 设置y轴下面显示标签
     *
     * @param yLabel y轴下面显示标签
     */
    public void setyLabel(String yLabel) {
        this.yLabel = yLabel;
    }

    /**
     * 获取图形轴集合
     *
     * @return 图形轴集合
     */
    public List<TiankafeiAxisDTO> getTiankafeiAxisList() {
        return tiankafeiAxisList;
    }

    /**
     * 设置图形轴集合
     *
     * @param tiankafeiAxisList 图形轴集合
     */
    public void setTiankafeiAxisList(List<TiankafeiAxisDTO> tiankafeiAxisList) {
        this.tiankafeiAxisList = tiankafeiAxisList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
