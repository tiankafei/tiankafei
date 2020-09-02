package org.tiankafei.ui.design.models;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiAction;
import org.tiankafei.ui.design.againsui.TiankafeiMenu;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.modelsui.TkfMenu;
import org.tiankafei.ui.design.modelsui.TkfMenuItem;
import org.tiankafei.ui.design.modelsui.TkfPopupMenu;
import org.tiankafei.ui.design.util.ImageIconUtil;

/**
 * 自定义的设计器公共对象
 *
 * @author tiankafei1
 */
public class TiankafeiDesignerVO {

    /**
     * 控件宽度
     */
    private Integer width;

    /**
     * 控件高度
     */
    private Integer height;

    /**
     * 控件标题
     */
    private String title;

    /**
     * 控件显示文字
     */
    private String text;

    /**
     * 控件浮现文字
     */
    private String toolTipText;

    /**
     * 控件背景色
     */
    private Color backgroundColor;

    /**
     * 控件前景色
     */
    private Color foregroundColor;

    /**
     * 控件边框颜色
     */
    private Color borderColor;

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

    /**
     * 控件上边框宽度
     */
    private Integer topBorderWidth;

    /**
     * 控件下边框宽度
     */
    private Integer bottomBorderWidth;

    /**
     * 控件左边框宽度
     */
    private Integer leftBorderWidth;

    /**
     * 控件右边框宽度
     */
    private Integer rightBorderWidth;

    /**
     * 字体名称
     */
    private String fontName;

    /**
     * 字体样式
     */
    private Integer fontStyle;

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 提示内容
     */
    private String promptInfo;

    /**
     * 提示内容前景色
     */
    private Color promptForegroundColor;

    /**
     * 文本水平对齐方式
     */
    private Integer textHorizontalAlignment;

    /**
     * 鼠标进入控件是否改变形状的标识
     */
    private Boolean mouseEnteredChangeFlag;

    /**
     * 鼠标进入控件改变的形状
     */
    private Integer mouseEnteredChangeType;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    private Cursor cursor;

