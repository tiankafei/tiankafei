package org.tiankafei.ui.control;

import java.awt.Color;
import java.awt.GridLayout;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiDialog;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiProgressBar;
import org.tiankafei.ui.design.modelsui.TkfDialog;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfProgressBar;

/**
 * 自定义进度条控件对象
 *
 * @author tiankafei1
 */
public class TiankafeiProgressBarControls {

    /**
     * 自定义对话框对象
     */
    private TkfDialog tkfDialog;

    /**
     * 控件宽度
     */
    private int controlsWidth;

    /**
     * 控件高度
     */
    private int controlsHeight;

    /**
     * 控件标题
     */
    private String controlsTitle;

    /**
     * 进度标识，为true循环式滚动，为false有进度
     */
    private boolean progressFlag;

    /**
     * 进度条背景色
     */
    private Color progressBarBackgroundColor;

    /**
     * 提示信息标签
     */
    private TkfLabel toolTipTextTkfLabel;

    /**
     * 进度条对象
     */
    private TkfProgressBar tkfProgressBar;

    /**
     * 构造自定义进度条控件对象
     */
    public TiankafeiProgressBarControls() {
        controlsWidth = 320;
        controlsHeight = 120;
        progressBarBackgroundColor = Color.RED;
        controlsTitle = "进度条";
        progressFlag = false;
    }

    /**
     * 初始化自定义进度条控件对象
     *
     * @throws BaseException 自定义异常
     */
    public void initTiankafeiProgressBarControls() throws BaseException {
        TiankafeiDialog tiankafeiDialog = new TiankafeiDialog();
        tiankafeiDialog.setWidth(controlsWidth);
        tiankafeiDialog.setHeight(controlsHeight);
        tiankafeiDialog.setTitle(controlsTitle);
        tiankafeiDialog.getTiankafeiFrameAttributeVO().setFrameExitFlag(false);
        tkfDialog = tiankafeiDialog.initTiankafeiDialog();
        tiankafeiDialog.setModal(true);

        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfPanel.setLayout(new GridLayout(3, 1));
        tkfDialog.add(tkfPanel);

        //提示信息标签
        TiankafeiLabel tiankafeiLabel = new TiankafeiLabel();
        toolTipTextTkfLabel = tiankafeiLabel.initTiankafeiLabel();
        tkfPanel.add(toolTipTextTkfLabel);

        //进度条
        TiankafeiProgressBar tiankafeiProgressBar = new TiankafeiProgressBar();
        tiankafeiProgressBar.setBackgroundColor(progressBarBackgroundColor);
        tkfProgressBar = tiankafeiProgressBar.initTiankafeiProgressBar();
        tkfProgressBar.setIndeterminate(progressFlag);
        tkfProgressBar.setMinimum(0);
        tkfProgressBar.setMaximum(100);
        tkfProgressBar.setValue(0);
        tkfProgressBar.setStringPainted(true);
        tkfPanel.add(tkfProgressBar);
    }

    /**
     * 进度条显示
     *
     * @param title   标题
     * @param message 消息
     */
    public void startProgressBar(String title, String message) {
        tkfDialog.setTitle(title);
        toolTipTextTkfLabel.setText(message);
        tkfDialog.setVisible(true);
    }

    /**
     * 设置进度条显示值
     *
     * @param value 显示值
     */
    public void setProgressBarValue(int value) {
        tkfProgressBar.setValue(value);
    }

    /**
     * 设置进度条显示值
     *
     * @param value 显示值
     */
    public void setProgressBarValue(String value) {
        tkfProgressBar.setString(value);
    }

    /**
     * 进度条停止关闭
     */
    public void stopProgressBar() {
        tkfDialog.dispose();
    }

    /**
     * 获取控件宽度
     *
     * @return 控件宽度
     */
    public int getControlsWidth() {
        return controlsWidth;
    }

    /**
     * 设置控件宽度
     *
     * @param controlsWidth 控件宽度
     */
    public void setControlsWidth(int controlsWidth) {
        this.controlsWidth = controlsWidth;
    }

    /**
     * 获取控件高度
     *
     * @return 控件高度
     */
    public int getControlsHeight() {
        return controlsHeight;
    }

    /**
     * 设置控件高度
     *
     * @param controlsHeight 控件高度
     */
    public void setControlsHeight(int controlsHeight) {
        this.controlsHeight = controlsHeight;
    }

    /**
     * 获取控件标题
     *
     * @return 控件标题
     */
    public String getControlsTitle() {
        return controlsTitle;
    }

    /**
     * 设置控件标题
     *
     * @param controlsTitle 控件标题
     */
    public void setControlsTitle(String controlsTitle) {
        this.controlsTitle = controlsTitle;
    }

    /**
     * 获取进度标识，为true循环式滚动，为false有进度
     *
     * @return 进度标识，为true循环式滚动，为false有进度
     */
    public boolean isProgressFlag() {
        return progressFlag;
    }

    /**
     * 设置进度标识，为true循环式滚动，为false有进度
     *
     * @param progressFlag 进度标识，为true循环式滚动，为false有进度
     */
    public void setProgressFlag(boolean progressFlag) {
        this.progressFlag = progressFlag;
    }

    /**
     * 获取进度条背景色
     *
     * @return 进度条背景色
     */
    public Color getProgressBarBackgroundColor() {
        return progressBarBackgroundColor;
    }

    /**
     * 设置进度条背景色
     *
     * @param progressBarBackgroundColor 进度条背景色
     */
    public void setProgressBarBackgroundColor(Color progressBarBackgroundColor) {
        this.progressBarBackgroundColor = progressBarBackgroundColor;
    }

}
