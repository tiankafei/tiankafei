package org.tiankafei.ui.report.panel.actions;

import com.fr.report.CellElement;
import com.fr.report.core.ReportUtils;
import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;
import org.tiankafei.ui.report.panel.utils.TiankafeiReportUtil;

/**
 * 加粗文字报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiBoldReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 6699452505932525063L;

    public TiankafeiBoldReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BOLD.getCode();
        setDisplayText(ActionIdentificationEnum.BOLD.getName());
        setIconFilePath("report/bold.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        List<CellElement> cellElementList = TiankafeiReportUtil.getSelectedCellElementList(tiankafeiExcelPanel);
        for (int index = 0, length = cellElementList.size(); index < length; index++) {
            boolean valueUnder = true;
            CellElement cellElement = cellElementList.get(index);
            if (cellElement.getStyle().getFRFont().isBold()) {
                valueUnder = false;
            }
            if (valueUnder) {
                ReportUtils.boldReportFont(cellElement.getStyle());
            } else {
                ReportUtils.unBoldReportFont(cellElement.getStyle());
            }
        }
    }
}
