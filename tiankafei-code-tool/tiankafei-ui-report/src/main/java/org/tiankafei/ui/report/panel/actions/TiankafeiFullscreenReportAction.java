package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 全屏编辑报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiFullscreenReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8977267817413356944L;

    public TiankafeiFullscreenReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.FULL_SCREEN.getCode();
        setDisplayText(ActionIdentificationEnum.FULL_SCREEN.getName());
        setIconFilePath("report/screen.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
