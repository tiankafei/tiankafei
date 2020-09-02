package org.tiankafei.ui.report.panel.actions;

import com.fr.cell.CellSelection;
import com.fr.report.Report;
import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象删除行事件
 *
 * @author 甜咖啡
 */
public class TiankafeiDeleteRowReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -4837702406188312170L;

    public TiankafeiDeleteRowReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.DELETE_ROW.getCode();
        setDisplayText(ActionIdentificationEnum.DELETE_ROW.getName());
        setIconFilePath("report/deleteRow.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        CellSelection cellSelection = tiankafeiExcelPanel.getCellSelection();
        Report report = tiankafeiExcelPanel.getReport();

        int startRowIndex = cellSelection.getRow();
        int endRowIndex = startRowIndex + cellSelection.getRowSpan();

        int offsetIndex = 0;
        for (int index = startRowIndex; index < endRowIndex; index++) {
            report.removeRow(index - offsetIndex);
            offsetIndex++;
        }
    }
}
