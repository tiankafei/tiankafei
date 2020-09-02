package org.tiankafei.ui.design.models;

import java.awt.Color;
import java.util.Vector;

/**
 * 自定义标签面板属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiTabbedAttributeVO {

    /**
     * 可关闭的容器
     */
    private Vector<Boolean> closableVector;

    /**
     * 显示关闭图标的标识(该参数为true时，无论是否选中，都显示可关闭按钮；为false时，只有选中时才显示)
     */
    private Boolean showClosedFlag;

    /**
     * 标签边框背景色
     */
    private Color tabBorderColor;

    /**
     * 标签渐变上方颜色
     */
    private Color tabTopColor;

    /**
     * 标签渐变下方颜色
     */
    private Color tabBottomColor;

    /**
     * 构造自定义标签面板属性对象
     */
    public TiankafeiTabbedAttributeVO() {
        closableVector = new Vector<Boolean>();
        showClosedFlag = false;
        tabBorderColor = Color.GRAY;
        tabTopColor = Color.LIGHT_GRAY;
        tabBottomColor = Color.WHITE;
    }

    /**
     * 获取可关闭的容器
     *
     * @return 可关闭的容器
     */
    public Vector<Boolean> getClosableVector() {
        return closableVector;
    }

    /**
     * 设置可关闭的容器
     *
     * @param closableVector 可关闭的容器
     */
    public void setClosableVector(Vector<Boolean> closableVector) {
        this.closableVector = closableVector;
    }

    /**
     * 获取显示关闭图标的标识
     *
     * @return 显示关闭图标的标识
     */
    public boolean isShowClosedFlag() {
        return showClosedFlag;
    }

    /**
     * 设置显示关闭图标的标识
     *
     * @param showClosedFlag 显示关闭图标的标识
     */
    public void setShowClosedFlag(boolean showClosedFlag) {
        this.showClosedFlag = showClosedFlag;
    }

    /**
     * 获取标签边框背景色
     *
     * @return 标签边框背景色
     */
    public Color getTabBorderColor() {
        return tabBorderColor;
    }

    /**
     * 设置标签边框背景色
     *
     * @param tabBorderColor 标签边框背景色
     */
    public void setTabBorderColor(Color tabBorderColor) {
        this.tabBorderColor = tabBorderColor;
    }

    /**
     * 获取标签渐变上方颜色
     *
     * @return 标签渐变上方颜色
     */
    public Color getTabTopColor() {
        return tabTopColor;
    }

    /**
     * 设置标签渐变上方颜色
     *
     * @param tabTopColor 标签渐变上方颜色
     */
    public void setTabTopColor(Color tabTopColor) {
        this.tabTopColor = tabTopColor;
    }

    /**
     * 获取标签渐变下方颜色
     *
     * @return 标签渐变下方颜色
     */
    public Color getTabBottomColor() {
        return tabBottomColor;
    }

    /**
     * 设置标签渐变下方颜色
     *
     * @param tabBottomColor 标签渐变下方颜色
     */
    public void setTabBottomColor(Color tabBottomColor) {
        this.tabBottomColor = tabBottomColor;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
