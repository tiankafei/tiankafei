package org.tiankafei.ui.design.againsui.frame;

//import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import org.tiankafei.ui.design.adapter.TiankafeiUiResizeAdapter;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.models.TiankafeiFrameAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfFrame;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.util.TiankafeiComponentUtil;
import org.tiankafei.ui.design.util.TiankafeiDragableUtil;

/**
 * 自定义窗体的面板
 *
 * @author tiankafei1
 */
public class TiankafeiCustonFramePanel {

    /**
     * 窗体内容面板
     */
    private TkfPanel contentTkfPanel;

    /**
     * 自定义窗体
     */
    private TiankafeiFrame tiankafeiFrame;

    /**
     * 窗体
     */
    private TkfFrame tkfFrame;

    /**
     * 自定义窗体属性对象
     */
    private TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO;

    /**
     * 构造自定义窗体的面板
     *
     * @param tiankafeiFrame            自定义窗体
     * @param tkfFrame                  窗体
     * @param tiankafeiFrameAttributeVO 窗体属性对象
     */
    public TiankafeiCustonFramePanel(TiankafeiFrame tiankafeiFrame, TkfFrame tkfFrame, TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO) {
        this.tiankafeiFrame = tiankafeiFrame;
        this.tkfFrame = tkfFrame;
        this.tiankafeiFrameAttributeVO = tiankafeiFrameAttributeVO;
        //初始化自定义窗体的面板
        initTiankafeiCustonFramePanel();
    }

    /**
     * 初始化自定义窗体的面板
     */
    private void initTiankafeiCustonFramePanel() {
        //去掉JFrame的标题栏
        tkfFrame.setUndecorated(true);
        //设置圆角
//        AWTUtilities.setWindowShape(tkfFrame, new RoundRectangle2D.Double(0.0D, 0.0D, tiankafeiFrame.getWidth(), tiankafeiFrame.getHeight(), 15.0D, 15.0D));

        if (tiankafeiFrameAttributeVO.isFrameResizable()) {
            //窗口拉伸方法
            TiankafeiUiResizeAdapter tiankafeiCustomResizeAdapter = new TiankafeiUiResizeAdapter(tkfFrame);
            //设置最小宽度和高度
            tiankafeiCustomResizeAdapter.setMinWidth(tiankafeiFrame.getWidth());
            tiankafeiCustomResizeAdapter.setMinHeight(tiankafeiFrame.getHeight());
            tkfFrame.addMouseMotionListener(tiankafeiCustomResizeAdapter);
        }

        //置于顶层面板
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        tiankafeiPanel.setTopBorderWidth(tiankafeiFrameAttributeVO.getFrameCustonBorderWidth());
        tiankafeiPanel.setBottomBorderWidth(tiankafeiFrameAttributeVO.getFrameCustonBorderWidth());
        tiankafeiPanel.setLeftBorderWidth(tiankafeiFrameAttributeVO.getFrameCustonBorderWidth());
        tiankafeiPanel.setRightBorderWidth(tiankafeiFrameAttributeVO.getFrameCustonBorderWidth());
        tiankafeiPanel.setBorderColor(tiankafeiFrameAttributeVO.getFrameCustonBorderColor());
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfFrame.add(tkfPanel, BorderLayout.CENTER);

        //标题面板
        TiankafeiPanel titleTiankafeiPanel = new TiankafeiPanel();
        titleTiankafeiPanel.setBackgroundColor(tiankafeiFrameAttributeVO.getTitlebackgroundColor());
        TkfPanel titleTkfPanel = titleTiankafeiPanel.initTiankafeiPanel();
        tkfPanel.add(titleTkfPanel, BorderLayout.NORTH);
        //整个面板都可拖拽
        TiankafeiDragableUtil tiankafeiDragableUtil = new TiankafeiDragableUtil(tkfFrame, titleTkfPanel);
        tiankafeiDragableUtil.setDragable();
        //初始化左上角系统图标面板
        initLeftUpperOperatePanel(titleTkfPanel, titleTiankafeiPanel);
        //初始化右上角图标面板
        initRightUpperOperatePanel(titleTkfPanel);
        //设置中心面板到窗体
        TiankafeiPanel contentTiankafeiPanel = new TiankafeiPanel();
        contentTkfPanel = contentTiankafeiPanel.initTiankafeiPanel();
        tkfPanel.add(contentTkfPanel, BorderLayout.CENTER);
    }

