package org.tiankafei.poi.model;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface ICellStyle {

    /**
     * 获取边框样式
     *
     * @return
     */
    IBorder getBorder();

    /**
     * 设置边框样式
     *
     * @param border
     */
    void setBorder(IBorder border);

    /**
     * 获取字体
     *
     * @return
     */
    public IFont getFont();

    /**
     * 设置字体
     *
     * @param font
     */
    public void setFont(IFont font);

}
