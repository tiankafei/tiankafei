package org.tiankafei.ui.chart.dto;

/**
 * 图形轴上的点对象
 *
 * @author 甜咖啡
 */
public class TiankafeiAxixPointDTO {

    /**
     * x轴上点的值
     */
    private Double xPointValue;

    /**
     * y轴上点的值
     */
    private Double yPointValue;

    /**
     * x轴上点的值
     */
    private String xStringValue;

    /**
     * y轴上点的值
     */
    private String yStringValue;

    public TiankafeiAxixPointDTO() {
        xPointValue = 0.0;
        yPointValue = 0.0;
    }

    /**
     * 获取x轴上点的值
     *
     * @return x轴上点的值
     */
    public double getxPointValue() {
        return xPointValue;
    }

    /**
     * 设置x轴上点的值
     *
     * @param xPointValue x轴上点的值
     */
    public void setxPointValue(double xPointValue) {
        this.xPointValue = xPointValue;
    }

    /**
     * 获取y轴上点的值
     *
     * @return y轴上点的值
     */
    public double getyPointValue() {
        return yPointValue;
    }

    /**
     * 设置y轴上点的值
     *
     * @param yPointValue y轴上点的值
     */
    public void setyPointValue(double yPointValue) {
        this.yPointValue = yPointValue;
    }

    /**
     * 获取x轴上点的值
     *
     * @return x轴上点的值
     */
    public String getxStringValue() {
        return xStringValue;
    }

    /**
     * 设置x轴上点的值
     *
     * @param xStringValue x轴上点的值
     */
    public void setxStringValue(String xStringValue) {
        this.xStringValue = xStringValue;
    }

    /**
     * 获取y轴上点的值
     *
     * @return y轴上点的值
     */
    public String getyStringValue() {
        return yStringValue;
    }

    /**
     * 设置y轴上点的值
     *
     * @param yStringValue y轴上点的值
     */
    public void setyStringValue(String yStringValue) {
        this.yStringValue = yStringValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
