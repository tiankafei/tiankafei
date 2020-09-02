package org.tiankafei.ui.chart.dto;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 图形的轴对象
 *
 * @author 甜咖啡
 */
public class TiankafeiAxisDTO {

    /**
     * 轴描述
     */
    private String title;

    /**
     * 轴上的点集合
     */
    private List<TiankafeiAxixPointDTO> tiankafeiAxixPointList;

    /**
     * 构造图形的轴对象
     */
    public TiankafeiAxisDTO() {
        tiankafeiAxixPointList = Lists.newArrayList();
    }

    /**
     * 获取轴描述
     *
     * @return 轴描述
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置轴描述
     *
     * @param title 轴描述
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取轴上的点集合
     *
     * @return 轴上的点集合
     */
    public List<TiankafeiAxixPointDTO> getTiankafeiAxixPointList() {
        return tiankafeiAxixPointList;
    }

    /**
     * 设置轴上的点集合
     *
     * @param tiankafeiAxixPointList 轴上的点集合
     */
    public void setTiankafeiAxixPointList(List<TiankafeiAxixPointDTO> tiankafeiAxixPointList) {
        this.tiankafeiAxixPointList = tiankafeiAxixPointList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
