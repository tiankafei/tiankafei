package org.tiankafei.ui.design.models;

/**
 * 自定义输入控件参数对象
 *
 * @author 甜咖啡
 */
public class TiankafeiCustomInputVO {

    /**
     * 自定义输入控件宽度
     */
    private Integer customInputWidth;

    /**
     * 自定义输入控件高度
     */
    private Integer customInputHeight;

    /**
     * 自定义输入控件图片的宽度
     */
    private Integer iconInputWidth;

    /**
     * 控件图标路径
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

    public TiankafeiCustomInputVO() {
        customInputWidth = 200;
        customInputHeight = 24;
        iconInputWidth = 24;
        iconFilePath = "/images/property.png";
        iconWidth = 16;
        iconHeight = 16;
    }

    /**
     * 获取自定义输入控件宽度
     *
     * @return 自定义输入控件宽度
     */
    public int getCustomInputWidth() {
        return customInputWidth;
    }

    /**
     * 设置自定义输入控件宽度
     *
     * @param customInputWidth 自定义输入控件宽度
     */
    public void setCustomInputWidth(int customInputWidth) {
        this.customInputWidth = customInputWidth;
    }

    /**
     * 获取自定义输入控件高度
     *
     * @return 自定义输入控件高度
     */
    public int getCustonInputHeight() {
        return customInputHeight;
    }

    /**
     * 设置自定义输入控件高度
     *
     * @param custonInputHeight 自定义输入控件高度
     */
    public void setCustonInputHeight(int custonInputHeight) {
        this.customInputHeight = custonInputHeight;
    }

    /**
     * 获取自定义输入控件图片的宽度
     *
     * @return 自定义输入控件图片的宽度
     */
    public int getIconInputWidth() {
        return iconInputWidth;
    }

    /**
     * 设置自定义输入控件图片的宽度
     *
     * @param iconInputWidth 自定义输入控件图片的宽度
     */
    public void setIconInputWidth(int iconInputWidth) {
        this.iconInputWidth = iconInputWidth;
    }

    /**
     * 获取控件图标路径
     *
     * @return 控件图标路径
     */
    public String getIconFilePath() {
        return iconFilePath;
    }

    /**
     * 设置控件图标路径
     *
     * @param iconFilePath 控件图标路径
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

    @Override
    public String toString() {
        return super.toString();
    }

}
