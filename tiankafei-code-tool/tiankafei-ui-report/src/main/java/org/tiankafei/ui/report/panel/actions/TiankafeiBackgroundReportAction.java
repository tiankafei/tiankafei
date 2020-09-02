package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 背景色报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiBackgroundReportAction extends AbstractTiankafeiReportAction {
    private static final long serialVersionUID = -2546516698336977034L;

    public TiankafeiBackgroundReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BACKGROUND.getCode();
        setDisplayText(ActionIdentificationEnum.BACKGROUND.getName());
        setIconFilePath("report/background.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        super.executePerformed(e);
    }

}
