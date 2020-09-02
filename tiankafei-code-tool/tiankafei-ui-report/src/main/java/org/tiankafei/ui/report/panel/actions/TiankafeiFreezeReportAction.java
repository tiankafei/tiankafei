package org.tiankafei.ui.report.panel.actions;

import com.fr.cell.CellSelection;
import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 冻结报表事件对象
 *
 * @author 甜咖啡
 */
public class TiankafeiFreezeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 5173044490706713435L;

    /**
     * 构造报冻结报表事件对象
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public TiankafeiFreezeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.FREEZE.getCode();
        setDisplayText(ActionIdentificationEnum.FREEZE.getName());
        setIconFilePath("report/frozen.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        CellSelection cellSelection = tiankafeiExcelPanel.getCellSelection();
        int row = cellSelection.getRow();
        int column = cellSelection.getColumn();
        tiankafeiExcelPanel.setFrozenColumn(column);
        tiankafeiExcelPanel.setFrozenRow(row);
    }
}
