package org.tiankafei.ui.design.againsui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.FileUtil;
import org.tiankafei.ui.design.againsui.frame.TiankafeiCustonFramePanel;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiFrameAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfFrame;
import org.tiankafei.ui.design.modelsui.TkfMenuBar;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.util.TiankafeiComponentUtil;

/**
 * 自定义窗体对象
 *
 * @author tiankafei
 */
public class TiankafeiFrame extends TiankafeiDesignerVO {

    /**
     * 自定义窗体对象
     */
    private TkfFrame tkfFrame;

    /**
     * 窗体内容面板
     */
    private TkfPanel contentTkfPanel;

    /**
     * 自定义窗体属性对象
     */
    private TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO;

    /**
     * 构造自定义窗体对象
     */
    public TiankafeiFrame() {
        tkfFrame = new TkfFrame();
        tiankafeiFrameAttributeVO = new TiankafeiFrameAttributeVO();
    }

    /**
     * 初始化自定义窗体对象
     *
     * @throws BaseException 自定义异常
     */
    public void initTiankafeiFrame() throws BaseException {
        tkfFrame.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置主题
        TiankafeiComponentUtil.setTheme(tiankafeiFrameAttributeVO.getFrameTheme());
        //设置窗体事件
        setFrameEvent();
        //设置系统标题
        tkfFrame.setTitle(getTitle());
        //设置窗口大小
        tkfFrame.setSize(getWidth(), getHeight());
        //设置窗口最小大小
        tkfFrame.setMinimumSize(new Dimension(getWidth(), getHeight()));
        //窗口居中显示
        TiankafeiComponentUtil.setCenter(tkfFrame);
        //设置窗体背景色
        tkfFrame.setBackground(getBackgroundColor());
        //设置是否可以拉伸窗体标识
        tkfFrame.setResizable(tiankafeiFrameAttributeVO.isFrameResizable());
        //设置窗口图标
        if (StringUtils.isNotEmpty(getIconFilePath())) {
            tkfFrame.setIconImage(FileUtil.readImage(getIconFilePath()));
        }
        //设置窗体布局
        tkfFrame.setLayout(new BorderLayout());

        if (tiankafeiFrameAttributeVO.isFrameCustomFlag()) {
            //自定义窗体不能显示菜单栏
            TiankafeiCustonFramePanel tiankafeiCustonFramePanel = new TiankafeiCustonFramePanel(this, tkfFrame, tiankafeiFrameAttributeVO);
            contentTkfPanel = tiankafeiCustonFramePanel.getContentTkfPanel();
        } else {
            //初始化中央大面板
            TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
            contentTkfPanel = tiankafeiPanel.initTiankafeiPanel();
            tkfFrame.add(contentTkfPanel, BorderLayout.CENTER);
            //初始化菜单栏
            initMenuList();
        }
    }

    /**
     * 初始化菜单栏
     *
     * @throws BaseException 自定义异常
     */
    private void initMenuList() throws BaseException {
        List<MenuVO> menuList = tiankafeiFrameAttributeVO.getMenuList();
        TiankafeiMenuBar tiankafeiMenuBar = new TiankafeiMenuBar();
        tiankafeiMenuBar.setMenuList(menuList);
        TkfMenuBar tkfMenuBar = tiankafeiMenuBar.initTiankafeiMenuBar();
        tkfFrame.setJMenuBar(tkfMenuBar);
    }

    /**
     * 设置窗体事件
     */
    protected void setFrameEvent() {
        if (tiankafeiFrameAttributeVO.isFrameCustomFlag()) {

        } else {
            tkfFrame.setDefaultCloseOperation(TkfFrame.DO_NOTHING_ON_CLOSE);
            tkfFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (tiankafeiFrameAttributeVO.isFrameExitFlag()) {
                        int num = JOptionPane.showConfirmDialog(tkfFrame, "确认要退出系统吗？", "退出系统", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (JOptionPane.YES_OPTION == num) {
                            System.exit(0);
                        }
                    } else {
                        tkfFrame.dispose();
                    }
                }
            });
        }
    }

    /**
     * 获取自定义窗体属性对象
     *
     * @return 自定义窗体属性对象
     */
    public TiankafeiFrameAttributeVO getTiankafeiFrameAttributeVO() {
        return tiankafeiFrameAttributeVO;
    }

    /**
     * 设置自定义窗体属性对象
     *
     * @param tiankafeiFrameAttributeVO 自定义窗体属性对象
     */
    public void setTiankafeiFrameAttributeVO(TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO) {
        this.tiankafeiFrameAttributeVO = tiankafeiFrameAttributeVO;
    }

    /**
     * 设置最大化
     */
    public void setMaximumSize() {
        tkfFrame.setExtendedState(TkfFrame.MAXIMIZED_BOTH);
    }

    /**
     * 设置最小化
     */
    public void setMinimumSize() {
        tkfFrame.setExtendedState(TkfFrame.ICONIFIED);
    }

    /**
     * 设置控件显示标识
     *
     * @param b 显示标识
     */
    public void setVisible(boolean b) {
        tkfFrame.setVisible(b);
    }

    /**
     * 获取窗体大小
     *
     * @return 窗体大小
     */
    public Dimension getSize() {
        return tkfFrame.getSize();
    }

    /**
     * 获取窗口位置
     *
     * @return 窗口位置
     */
    public Point getLocation() {
        return tkfFrame.getLocation();
    }

    /**
     * 获取窗口的属性
     *
     * @return 窗口的属性
     */
    public Insets getInsets() {
        return tkfFrame.getInsets();
    }

    /**
     * 新增控件到主面板
     *
     * @param comp 控件
     */
    public void add(Component comp) {
        contentTkfPanel.add(comp, BorderLayout.CENTER);
    }

    /**
     * 新增控件到主面板
     *
     * @param comp        控件
     * @param constraints 位置
     */
    public void add(Component comp, Object constraints) {
        contentTkfPanel.add(comp, constraints);
    }

    /**
     * 获取窗体内容大面板
     *
     * @return 面板
     */
    public TkfPanel getContentTkfPanel() {
        return contentTkfPanel;
    }

    /**
     * 设置窗体内容大面板
     *
     * @param contentTkfPanel 面板
     */
    public void setContentTkfPanel(TkfPanel contentTkfPanel) {
        this.contentTkfPanel = contentTkfPanel;
    }

    /**
     * 添加windows事件
     *
     * @param windowAdapter windows事件
     */
    public void addWindowListener(WindowAdapter windowAdapter) {
        tkfFrame.addWindowListener(windowAdapter);
    }

    /**
     * 添加windows事件
     *
     * @param windowListener windows事件
     */
    public void addWindowListener(WindowListener windowListener) {
        tkfFrame.addWindowListener(windowListener);
    }

    /**
     * 添加事件
     *
     * @param componentAdapter 事件
     */
    public void addComponentListener(ComponentAdapter componentAdapter) {
        tkfFrame.addComponentListener(componentAdapter);
    }

    /**
     * 添加事件
     *
     * @param componentListener 事件
     */
    public void addComponentListener(ComponentListener componentListener) {
        tkfFrame.addComponentListener(componentListener);
    }

    /**
     * 获取层次面板
     *
     * @return 层次面板
     */
    public JLayeredPane getLayeredPane() {
        return tkfFrame.getLayeredPane();
    }

    /**
     * 设置菜单栏
     *
     * @param menubar 菜单栏
     */
    public void setMenuBar(JMenuBar menubar) {
        tkfFrame.setJMenuBar(menubar);
    }

}
