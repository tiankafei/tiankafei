package org.tiankafei.ui.report.test;

import javax.swing.JFrame;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.report.panel.TiankafeiReportPanel;

/**
 * @author 甜咖啡
 */
public class TestReportFrame extends JFrame {

    private static final long serialVersionUID = 2126521351475438127L;

    public static void main(String[] args) {
        TiankafeiFrame tiankafeiFrame = new TiankafeiFrame();
        tiankafeiFrame.setWidth(900);
        tiankafeiFrame.setHeight(700);
        tiankafeiFrame.setTitle("系统");
        tiankafeiFrame.initTiankafeiFrame();

        TiankafeiReportPanel tiankafeiReportPanel = new TiankafeiReportPanel();
        tiankafeiReportPanel.initComponent();
        tiankafeiFrame.getContentTkfPanel().add(tiankafeiReportPanel);
        tiankafeiFrame.setMenuBar(tiankafeiReportPanel.getTiankafeiReportActionsManager().initTkfMenuBar());

        tiankafeiFrame.setVisible(true);
    }

}
