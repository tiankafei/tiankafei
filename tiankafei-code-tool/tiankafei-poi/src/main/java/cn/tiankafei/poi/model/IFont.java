package cn.tiankafei.poi.model;

import java.awt.Color;

/**
 * @author tiankafei
 */
public interface IFont {

    /**
     * 获取下划线类型
     *
     * @return
     */
    public int getUnderline();

    /**
     * 设置下划线类型
     *
     * @param underline
     */
    public void setUnderline(int underline);

    /**
     * @return
     */
    public int getTypeOffset();

    /**
     * @param typeOffset
     */
    public void setTypeOffset(int typeOffset);

    /**
     * 是否加粗
     *
     * @return
     */
    public boolean isBold();

    /**
     * 设置加粗
     *
     * @param bold
     */
    public void setBold(boolean bold);

    /**
     * @return
     */
    public int getCharSet();

    /**
     * @param charSet
     */
    public void setCharSet(int charSet);

    /**
     * 获取字体颜色
     *
     * @return
     */
    public Color getColor();

    /**
     * 设置字体颜色
     *
     * @param color
     */
    public void setColor(Color color);

    /**
     * 获取字体大小
     *
     * @return
     */
    public int getFontSize();

    /**
     * 设置字体大小
     *
     * @param fontSize
     */
    public void setFontSize(int fontSize);

    /**
     * 获取字体名称
     *
     * @return
     */
    public String getFontName();

    /**
     * 设置字体名称
     *
     * @param fontName
     */
    public void setFontName(String fontName);

    /**
     * 是否斜体
     *
     * @return
     */
    public boolean isItalic();

    /**
     * 设置斜体
     *
     * @param italic
     */
    public void setItalic(boolean italic);

    /**
     * @return
     */
    public boolean isStrikeout();

    /**
     * @param strikeout
     */
    public void setStrikeout(boolean strikeout);

}