    /**
     * 初始化左上角系统图标面板
     *
     * @param titleTkfPanel
     * @param titleTiankafeiPanel
     */
    private void initLeftUpperOperatePanel(TkfPanel titleTkfPanel, TiankafeiPanel titleTiankafeiPanel) {
        TiankafeiPanel systemIconTiankafeiPanel = new TiankafeiPanel();
        TkfPanel systemTkfPanel = systemIconTiankafeiPanel.initTiankafeiPanel();
        systemTkfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        systemTkfPanel.setOpaque(false);
        titleTkfPanel.add(systemTkfPanel, BorderLayout.WEST);
        //左上角系统图标标签
        TiankafeiLabel systemIconTiankafeiLabel = new TiankafeiLabel();
        systemIconTiankafeiLabel.setWidth(tiankafeiFrameAttributeVO.getSystemIconWidth());
        systemIconTiankafeiLabel.setHeight(tiankafeiFrameAttributeVO.getSystemIconHeight());
        systemIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getSystemIconFilePath());
        systemIconTiankafeiLabel.setIconHeight(tiankafeiFrameAttributeVO.getSystemIconHeight());
        systemIconTiankafeiLabel.setIconWidth(tiankafeiFrameAttributeVO.getSystemIconWidth());
        systemIconTiankafeiLabel.setBackgroundColor(titleTiankafeiPanel.getBackgroundColor());
        TkfLabel systemIconTkfLabel = systemIconTiankafeiLabel.initTiankafeiLabel();
        systemTkfPanel.add(systemIconTkfLabel);
        systemIconTkfLabel.addMouseListener(new SystemMouseListener());

        int nullWidth = tiankafeiFrameAttributeVO.getMinIconWidth() + tiankafeiFrameAttributeVO.getMaxIconWidth() + tiankafeiFrameAttributeVO.getExitIconWidth() - tiankafeiFrameAttributeVO.getSystemIconWidth();
        TiankafeiLabel nullTiankafeiLabel = new TiankafeiLabel();
        nullTiankafeiLabel.setWidth(nullWidth);
        nullTiankafeiLabel.setHeight(tiankafeiFrameAttributeVO.getSystemIconHeight());
        TkfLabel nullTkfLabel = nullTiankafeiLabel.initTiankafeiLabel();
        systemTkfPanel.add(nullTkfLabel);

