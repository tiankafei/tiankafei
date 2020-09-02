package org.tiankafei.ui.report.panel.actions;

import com.fr.dialog.CellBorderDialog;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 边框报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiBorderReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8196300892833086289L;

    public TiankafeiBorderReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BORDER.getCode();
        setDisplayText(ActionIdentificationEnum.BORDER.getName());
        setIconFilePath("report/cellborder.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        CellBorderDialog cellBorderDialog = CellBorderDialog.showWindow(SwingUtilities.getWindowAncestor(tiankafeiExcelPanel));

        cellBorderDialog.populate(tiankafeiExcelPanel);
        cellBorderDialog.setVisible(true);

        int returnValue = cellBorderDialog.getReturnValue();
        if (returnValue == 0) {
            cellBorderDialog.update(tiankafeiExcelPanel);
        }
    }
}
