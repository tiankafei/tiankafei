package org.tiankafei.ui.report.panel.actions;

import com.fr.cell.CellSelection;
import com.fr.report.Report;
import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象删除列事件
 *
 * @author 甜咖啡
 */
public class TiankafeiDeleteColReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -3762550249522723313L;

    public TiankafeiDeleteColReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.DELETE_COL.getCode();
        setDisplayText(ActionIdentificationEnum.DELETE_COL.getName());
        setIconFilePath("report/deleteColumn.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        CellSelection cellSelection = tiankafeiExcelPanel.getCellSelection();
        Report report = tiankafeiExcelPanel.getReport();

        int startColumnIndex = cellSelection.getColumn();
        int endColumnIndex = startColumnIndex + cellSelection.getColumnSpan();

        int offsetIndex = 0;
        for (int index = startColumnIndex; index < endColumnIndex; index++) {
            report.removeColumn(index - offsetIndex);
            offsetIndex++;
        }
    }
}
