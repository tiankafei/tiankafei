package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象插入列事件
 *
 * @author 甜咖啡
 */
public class TiankafeiInsertColReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 1730919621493925862L;

    public TiankafeiInsertColReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.INSERT_COL.getCode();
        setDisplayText(ActionIdentificationEnum.INSERT_COL.getName());
        setIconFilePath("report/insertColumn.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int colIndex = tiankafeiExcelPanel.getFocusColumn();
        tiankafeiExcelPanel.getReport().insertColumn(colIndex);
    }
}
