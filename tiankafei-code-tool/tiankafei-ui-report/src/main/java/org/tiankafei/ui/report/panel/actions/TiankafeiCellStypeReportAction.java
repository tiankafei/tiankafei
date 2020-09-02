package org.tiankafei.ui.report.panel.actions;

import com.fr.dialog.StyleDialog;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 单元格格式报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiCellStypeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -8268315789839816305L;

    public TiankafeiCellStypeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.CELL_STYPE.getCode();
        setDisplayText(ActionIdentificationEnum.CELL_STYPE.getName());
        setIconFilePath("report/cellstyle.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        StyleDialog styleDialog = StyleDialog.showWindow(SwingUtilities.getWindowAncestor(tiankafeiExcelPanel));
        styleDialog.populate(tiankafeiExcelPanel);
        styleDialog.setVisible(true);

        int returnValue = styleDialog.getReturnValue();
        if (returnValue == 0) {
            styleDialog.update(tiankafeiExcelPanel);
        }
    }
}