        //系统标题面板
        TiankafeiPanel systemTitleTiankafeiPanel = new TiankafeiPanel();
        systemTitleTiankafeiPanel.setBackgroundColor(titleTiankafeiPanel.getBackgroundColor());
        TkfPanel systemTitlePanel = systemTitleTiankafeiPanel.initTiankafeiPanel();
        systemTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        systemTitlePanel.setOpaque(false);
        titleTkfPanel.add(systemTitlePanel, BorderLayout.CENTER);
        //系统标题标签
        TiankafeiLabel systemTitleTiankafeiLabel = new TiankafeiLabel();
        systemTitleTiankafeiLabel.setText(tiankafeiFrame.getTitle());
        TkfLabel systemTitleTkfLabel = systemTitleTiankafeiLabel.initTiankafeiLabel();
        systemTitlePanel.add(systemTitleTkfLabel);
    }

    /**
     * 初始化右上角图标面板
     *
     * @param titleTkfPanel
     */
    private void initRightUpperOperatePanel(TkfPanel titleTkfPanel) {
        TiankafeiPanel handleTiankafeiPanel = new TiankafeiPanel();
        TkfPanel handleTkfPanel = handleTiankafeiPanel.initTiankafeiPanel();
        handleTkfPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 1));
        handleTkfPanel.setOpaque(false);
        titleTkfPanel.add(handleTkfPanel, BorderLayout.EAST);
        //右上角最小化图标标签
        final TiankafeiLabel minIconTiankafeiLabel = new TiankafeiLabel();
        minIconTiankafeiLabel.setHeight(tiankafeiFrameAttributeVO.getMinIconHeight());
        minIconTiankafeiLabel.setWidth(tiankafeiFrameAttributeVO.getMinIconWidth());
        minIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMinIconFilePath());
        minIconTiankafeiLabel.setIconHeight(tiankafeiFrameAttributeVO.getMinIconHeight());
        minIconTiankafeiLabel.setIconWidth(tiankafeiFrameAttributeVO.getMinIconWidth());
        minIconTiankafeiLabel.setToolTipText("最小化");
        TkfLabel minIconTkfLabel = minIconTiankafeiLabel.initTiankafeiLabel();
        handleTkfPanel.add(minIconTkfLabel);
        minIconTkfLabel.addMouseListener(new MinMouseListener(minIconTiankafeiLabel));
        //右上角最大化图标标签
        final TiankafeiLabel maxIconTiankafeiLabel = new TiankafeiLabel();
        maxIconTiankafeiLabel.setHeight(tiankafeiFrameAttributeVO.getMaxIconHeight());
        maxIconTiankafeiLabel.setWidth(tiankafeiFrameAttributeVO.getMaxIconWidth());
        maxIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMaxIconFilePath());
        maxIconTiankafeiLabel.setIconHeight(tiankafeiFrameAttributeVO.getMaxIconHeight());
        maxIconTiankafeiLabel.setIconWidth(tiankafeiFrameAttributeVO.getMaxIconWidth());
        maxIconTiankafeiLabel.setToolTipText("最大化");
        final TkfLabel maxIconTkfLabel = maxIconTiankafeiLabel.initTiankafeiLabel();
        handleTkfPanel.add(maxIconTkfLabel);
        maxIconTkfLabel.addMouseListener(new MaxMouseListener(maxIconTiankafeiLabel, maxIconTkfLabel));
        //右上角退出图标标签
        TiankafeiLabel exitIconTiankafeiLabel = new TiankafeiLabel();
        exitIconTiankafeiLabel.setHeight(tiankafeiFrameAttributeVO.getExitIconHeight());
        exitIconTiankafeiLabel.setWidth(tiankafeiFrameAttributeVO.getExitIconWidth());
        exitIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getExitIconFilePath());
        exitIconTiankafeiLabel.setIconHeight(tiankafeiFrameAttributeVO.getExitIconHeight());
        exitIconTiankafeiLabel.setIconWidth(tiankafeiFrameAttributeVO.getExitIconWidth());
        exitIconTiankafeiLabel.setToolTipText("关闭");
        TkfLabel exitIconTkfLabel = exitIconTiankafeiLabel.initTiankafeiLabel();
        handleTkfPanel.add(exitIconTkfLabel);
        exitIconTkfLabel.addMouseListener(new ExitMouseListener());
    }

    /**
     * 左上角系统功能
     */
    class SystemMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int number = 2;
            if (e.getClickCount() == number) {
                exit(tkfFrame, tiankafeiFrameAttributeVO);
            }
        }
    }

    /**
     * 最小化窗口
     */
    class MinMouseListener extends MouseAdapter {
        private TiankafeiLabel minIconTiankafeiLabel;

        public MinMouseListener(TiankafeiLabel minIconTiankafeiLabel) {
            this.minIconTiankafeiLabel = minIconTiankafeiLabel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            minIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMinMoveIconFilePath());
            minIconTiankafeiLabel.setImageIcon();
            tkfFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            minIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMinIconFilePath());
            minIconTiankafeiLabel.setImageIcon();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            tiankafeiFrame.setMinimumSize();
        }
    }

    /**
     * 最大化窗口
     */
    class MaxMouseListener extends MouseAdapter {
        private TiankafeiLabel maxIconTiankafeiLabel;
        private TkfLabel maxIconTkfLabel;

        public MaxMouseListener(TiankafeiLabel maxIconTiankafeiLabel, TkfLabel maxIconTkfLabel) {
            this.maxIconTiankafeiLabel = maxIconTiankafeiLabel;
            this.maxIconTkfLabel = maxIconTkfLabel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (tkfFrame.getExtendedState() == TkfFrame.MAXIMIZED_BOTH) {
                maxIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMaxScalingMoveIconFilePath());
                maxIconTkfLabel.setToolTipText("向下还原");
            } else {
                maxIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMaxMoveIconFilePath());
                maxIconTkfLabel.setToolTipText("最大化");
            }
            maxIconTiankafeiLabel.setImageIcon();
            tkfFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (tkfFrame.getExtendedState() == TkfFrame.MAXIMIZED_BOTH) {
                maxIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMaxScalingIconFilePath());
                maxIconTkfLabel.setToolTipText("向下还原");
            } else {
                maxIconTiankafeiLabel.setIconFilePath(tiankafeiFrameAttributeVO.getMaxIconFilePath());
                maxIconTkfLabel.setToolTipText("最大化");
            }
            maxIconTiankafeiLabel.setImageIcon();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (tkfFrame.getExtendedState() != TkfFrame.MAXIMIZED_BOTH) {
                tkfFrame.setExtendedState(TkfFrame.MAXIMIZED_BOTH);

                tiankafeiFrameAttributeVO.setRememberWidth(tiankafeiFrame.getWidth());
                tiankafeiFrameAttributeVO.setRememberHeight(tiankafeiFrame.getHeight());
                int screenWidth = (int) TiankafeiComponentUtil.getScreenWidth();
                int screenHeight = (int) TiankafeiComponentUtil.getScreenHeight();
                /** 设置圆角 */
//                AWTUtilities.setWindowShape(tkfFrame, new RoundRectangle2D.Double(0.0D, 0.0D, screenWidth, screenHeight, 15.0D, 15.0D));
            } else {
                tkfFrame.setExtendedState(TkfFrame.NORMAL);
                /** 设置圆角 */
//                AWTUtilities.setWindowShape(tkfFrame, new RoundRectangle2D.Double(0.0D, 0.0D, tiankafeiFrameAttributeVO.getRememberWidth(), tiankafeiFrameAttributeVO.getRememberHeight(), 15.0D, 15.0D));
            }
        }
    }

    /**
     * 推出关闭窗口
     */
    class ExitMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            tkfFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            exit(tkfFrame, tiankafeiFrameAttributeVO);
        }
    }

    /**
     * 退出
     *
     * @param tkfFrame                  窗体
     * @param tiankafeiFrameAttributeVO 自定义窗体对象
     */
    private void exit(TkfFrame tkfFrame, TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO) {
        if (tiankafeiFrameAttributeVO.isFrameExitFlag()) {
            int num = JOptionPane.showConfirmDialog(tkfFrame, "确认要退出系统吗？", "退出系统", JOptionPane.YES_NO_CANCEL_OPTION);
            if (JOptionPane.YES_OPTION == num) {
                System.exit(0);
            }
        } else {
            tkfFrame.dispose();
        }
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

}
