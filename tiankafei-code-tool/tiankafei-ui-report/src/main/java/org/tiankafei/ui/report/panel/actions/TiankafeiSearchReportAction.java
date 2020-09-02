package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 搜索报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiSearchReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -374456608148536495L;

    public TiankafeiSearchReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.SEARCH.getCode();
        setDisplayText(ActionIdentificationEnum.SEARCH.getName());
        setIconFilePath("report/search.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