    public TiankafeiDesignerVO() {
        width = 0;
        height = 24;
        backgroundColor = Color.WHITE;
        foregroundColor = Color.BLACK;
        borderColor = Color.BLACK;

        topBorderWidth = 1;
        bottomBorderWidth = 1;
        leftBorderWidth = 1;
        rightBorderWidth = 1;

        fontName = "微软雅黑";
        fontStyle = Font.PLAIN;
        fontSize = 12;

        promptForegroundColor = Color.LIGHT_GRAY;
        textHorizontalAlignment = TiankafeiDesignerConstants.SWING_LEFT;
        mouseEnteredChangeFlag = false;
        mouseEnteredChangeType = Cursor.HAND_CURSOR;
        tiankafeiModelUiVO = new TiankafeiModelUiVO();

        iconWidth = 26;
        iconHeight = 26;
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
     * 获取控件高度
     *
     * @return 控件高度
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置控件高度
     *
     * @param height 控件高度
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取控件标题
     *
     * @return 控件标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置控件标题
     *
     * @param title 控件标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取控件显示文字
     *
     * @return 控件显示文字
     */
    public String getText() {
        return text;
    }

    /**
     * 设置控件显示文字
     *
     * @param text 控件显示文字
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取控件浮现文字
     *
     * @return 控件浮现文字
     */
    public String getToolTipText() {
        return toolTipText;
    }

    /**
     * 设置控件浮现文字
     *
     * @param toolTipText 控件浮现文字
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    /**
     * 获取控件背景色
     *
     * @return 控件背景色
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 设置控件背景色
     *
     * @param backgroundColor 控件背景色
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * 获取控件前景色
     *
     * @return 控件前景色
     */
    public Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * 设置控件前景色
     *
     * @param foregroundColor 控件前景色
     */
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * 获取控件边框颜色
     *
     * @return 控件边框颜色
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * 设置控件边框颜色
     *
     * @param borderColor 控件边框颜色
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
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

    /**
     * 获取控件上边框宽度
     *
     * @return 控件上边框宽度
     */
    public int getTopBorderWidth() {
        return topBorderWidth;
    }

    /**
     * 设置控件上边框宽度
     *
     * @param topBorderWidth 控件上边框宽度
     */
    public void setTopBorderWidth(int topBorderWidth) {
        this.topBorderWidth = topBorderWidth;
    }

    /**
     * 获取控件下边框宽度
     *
     * @return 控件下边框宽度
     */
    public int getBottomBorderWidth() {
        return bottomBorderWidth;
    }

    /**
     * 设置控件下边框宽度
     *
     * @param bottomBorderWidth 控件下边框宽度
     */
    public void setBottomBorderWidth(int bottomBorderWidth) {
        this.bottomBorderWidth = bottomBorderWidth;
    }

    /**
     * 获取控件左边框宽度
     *
     * @return 控件左边框宽度
     */
    public int getLeftBorderWidth() {
        return leftBorderWidth;
    }

    /**
     * 设置控件左边框宽度
     *
     * @param leftBorderWidth 控件左边框宽度
     */
    public void setLeftBorderWidth(int leftBorderWidth) {
        this.leftBorderWidth = leftBorderWidth;
    }

    /**
     * 获取控件右边框宽度
     *
     * @return 控件右边框宽度
     */
    public int getRightBorderWidth() {
        return rightBorderWidth;
    }

    /**
     * 设置控件右边框宽度
     *
     * @param rightBorderWidth 控件右边框宽度
     */
    public void setRightBorderWidth(int rightBorderWidth) {
        this.rightBorderWidth = rightBorderWidth;
    }

    /**
     * 获取字体名称
     *
     * @return 字体名称
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * 设置字体名称
     *
     * @param fontName 字体名称
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    /**
     * 获取字体样式
     *
     * @return 字体样式
     */
    public int getFontStyle() {
        return fontStyle;
    }

    /**
     * 设置字体样式
     *
     * @param fontStyle 字体样式
     */
    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * 获取字体大小
     *
     * @return 字体大小
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * 设置字体大小
     *
     * @param fontSize 字体大小
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * 获取提示内容
     *
     * @return 提示内容
     */
    public String getPromptInfo() {
        return promptInfo;
    }

    /**
     * 设置提示内容
     *
     * @param promptInfo 提示内容
     */
    public void setPromptInfo(String promptInfo) {
        this.promptInfo = promptInfo;
    }

    /**
     * 获取提示内容前景色
     *
     * @return 提示内容前景色
     */
    public Color getPromptForegroundColor() {
        return promptForegroundColor;
    }

    /**
     * 设置提示内容前景色
     *
     * @param promptForegroundColor 提示内容前景色
     */
    public void setPromptForegroundColor(Color promptForegroundColor) {
        this.promptForegroundColor = promptForegroundColor;
    }

    /**
     * 获取文本水平对齐方式
     *
     * @return 文本水平对齐方式
     */
    public int getTextHorizontalAlignment() {
        return textHorizontalAlignment;
    }

    /**
     * 设置文本水平对齐方式
     *
     * @param textHorizontalAlignment 文本水平对齐方式
     */
    public void setTextHorizontalAlignment(int textHorizontalAlignment) {
        this.textHorizontalAlignment = textHorizontalAlignment;
    }

    /**
     * 设置控件属性
     *
     * @param component 控件
     */
    public void setComponentParam(JComponent component) {
        //设置控件背景色
        component.setBackground(backgroundColor);
        //设置控件前景色
        component.setForeground(foregroundColor);
        //设置边框宽度级边框颜色(上面，左侧，下面，右侧，边框颜色)
        setBorder(component);
        if (width != 0) {
            //设置控件大小
            Dimension dimension = new Dimension(width, height);
            component.setPreferredSize(dimension);
        }
        //设置字体
        component.setFont(new Font(fontName, fontStyle, fontSize));
        //设置浮现文本
        component.setToolTipText(toolTipText);
        //
        if (isMouseEnteredChangeFlag()) {
            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cursor = component.getCursor();
                    component.setCursor(new Cursor(getMouseEnteredChangeType()));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    component.setCursor(cursor);
                }
            });
        }
    }

    /**
     * 设置边框
     *
     * @param component 控件
     */
    public void setBorder(JComponent component) {
        //设置边框宽度级边框颜色(上面，左侧，下面，右侧，边框颜色)
        Border border = new MatteBorder(getTopBorderWidth(), getLeftBorderWidth(), getBottomBorderWidth(), getRightBorderWidth(), getBorderColor());
        if (StringUtils.isEmpty(getTitle())) {
            component.setBorder(border);
        } else {
            component.setBorder(BorderFactory.createTitledBorder(border, getTitle()));
        }
        component.updateUI();
    }

    /**
     * 设置图标
     *
     * @param abstractButton 抽象按钮对象
     * @throws BaseException 自定义异常
     */
    public void setImageIcon(AbstractButton abstractButton) throws BaseException {
        if (StringUtils.isNotEmpty(getIconFilePath())) {
            ImageIcon imageIcon = null;
            if (getIconHeight() == 0 || getIconWidth() == 0) {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath());
            } else {
                imageIcon = ImageIconUtil.getScaledImageIcon(getIconFilePath(), getIconWidth(), getIconHeight());
            }
            abstractButton.setIcon(imageIcon);
        } else {
            abstractButton.setIcon(null);
        }
    }

    /**
     * 获取鼠标进入控件是否改变形状的标识
     *
     * @return 鼠标进入控件是否改变形状的标识
     */
    public boolean isMouseEnteredChangeFlag() {
        return mouseEnteredChangeFlag;
    }

    /**
     * 设置鼠标进入控件是否改变形状的标识
     *
     * @param mouseEnteredChangeFlag 鼠标进入控件是否改变形状的标识
     */
    public void setMouseEnteredChangeFlag(boolean mouseEnteredChangeFlag) {
        this.mouseEnteredChangeFlag = mouseEnteredChangeFlag;
    }

    /**
     * 获取鼠标进入控件改变的形状
     *
     * @return 鼠标进入控件改变的形状
     */
    public int getMouseEnteredChangeType() {
        return mouseEnteredChangeType;
    }

    /**
     * 设置鼠标进入控件改变的形状
     *
     * @param mouseEnteredChangeType 鼠标进入控件改变的形状
     */
    public void setMouseEnteredChangeType(int mouseEnteredChangeType) {
        this.mouseEnteredChangeType = mouseEnteredChangeType;
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
    }

    /**
     * 初始化菜单
     *
     * @param component     菜单控件
     * @param menuList      菜单集合
     * @param popupMenuFlag 是否右键菜单标识
     * @throws BaseException 自定义异常
     */
    protected void initTkfMenu(JComponent component, List<MenuVO> menuList, boolean popupMenuFlag) throws BaseException {
        if (CollectionUtils.isNotEmpty(menuList)) {
            for (int menuIndex = 0, menuLength = menuList.size(); menuIndex < menuLength; menuIndex++) {
                MenuVO menuVO = menuList.get(menuIndex);
                //菜单集合
                List<MenuVO> tempMenuList = menuVO.getMenuList();
                //菜单项集合
                List<MenuItemVO> menuItemList = menuVO.getMenuItemList();
                //菜单属性
                TiankafeiMenuAttributeVO tiankafeiMenuAttributeVO = menuVO.getTiankafeiMenuAttributeVO();

                //初始化菜单
                TiankafeiMenu tempTiankafeiMenu = new TiankafeiMenu();
                tempTiankafeiMenu.setText(tiankafeiMenuAttributeVO.getText());
                tempTiankafeiMenu.setToolTipText(tiankafeiMenuAttributeVO.getToolTipText());
                tempTiankafeiMenu.setIconFilePath(tiankafeiMenuAttributeVO.getIconFilePath());
                tempTiankafeiMenu.setIconHeight(tiankafeiMenuAttributeVO.getIconHeight());
                tempTiankafeiMenu.setIconWidth(tiankafeiMenuAttributeVO.getIconWidth());
                tempTiankafeiMenu.setMenuList(tempMenuList);
                tempTiankafeiMenu.setMenuItemList(menuItemList);
                tempTiankafeiMenu.setPopupMenuFlag(popupMenuFlag);
                TkfMenu tkfMenu = tempTiankafeiMenu.initTiankafeiMenu();
                component.add(tkfMenu);
                addSeparator(component, menuVO.getTiankafeiMenuAttributeVO().isSeparatorFlag());
            }
        }
    }

    /**
     * 初始化菜单项
     *
     * @param component     菜单项
     * @param menuItemList  菜单项集合
     * @param popupMenuFlag 是否右键菜单标识
     * @throws BaseException 自定义异常
     */
    protected void initTkfMenuItem(JComponent component, List<MenuItemVO> menuItemList, boolean popupMenuFlag) throws BaseException {
        if (CollectionUtils.isNotEmpty(menuItemList)) {
            //初始化下级菜单
            for (int menuIndex = 0, menuLength = menuItemList.size(); menuIndex < menuLength; menuIndex++) {
                MenuItemVO menuItemVO = menuItemList.get(menuIndex);
                AbstractTiankafeiAction tiankafeiAction = menuItemVO.getTiankafeiAction();
                if (tiankafeiAction == null) {
                    throw new BaseException("该菜单项没有绑定事件！");
                }
                TkfMenuItem tkfMenuItem = null;
                if (popupMenuFlag) {
                    tkfMenuItem = tiankafeiAction.initTiankafeiPopupMenuItem();
                } else {
                    tkfMenuItem = tiankafeiAction.initTiankafeiMenuItem();
                }
                //设置文本
                if (StringUtils.isEmpty(tiankafeiAction.getDisplayText())) {
                    tkfMenuItem.setText(tiankafeiAction.getToolTipText());
                } else {
                    tkfMenuItem.setText(tiankafeiAction.getDisplayText());
                }
                tkfMenuItem.getTiankafeiModelUiVO().setParamCode(menuItemVO.getIdentifies());
                component.add(tkfMenuItem);
                addSeparator(component, menuItemVO.getTiankafeiMenuAttributeVO().isSeparatorFlag());
            }
        }
    }

    /**
     * 菜单项增加分隔符
     *
     * @param component     控件
     * @param separatorFlag 是否增加分隔符标识
     */
    private void addSeparator(JComponent component, boolean separatorFlag) {
        if (separatorFlag) {
            if (component instanceof TkfMenu) {
                ((TkfMenu) component).addSeparator();
            } else if (component instanceof TkfPopupMenu) {
                ((TkfPopupMenu) component).addSeparator();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
