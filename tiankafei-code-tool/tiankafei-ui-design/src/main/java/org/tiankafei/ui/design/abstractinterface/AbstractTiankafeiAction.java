package org.tiankafei.ui.design.abstractinterface;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiMenuItem;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfMenuItem;

/**
 * @author 甜咖啡
 */
public abstract class AbstractTiankafeiAction extends AbstractAction {

    private static final long serialVersionUID = 1679256591181952771L;

    /**
     * 是否可编辑的标识
     */
    private boolean enabled;

    /**
     * 显示文本
     */
    private String displayText;

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
    private int iconWidth;

    /**
     * 控件图标高度
     */
    private int iconHeight;

    /**
     * 控件宽度
     */
    private int width;

    /**
     * 右键菜单项
     */
    private TkfMenuItem tkfPopupMenuItem;

    /**
     * 菜单项
     */
    private TkfMenuItem tkfMenuItem;

    /**
     * 按钮
     */
    private TkfButton tkfButton;

    public AbstractTiankafeiAction() {
        iconWidth = 16;
        iconHeight = 16;
    }

    /**
     * 初始化右键菜单项
     *
     * @return 菜单项
     * @throws BaseException 自定义异常
     */
    public TkfMenuItem initTiankafeiPopupMenuItem() throws BaseException {
        TiankafeiMenuItem tiankafeiPopupMenuItem = new TiankafeiMenuItem();
        tiankafeiPopupMenuItem.setText(displayText);
        tiankafeiPopupMenuItem.setWidth(width);
        tiankafeiPopupMenuItem.setIconHeight(iconHeight);
        tiankafeiPopupMenuItem.setIconWidth(iconWidth);
        tiankafeiPopupMenuItem.setIconFilePath(iconFilePath);
        if (StringUtils.isEmpty(toolTipText)) {
            tiankafeiPopupMenuItem.setToolTipText("<html>" + displayText + "</html>");
        } else {
            tiankafeiPopupMenuItem.setToolTipText("<html>" + toolTipText + "</html>");
        }

        tkfPopupMenuItem = tiankafeiPopupMenuItem.initTiankafeiMenuItem();
        tkfPopupMenuItem.setEnabled(enabled);
        tkfPopupMenuItem.addActionListener(this);
        return tkfPopupMenuItem;
    }

    /**
     * 初始化菜单项
     *
     * @return 菜单项
     * @throws BaseException 自定义异常
     */
    public TkfMenuItem initTiankafeiMenuItem() throws BaseException {
        TiankafeiMenuItem tiankafeiMenuItem = new TiankafeiMenuItem();
        tiankafeiMenuItem.setText(displayText);
        tiankafeiMenuItem.setWidth(width);
        tiankafeiMenuItem.setIconHeight(iconHeight);
        tiankafeiMenuItem.setIconWidth(iconWidth);
        tiankafeiMenuItem.setIconFilePath(iconFilePath);
        if (StringUtils.isEmpty(toolTipText)) {
            tiankafeiMenuItem.setToolTipText("<html>" + displayText + "</html>");
        } else {
            tiankafeiMenuItem.setToolTipText("<html>" + toolTipText + "</html>");
        }

        tkfMenuItem = tiankafeiMenuItem.initTiankafeiMenuItem();
        tkfMenuItem.setEnabled(enabled);
        tkfMenuItem.addActionListener(this);
        return tkfMenuItem;
    }

    /**
     * 初始化按钮
     *
     * @return 按钮
     * @throws BaseException 自定义异常
     */
    public TkfButton initTiankafeiButton() throws BaseException {
        TiankafeiButton tiankafeiButton = new TiankafeiButton();
        tiankafeiButton.setText(displayText);
        tiankafeiButton.setWidth(width);
        tiankafeiButton.setIconHeight(iconHeight);
        tiankafeiButton.setIconWidth(iconWidth);
        tiankafeiButton.setIconFilePath(iconFilePath);
        if (StringUtils.isEmpty(toolTipText)) {
            tiankafeiButton.setToolTipText("<html>" + displayText + "</html>");
        } else {
            tiankafeiButton.setToolTipText("<html>" + toolTipText + "</html>");
        }

        tkfButton = tiankafeiButton.initTiankafeiButton();
        tkfButton.setEnabled(enabled);
        tkfButton.addActionListener(this);
        return tkfButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * 获取快捷键组合对象
     *
     * @return 快捷键组合对象
     */
    public KeyStroke[] getKeyStrokeArray() {
        return null;
    }

    /**
     * 获取是否可编辑的标识
     *
     * @return 是否可编辑的标识
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置是否可编辑的标识
     *
     * @param enabled 是否可编辑的标识
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取显示文本
     *
     * @return 显示文本
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * 设置显示文本
     *
     * @param displayText 显示文本
     */
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
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
     * 获取控件宽度
     *
     * @return 控件宽度
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置控件宽度
     *
     * @param width 控件宽度
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取右键菜单项
     *
     * @return 右键菜单项
     */
    public TkfMenuItem getTkfPopupMenuItem() {
        return tkfPopupMenuItem;
    }

    /**
     * 获取菜单项
     *
     * @return 菜单项
     */
    public TkfMenuItem getTkfMenuItem() {
        return tkfMenuItem;
    }

    /**
     * 获取按钮
     *
     * @return 按钮
     */
    public TkfButton getTkfButton() {
        return tkfButton;
    }

}
