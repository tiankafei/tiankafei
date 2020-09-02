package org.tiankafei.ui.design.abstractinterface;

/**
 * 菜单工具栏抽象事件
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiMenuToolBarActoin extends AbstractTiankafeiAction {

    private static final long serialVersionUID = -3833006946008655730L;

    /**
     * 构造抽象菜单事件
     *
     * @param displayText 显示文本
     */
    public AbstractTiankafeiMenuToolBarActoin(String displayText) {
        this(displayText, 0, "/images/new.gif");
    }

    /**
     * 构造抽象菜单事件
     *
     * @param displayText 显示文本
     * @param width       控件宽度
     */
    public AbstractTiankafeiMenuToolBarActoin(String displayText, int width) {
        this(displayText, width, "/images/new.gif");
    }

    /**
     * 构造抽象菜单事件
     *
     * @param displayText  显示文本
     * @param iconFilePath 图标路径
     */
    public AbstractTiankafeiMenuToolBarActoin(String displayText, String iconFilePath) {
        this(displayText, 0, iconFilePath);
    }

    /**
     * 构造抽象菜单事件
     *
     * @param displayText  显示文本
     * @param width        控件宽度
     * @param iconFilePath 图标路径
     */
    public AbstractTiankafeiMenuToolBarActoin(String displayText, int width, String iconFilePath) {
        setDisplayText(displayText);
        setWidth(width);
        setEnabled(true);
        setIconFilePath(iconFilePath);
    }

}
