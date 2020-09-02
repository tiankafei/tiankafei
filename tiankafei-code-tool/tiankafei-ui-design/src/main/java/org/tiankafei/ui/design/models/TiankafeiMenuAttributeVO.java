package org.tiankafei.ui.design.models;

/**
 * 菜单属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiMenuAttributeVO {

    /**
     * 文本内容
     */
    private String text;

    /**
     * 浮现文本
     */
    private String toolTipText;

    /**
     * 图标路径
     */
    private String iconFilePath;

    /**
     * 控件图标宽度
     */
    private Integer iconWidth;

    /**
     * 控件图标高度
     */
    private Integer iconHeight;

    /**
     * 分割标识
     */
    private Boolean separatorFlag;

    /**
     * 构造菜单属性对象
     */
    public TiankafeiMenuAttributeVO() {
        separatorFlag = false;
        iconWidth = 26;
        iconHeight = 26;
    }

    /**
     * 获取文本内容
     *
     * @return 文本内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置文本内容
     *
     * @param text 文本内容
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取浮现文本
     *
     * @return 浮现文本
     */
    public String getToolTipText() {
        return toolTipText;
    }

    /**
     * 设置浮现文本
     *
     * @param toolTipText 浮现文本
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    /**
     * 获取图标路径
     *
     * @return 图标路径
     */
    public String getIconFilePath() {
        return iconFilePath;
    }

    /**
     * 设置图标路径
     *
     * @param iconFilePath 图标路径
     */
    public void setIconFilePath(String iconFilePath) {
        this.iconFilePath = iconFilePath;
    }

    /**
     * 获取控件图标宽度
     *
     * @return 控件图标宽度
     */
    public int getIconWidth() {
        return iconWidth;
    }

    /**
     * 设置控件图标宽度
     *
     * @param iconWidth 控件图标宽度
     */
    public void setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
    }

    /**
     * 获取控件图标高度
     *
     * @return 控件图标高度
     */
    public int getIconHeight() {
        return iconHeight;
    }

    /**
     * 设置控件图标高度
     *
     * @param iconHeight 控件图标高度
     */
    public void setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
    }

    /**
     * 获取分割标识
     *
     * @return 分割标识
     */
    public boolean isSeparatorFlag() {
        return separatorFlag;
    }

    /**
     * 设置分割标识
     *
     * @param separatorFlag 分割标识
     */
    public void setSeparatorFlag(boolean separatorFlag) {
        this.separatorFlag = separatorFlag;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
