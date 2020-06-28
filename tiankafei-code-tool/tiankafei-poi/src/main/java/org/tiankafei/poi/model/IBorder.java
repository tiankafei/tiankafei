package org.tiankafei.poi.model;

import java.awt.Color;

/**
 * @author tiankafei
 */
public interface IBorder {

    /**
     * 获取下边框样式
     *
     * @return
     */
    String getBorderBottomStyle();

    /**
     * 设置下边框样式
     *
     * @param borderBottomStyle
     */
    void setBorderBottomStyle(String borderBottomStyle);

    /**
     * 获取上边框样式
     *
     * @return
     */
    String getBorderTopStyle();

    /**
     * 设置上边框样式
     *
     * @param borderTopStyle
     */
    void setBorderTopStyle(String borderTopStyle);

    /**
     * 获取左边框样式
     *
     * @return
     */
    String getBorderLeftStyle();

    /**
     * 设置左边框样式
     *
     * @param borderLeftStyle
     */
    void setBorderLeftStyle(String borderLeftStyle);

    /**
     * 获取右边框样式
     *
     * @return
     */
    String getBorderRightStyle();

    /**
     * 设置右边框样式
     *
     * @param borderRightStyle
     */
    void setBorderRightStyle(String borderRightStyle);

    /**
     * 获取下边框颜色
     *
     * @return
     */
    Color getBorderBottomColor();

    /**
     * 设置下边框颜色
     *
     * @param borderBottomColor
     */
    void setBorderBottomColor(Color borderBottomColor);

    /**
     * 获取上边框颜色
     *
     * @return
     */
    Color getBorderTopColor();

    /**
     * 设置上边框颜色
     *
     * @param borderTopColor
     */
    void setBorderTopColor(Color borderTopColor);

    /**
     * 获取左边框颜色
     *
     * @return
     */
    Color getBorderLeftColor();

    /**
     * 设置左边框颜色
     *
     * @param borderLeftColor
     */
    void setBorderLeftColor(Color borderLeftColor);

    /**
     * 获取右边框颜色
     *
     * @return
     */
    Color getBorderRightColor();

    /**
     * 设置右边框颜色
     *
     * @param borderRightColor
     */
    void setBorderRightColor(Color borderRightColor);

}
