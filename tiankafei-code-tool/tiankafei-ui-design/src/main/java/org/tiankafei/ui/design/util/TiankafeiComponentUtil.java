package org.tiankafei.ui.design.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.modelsui.TkfMenu;
import org.tiankafei.ui.design.modelsui.TkfMenuItem;

/**
 * 自定义窗口工具类
 *
 * @author tiankafei
 */
public class TiankafeiComponentUtil {

    private TiankafeiComponentUtil() {

    }

    /**
     * 设置窗口居中显示
     *
     * @param component 控件
     */
    public static void setCenter(Component component) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = dimension.getWidth();
        double height = dimension.getHeight();
        component.setLocation((int) (width - component.getWidth()) / 2, (int) (height - component.getHeight()) / 2);
    }

    /**
     * 获取屏幕宽度
     *
     * @return 返回屏幕宽度
     */
    public static double getScreenWidth() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return dimension.getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return 返回屏幕高度
     */
    public static double getScreenHeight() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return dimension.getHeight();
    }

    /**
     * 获取任务栏高度
     *
     * @param component 控件
     * @return 返回任务栏高度
     */
    public static int getScreenTaskbarHeight(Component component) {
        //获取屏幕的边界
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(component.getGraphicsConfiguration());
        //获取底部任务栏高度
        int taskBarHeight = screenInsets.bottom;
        return taskBarHeight;
    }

    /**
     * 设置主题
     *
     * @param frameTheme 主题类型
     */
    public static void setTheme(int frameTheme) {
        try {
            //默认主题
            String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";

            if (TiankafeiDesignerConstants.SWING_THEME_WINDOWS == frameTheme) {
                //windows常规模式的主题
                lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                //windows经典模式的主题
//				lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
            } else if (TiankafeiDesignerConstants.SWING_THEME_MAC == frameTheme) {
                //Mac风格 (需要在相关的操作系统上方可实现)
                lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
            }
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取子菜单项集合
     *
     * @param tkfMenuItemList 右键菜单的所有菜单项集合
     * @param jComponent      控件
     */
    public static void getChildTkfMenuItemList(List<TkfMenuItem> tkfMenuItemList, JComponent jComponent) {
        Component[] components = jComponent.getComponents();
        for (int i = 0, lem = components.length; i < lem; i++) {
            Component component = components[i];
            if (component instanceof TkfMenu) {
                TkfMenu tkfMenu = (TkfMenu) component;
                getChildTkfMenuItemList(tkfMenuItemList, tkfMenu);
            } else if (component instanceof TkfMenuItem) {
                TkfMenuItem tkfMenuItem = (TkfMenuItem) component;
                tkfMenuItemList.add(tkfMenuItem);
            }
        }
    }

}
