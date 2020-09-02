package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 另存报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiSaveAsReportAction extends TiankafeiSaveReportAction {

    private static final long serialVersionUID = 8161708874083433958L;

    public TiankafeiSaveAsReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.SAVEAS_REPORT.getCode();
        setDisplayText(ActionIdentificationEnum.SAVEAS_REPORT.getName());
        setIconFilePath("report/saveAs.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

}
