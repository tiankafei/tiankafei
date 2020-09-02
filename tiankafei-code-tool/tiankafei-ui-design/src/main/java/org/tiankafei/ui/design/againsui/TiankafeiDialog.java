package org.tiankafei.ui.design.againsui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.FileUtil;
import org.tiankafei.ui.design.models.MenuVO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiFrameAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfDialog;
import org.tiankafei.ui.design.modelsui.TkfFrame;
import org.tiankafei.ui.design.modelsui.TkfMenuBar;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.util.TiankafeiComponentUtil;

/**
 * 自定义对话框对象
 *
 * @author tiankafei1
 */
public class TiankafeiDialog extends TiankafeiDesignerVO {

    /**
     * 自定义对话框对象
     */
    private TkfDialog tkfDialog;

    /**
     * 对话框内容面板
     */
    private TkfPanel contentTkfPanel;

    /**
     * 自定义对话框属性对象
     */
    private TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO;

    /**
     * 构造自定义对话框对象
     */
    public TiankafeiDialog() {
        tkfDialog = new TkfDialog();
        tiankafeiFrameAttributeVO = new TiankafeiFrameAttributeVO();
    }

    /**
     * 初始化自定义对话框对象
     *
     * @return 自定义对话框对象
     * @throws BaseException 自定义异常
     */
    public TkfDialog initTiankafeiDialog() throws BaseException {
        tkfDialog.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置主题
        TiankafeiComponentUtil.setTheme(tiankafeiFrameAttributeVO.getFrameTheme());
        //设置对话框事件
        setFrameEvent();
        //设置系统标题
        tkfDialog.setTitle(getTitle());
        //设置窗口大小
        tkfDialog.setSize(getWidth(), getHeight());
        //设置窗口最小大小
        tkfDialog.setMinimumSize(new Dimension(getWidth(), getHeight()));
        //窗口居中显示
        TiankafeiComponentUtil.setCenter(tkfDialog);
        //设置对话框背景色
        tkfDialog.setBackground(getBackgroundColor());
        //设置是否可以拉伸对话框标识
        tkfDialog.setResizable(tiankafeiFrameAttributeVO.isFrameResizable());
        //设置窗口图标
        if (StringUtils.isNotEmpty(getIconFilePath())) {
            tkfDialog.setIconImage(FileUtil.readImage(getIconFilePath()));
        }
        //设置对话框布局
        tkfDialog.setLayout(new BorderLayout());

        if (tiankafeiFrameAttributeVO.isFrameCustomFlag()) {
//			//自定义对话框不能显示菜单栏
			/*TiankafeiCustonFramePanel tiankafeiCustonFramePanel = new TiankafeiCustonFramePanel(this, tkfDialog, tiankafeiFrameAttributeVO);
			contentTkfPanel = tiankafeiCustonFramePanel.getContentTkfPanel();*/
        } else {
            TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
            contentTkfPanel = tiankafeiPanel.initTiankafeiPanel();
            tkfDialog.add(contentTkfPanel, BorderLayout.CENTER);
            //初始化菜单栏
            initMenuList();
        }

        return tkfDialog;
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
        tkfDialog.setJMenuBar(tkfMenuBar);
    }

    /**
     * 设置对话框事件
     */
    protected void setFrameEvent() {
        if (tiankafeiFrameAttributeVO.isFrameCustomFlag()) {

        } else {
            tkfDialog.setDefaultCloseOperation(TkfFrame.DO_NOTHING_ON_CLOSE);
            tkfDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (tiankafeiFrameAttributeVO.isFrameExitFlag()) {
                        int num = JOptionPane.showConfirmDialog(tkfDialog, "确认要退出系统吗？", "退出系统", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (JOptionPane.YES_OPTION == num) {
                            System.exit(0);
                        }
                    } else {
                        tkfDialog.dispose();
                    }
                }
            });
        }
    }

    /**
     * 获取自定义对话框属性对象
     *
     * @return 自定义对话框属性对象
     */
    public TiankafeiFrameAttributeVO getTiankafeiFrameAttributeVO() {
        return tiankafeiFrameAttributeVO;
    }

    /**
     * 设置自定义对话框属性对象
     *
     * @param tiankafeiFrameAttributeVO 自定义对话框属性对象
     */
    public void setTiankafeiFrameAttributeVO(TiankafeiFrameAttributeVO tiankafeiFrameAttributeVO) {
        this.tiankafeiFrameAttributeVO = tiankafeiFrameAttributeVO;
    }

//	/**
//	 * 设置最大化
//	 */
//	public void setMaximumSize(){
//		tkfDialog.setExtendedState(TkfFrame.MAXIMIZED_BOTH);
//	}
//	
//	/**
//	 * 设置最小化
//	 */
//	public void setMinimumSize(){
//		tkfDialog.setExtendedState(TkfFrame.ICONIFIED);
//	}

    /**
     * 设置控件显示标识
     *
     * @param b 显示标识
     */
    public void setVisible(boolean b) {
        tkfDialog.setVisible(b);
    }

    /**
     * 设置是否模态标识
     *
     * @param modal 模态标识
     */
    public void setModal(boolean modal) {
        tkfDialog.setModal(modal);
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
     * 获取对话框内容大面板
     *
     * @return 面板
     */
    public TkfPanel getContentTkfPanel() {
        return contentTkfPanel;
    }

    /**
     * 设置对话框内容大面板
     *
     * @param contentTkfPanel 面板
     */
    public void setContentTkfPanel(TkfPanel contentTkfPanel) {
        this.contentTkfPanel = contentTkfPanel;
    }

}
