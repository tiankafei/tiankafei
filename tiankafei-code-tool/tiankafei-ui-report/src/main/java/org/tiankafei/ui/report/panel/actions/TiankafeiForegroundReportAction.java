package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 前景色报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiForegroundReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 7862391921167522401L;

    public TiankafeiForegroundReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.FOREGROUND.getCode();
        setDisplayText(ActionIdentificationEnum.FOREGROUND.getName());
        setIconFilePath("report/foreground.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        super.executePerformed(e);
    }
}
