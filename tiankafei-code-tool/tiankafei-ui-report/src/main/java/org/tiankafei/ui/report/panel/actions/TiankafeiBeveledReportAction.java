package org.tiankafei.ui.report.panel.actions;

import com.fr.report.CellElement;
import com.fr.report.core.ReportUtils;
import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;
import org.tiankafei.ui.report.panel.utils.TiankafeiReportUtil;

/**
 * 倾斜文字报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiBeveledReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 5012992319425540163L;

    public TiankafeiBeveledReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BEVELED.getCode();
        setDisplayText(ActionIdentificationEnum.BEVELED.getName());
        setIconFilePath("report/italic.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        List<CellElement> cellElementList = TiankafeiReportUtil.getSelectedCellElementList(tiankafeiExcelPanel);
        for (int index = 0, length = cellElementList.size(); index < length; index++) {
            boolean valueUnder = true;
            CellElement cellElement = cellElementList.get(index);
            if (cellElement.getStyle().getFRFont().isItalic()) {
                valueUnder = false;
            }
            if (valueUnder) {
                ReportUtils.italicReportFont(cellElement.getStyle());
            } else {
                ReportUtils.unItalicReportFont(cellElement.getStyle());
            }
        }
    }
}
