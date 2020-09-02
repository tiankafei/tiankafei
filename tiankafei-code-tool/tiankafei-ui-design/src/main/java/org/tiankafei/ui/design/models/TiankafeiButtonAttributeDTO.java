package org.tiankafei.ui.design.models;

import java.awt.Color;

/**
 * 自定义按钮属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiButtonAttributeDTO {

    /**
     * 决定圆角的弧度
     */
    private Integer radius;

    /**
     * 光标进入按钮判断
     */
    private Boolean hover;

    /**
     * 按钮默认颜色
     */
    private Color defaultColor;

    /**
     * 鼠标滑过时的颜色
     */
    private Color changeColor;

    /**
     * 构造自定义按钮属性对象
     */
    public TiankafeiButtonAttributeDTO() {
        radius = 10;
        hover = false;
        defaultColor = new Color(165, 189, 233);
        changeColor = new Color(76, 127, 208);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getChangeColor() {
        return changeColor;
    }

    public void setChangeColor(Color changeColor) {
        this.changeColor = changeColor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
