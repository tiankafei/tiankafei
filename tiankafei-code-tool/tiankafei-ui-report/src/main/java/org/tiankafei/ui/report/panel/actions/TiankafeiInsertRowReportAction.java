package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象插入行事件
 *
 * @author 甜咖啡
 */
public class TiankafeiInsertRowReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -3608670314018148006L;

    public TiankafeiInsertRowReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.INSERT_ROW.getCode();
        setDisplayText(ActionIdentificationEnum.INSERT_ROW.getName());
        setIconFilePath("report/insertRow.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int rowIndex = tiankafeiExcelPanel.getFocusRow();
        tiankafeiExcelPanel.getReport().insertRow(rowIndex);
    }
}
