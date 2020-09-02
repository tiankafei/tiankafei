package org.tiankafei.ui.report.test;

import javax.swing.JFrame;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * @author 甜咖啡
 */
public class TestExcelFrame extends JFrame {

    private static final long serialVersionUID = -6340752508432030946L;

    public static void main(String[] args) {
        try {
            TiankafeiFrame tiankafeiFrame = new TiankafeiFrame();
            tiankafeiFrame.setWidth(900);
            tiankafeiFrame.setHeight(700);
            tiankafeiFrame.setTitle("系统");
            tiankafeiFrame.initTiankafeiFrame();

            TiankafeiExcelPanel tiankafeiExcelPanel = new TiankafeiExcelPanel();
            tiankafeiFrame.getContentTkfPanel().add(tiankafeiExcelPanel);

            tiankafeiFrame.setVisible(true);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

}
