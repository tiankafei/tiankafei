package org.tiankafei.poi.property;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface CellStyleProperty {

    /**
     * 获取边框样式
     *
     * @return
     */
    BorderProperty getBorder();

    /**
     * 设置边框样式
     *
     * @param border
     */
    void setBorder(BorderProperty border);

    /**
     * 获取字体
     *
     * @return
     */
    public FontProperty getFont();

    /**
     * 设置字体
     *
     * @param font
     */
    public void setFont(FontProperty font);

}
