package org.tiankafei.ui.design.models;

import java.awt.Color;
import java.util.List;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;

/**
 * 自定义窗体属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiFrameAttributeVO {

    /**
     * 窗体是否可以拉伸的标识
     */
    private Boolean frameResizable;

    /**
     * 是否需要自定义窗体的标识
     */
    private Boolean frameCustomFlag;

    /**
     * 自定义窗体边框背景色
     */
    private Color frameCustonBorderColor;

    /**
     * 自定义窗体边框的宽度
     */
    private Integer frameCustonBorderWidth;

    /**
     * 是否退出系统标识
     */
    private Boolean frameExitFlag;

    /**
     * 本级菜单集合
     */
    private List<MenuVO> menuList;

    /**
     * 窗口主题
     */
    private Integer frameTheme;

    /**
     * 记忆的宽度
     */
    private Integer rememberWidth;

    /**
     * 记忆的高度
     */
    private Integer rememberHeight;

    /**
     * 标题栏背景色
     */
    private Color titlebackgroundColor;

    /**
     * 系统图标路径
     */
    private String systemIconFilePath;

    /**
     * 系统图标宽度
     */
    private Integer systemIconWidth;

    /**
     * 系统图标高度
     */
    private Integer systemIconHeight;


    /**
     * 窗体最小化图标路径
     */
    private String minIconFilePath;

    /**
     * 窗体最小化图标宽度
     */
    private Integer minIconWidth;

    /**
     * 窗体最小化图标高度
     */
    private Integer minIconHeight;

    /**
     * 窗体最小化鼠标滑动时图标路径
     */
    private String minMoveIconFilePath;


    /**
     * 窗体最大化图标路径
     */
    private String maxIconFilePath;

    /**
     * 窗体最大化图标宽度
     */
    private Integer maxIconWidth;

    /**
     * 窗体最大化图标高度
     */
    private Integer maxIconHeight;

    /**
     * 窗体最大化鼠标滑动时的图标路径
     */
    private String maxMoveIconFilePath;


    /**
     * 窗体最大化缩放图标路径
     */
    private String maxScalingIconFilePath;

    /**
     * 窗体最大化缩放图标宽度
     */
    private Integer maxScalingIconWidth;

    /**
     * 窗体最大化缩放图标高度
     */
    private Integer maxScalingIconHeight;

    /**
     * 窗体最大化缩放鼠标滑动时图标路径
     */
    private String maxScalingMoveIconFilePath;


    /**
     * 窗体关闭图标路径
     */
    private String exitIconFilePath;

    /**
     * 窗体关闭图标宽度
     */
    private Integer exitIconWidth;

    /**
     * 窗体关闭图标高度
     */
    private Integer exitIconHeight;

    /**
     * 构造自定义窗体属性对象
     */
    public TiankafeiFrameAttributeVO() {
        frameResizable = true;
        frameCustomFlag = false;
        frameCustonBorderColor = Color.BLUE;
        frameCustonBorderWidth = 3;
        frameExitFlag = true;
        frameTheme = TiankafeiDesignerConstants.SWING_THEME_WINDOWS;

        titlebackgroundColor = new Color(99, 180, 251);

        systemIconFilePath = "/images/home.png";
        systemIconWidth = 16;
        systemIconHeight = 16;

        minIconFilePath = "/images/min.png";
        minIconWidth = 26;
        minIconHeight = 20;
        minMoveIconFilePath = "/images/minMove.png";

        maxIconFilePath = "/images/max.png";
        maxIconWidth = 26;
        maxIconHeight = 20;
        maxMoveIconFilePath = "/images/maxMove.png";

        maxScalingIconFilePath = "/images/scaling.png";
        maxScalingIconWidth = 26;
        maxScalingIconHeight = 20;
        maxScalingMoveIconFilePath = "/images/scalingMove.png";

        exitIconFilePath = "/images/exit.png";
        exitIconWidth = 45;
        exitIconHeight = 20;

        rememberWidth = 0;
        rememberHeight = 0;
    }

    /**
     * 获取窗体是否可以拉伸的标识
     *
     * @return 窗体是否可以拉伸的标识
     */
    public boolean isFrameResizable() {
        return frameResizable;
    }

    /**
     * 设置窗体是否可以拉伸的标识
     *
     * @param frameResizable 窗体是否可以拉伸的标识
     */
    public void setFrameResizable(boolean frameResizable) {
        this.frameResizable = frameResizable;
    }

    /**
     * 获取是否需要自定义窗体的标识
     *
     * @return 是否需要自定义窗体的标识
     */
    public boolean isFrameCustomFlag() {
        return frameCustomFlag;
    }

    /**
     * 设置是否需要自定义窗体的标识
     *
     * @param frameCustomFlag 是否需要自定义窗体的标识
     */
    public void setFrameCustomFlag(boolean frameCustomFlag) {
        this.frameCustomFlag = frameCustomFlag;
    }

    /**
     * 获取自定义窗体边框背景色
     *
     * @return 自定义窗体边框背景色
     */
    public Color getFrameCustonBorderColor() {
        return frameCustonBorderColor;
    }

    /**
     * 设置自定义窗体边框背景色
     *
     * @param frameCustonBorderColor 自定义窗体边框背景色
     */
    public void setFrameCustonBorderColor(Color frameCustonBorderColor) {
        this.frameCustonBorderColor = frameCustonBorderColor;
    }

    /**
     * 获取自定义窗体边框的宽度
     *
     * @return 自定义窗体边框的宽度
     */
    public int getFrameCustonBorderWidth() {
        return frameCustonBorderWidth;
    }

    /**
     * 设置自定义窗体边框的宽度
     *
     * @param frameCustonBorderWidth 自定义窗体边框的宽度
     */
    public void setFrameCustonBorderWidth(int frameCustonBorderWidth) {
        this.frameCustonBorderWidth = frameCustonBorderWidth;
    }

    /**
     * 获取是否退出系统标识
     *
     * @return 是否退出系统标识
     */
    public boolean isFrameExitFlag() {
        return frameExitFlag;
    }

    /**
     * 设置是否退出系统标识
     *
     * @param frameExitFlag 是否退出系统标识
     */
    public void setFrameExitFlag(boolean frameExitFlag) {
        this.frameExitFlag = frameExitFlag;
    }

    /**
     * 获取本级菜单集合
     *
     * @return 本级菜单集合
     */
    public List<MenuVO> getMenuList() {
        return menuList;
    }

    /**
     * 设置本级菜单集合
     *
     * @param menuList 本级菜单集合
     */
    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    /**
     * 获取窗口主题
     *
     * @return 窗口主题
     */
    public int getFrameTheme() {
        return frameTheme;
    }

    /**
     * 设置窗口主题
     *
     * @param frameTheme 窗口主题
     */
    public void setFrameTheme(int frameTheme) {
        this.frameTheme = frameTheme;
    }

    /**
     * 获取记忆的宽度
     *
     * @return 记忆的宽度
     */
    public int getRememberWidth() {
        return rememberWidth;
    }

    /**
     * 设置记忆的宽度
     *
     * @param rememberWidth 记忆的宽度
     */
    public void setRememberWidth(int rememberWidth) {
        this.rememberWidth = rememberWidth;
    }

    /**
     * 获取记忆的高度
     *
     * @return 记忆的高度
     */
    public int getRememberHeight() {
        return rememberHeight;
    }

    /**
     * 设置记忆的高度
     *
     * @param rememberHeight 记忆的高度
     */
    public void setRememberHeight(int rememberHeight) {
        this.rememberHeight = rememberHeight;
    }

    /**
     * 获取标题栏背景色
     *
     * @return 标题栏背景色
     */
    public Color getTitlebackgroundColor() {
        return titlebackgroundColor;
    }

    /**
     * 设置标题栏背景色
     *
     * @param titlebackgroundColor 标题栏背景色
     */
    public void setTitlebackgroundColor(Color titlebackgroundColor) {
        this.titlebackgroundColor = titlebackgroundColor;
    }

    /**
     * 获取系统图标路径
     *
     * @return 系统图标路径
     */
    public String getSystemIconFilePath() {
        return systemIconFilePath;
    }

    /**
     * 设置系统图标路径
     *
     * @param systemIconFilePath 系统图标路径
     */
    public void setSystemIconFilePath(String systemIconFilePath) {
        this.systemIconFilePath = systemIconFilePath;
    }

    /**
     * 获取系统图标宽度
     *
     * @return 系统图标宽度
     */
    public int getSystemIconWidth() {
        return systemIconWidth;
    }

    /**
     * 设置系统图标宽度
     *
     * @param systemIconWidth 系统图标宽度
     */
    public void setSystemIconWidth(int systemIconWidth) {
        this.systemIconWidth = systemIconWidth;
    }

    /**
     * 获取系统图标高度
     *
     * @return 系统图标高度
     */
    public int getSystemIconHeight() {
        return systemIconHeight;
    }

    /**
     * 设置系统图标高度
     *
     * @param systemIconHeight 系统图标高度
     */
    public void setSystemIconHeight(int systemIconHeight) {
        this.systemIconHeight = systemIconHeight;
    }

    /**
     * 获取窗体最小化图标路径
     *
     * @return 窗体最小化图标路径
     */
    public String getMinIconFilePath() {
        return minIconFilePath;
    }

    /**
     * 设置窗体最小化图标路径
     *
     * @param minIconFilePath 窗体最小化图标路径
     */
    public void setMinIconFilePath(String minIconFilePath) {
        this.minIconFilePath = minIconFilePath;
    }

    /**
     * 获取窗体最小化图标宽度
     *
     * @return 窗体最小化图标宽度
     */
    public int getMinIconWidth() {
        return minIconWidth;
    }

    /**
     * 设置窗体最小化图标宽度
     *
     * @param minIconWidth 窗体最小化图标宽度
     */
    public void setMinIconWidth(int minIconWidth) {
        this.minIconWidth = minIconWidth;
    }

    /**
     * 获取窗体最小化图标高度
     *
     * @return 窗体最小化图标高度
     */
    public int getMinIconHeight() {
        return minIconHeight;
    }

    /**
     * 窗体最小化图标高度
     *
     * @param minIconHeight 窗体最小化图标高度
     */
    public void setMinIconHeight(int minIconHeight) {
        this.minIconHeight = minIconHeight;
    }

    /**
     * 获取窗体最小化鼠标滑动时图标路径
     *
     * @return 窗体最小化鼠标滑动时图标路径
     */
    public String getMinMoveIconFilePath() {
        return minMoveIconFilePath;
    }

    /**
     * 窗体最小化鼠标滑动时图标路径
     *
     * @param minMoveIconFilePath 窗体最小化鼠标滑动时图标路径
     */
    public void setMinMoveIconFilePath(String minMoveIconFilePath) {
        this.minMoveIconFilePath = minMoveIconFilePath;
    }

    /**
     * 获取窗体最大化图标路径
     *
     * @return 窗体最大化图标路径
     */
    public String getMaxIconFilePath() {
        return maxIconFilePath;
    }

    /**
     * 设置窗体最大化图标路径
     *
     * @param maxIconFilePath 窗体最大化图标路径
     */
    public void setMaxIconFilePath(String maxIconFilePath) {
        this.maxIconFilePath = maxIconFilePath;
    }

    /**
     * 获取窗体最大化图标宽度
     *
     * @return 窗体最大化图标宽度
     */
    public int getMaxIconWidth() {
        return maxIconWidth;
    }

    /**
     * 设置窗体最大化图标宽度
     *
     * @param maxIconWidth 窗体最大化图标宽度
     */
    public void setMaxIconWidth(int maxIconWidth) {
        this.maxIconWidth = maxIconWidth;
    }

    /**
     * 获取窗体最大化图标高度
     *
     * @return 窗体最大化图标高度
     */
    public int getMaxIconHeight() {
        return maxIconHeight;
    }

    /**
     * 设置窗体最大化图标高度
     *
     * @param maxIconHeight 窗体最大化图标高度
     */
    public void setMaxIconHeight(int maxIconHeight) {
        this.maxIconHeight = maxIconHeight;
    }

    /**
     * 获取窗体最大化鼠标滑动时的图标路径
     *
     * @return 窗体最大化鼠标滑动时的图标路径
     */
    public String getMaxMoveIconFilePath() {
        return maxMoveIconFilePath;
    }

    /**
     * 窗体最大化鼠标滑动时的图标路径
     *
     * @param maxMoveIconFilePath 窗体最大化鼠标滑动时的图标路径
     */
    public void setMaxMoveIconFilePath(String maxMoveIconFilePath) {
        this.maxMoveIconFilePath = maxMoveIconFilePath;
    }

    /**
     * 获取窗体最大化缩放图标路径
     *
     * @return 窗体最大化缩放图标路径
     */
    public String getMaxScalingIconFilePath() {
        return maxScalingIconFilePath;
    }

    /**
     * 设置窗体最大化缩放图标路径
     *
     * @param maxScalingIconFilePath 窗体最大化缩放图标路径
     */
    public void setMaxScalingIconFilePath(String maxScalingIconFilePath) {
        this.maxScalingIconFilePath = maxScalingIconFilePath;
    }

    /**
     * 获取窗体最大化缩放图标宽度
     *
     * @return 窗体最大化缩放图标宽度
     */
    public int getMaxScalingIconWidth() {
        return maxScalingIconWidth;
    }

    /**
     * 设置窗体最大化缩放图标宽度
     *
     * @param maxScalingIconWidth 窗体最大化缩放图标宽度
     */
    public void setMaxScalingIconWidth(int maxScalingIconWidth) {
        this.maxScalingIconWidth = maxScalingIconWidth;
    }

    /**
     * 获取窗体最大化缩放图标高度
     *
     * @return 窗体最大化缩放图标高度
     */
    public int getMaxScalingIconHeight() {
        return maxScalingIconHeight;
    }

    /**
     * 设置窗体最大化缩放图标高度
     *
     * @param maxScalingIconHeight 窗体最大化缩放图标高度
     */
    public void setMaxScalingIconHeight(int maxScalingIconHeight) {
        this.maxScalingIconHeight = maxScalingIconHeight;
    }

    /**
     * 获取窗体最大化缩放鼠标滑动时图标路径
     *
     * @return 窗体最大化缩放鼠标滑动时图标路径
     */
    public String getMaxScalingMoveIconFilePath() {
        return maxScalingMoveIconFilePath;
    }

    /**
     * 设置窗体最大化缩放鼠标滑动时图标路径
     *
     * @param maxScalingMoveIconFilePath 窗体最大化缩放鼠标滑动时图标路径
     */
    public void setMaxScalingMoveIconFilePath(String maxScalingMoveIconFilePath) {
        this.maxScalingMoveIconFilePath = maxScalingMoveIconFilePath;
    }

    /**
     * 获取窗体关闭图标路径
     *
     * @return 窗体关闭图标路径
     */
    public String getExitIconFilePath() {
        return exitIconFilePath;
    }

    /**
     * 设置窗体关闭图标路径
     *
     * @param exitIconFilePath 窗体关闭图标路径
     */
    public void setExitIconFilePath(String exitIconFilePath) {
        this.exitIconFilePath = exitIconFilePath;
    }

    /**
     * 获取窗体关闭图标宽度
     *
     * @return 窗体关闭图标宽度
     */
    public int getExitIconWidth() {
        return exitIconWidth;
    }

    /**
     * 设置窗体关闭图标宽度
     *
     * @param exitIconWidth 窗体关闭图标宽度
     */
    public void setExitIconWidth(int exitIconWidth) {
        this.exitIconWidth = exitIconWidth;
    }

    /**
     * 获取窗体关闭图标高度
     *
     * @return 窗体关闭图标高度
     */
    public int getExitIconHeight() {
        return exitIconHeight;
    }

    /**
     * 设置窗体关闭图标高度
     *
     * @param exitIconHeight 窗体关闭图标高度
     */
    public void setExitIconHeight(int exitIconHeight) {
        this.exitIconHeight = exitIconHeight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
