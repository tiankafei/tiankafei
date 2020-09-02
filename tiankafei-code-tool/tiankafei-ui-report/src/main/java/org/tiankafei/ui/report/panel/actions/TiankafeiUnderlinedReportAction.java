package org.tiankafei.ui.report.panel.actions;

import com.fr.report.CellElement;
import com.fr.report.core.ReportUtils;
import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;
import org.tiankafei.ui.report.panel.utils.TiankafeiReportUtil;

/**
 * 下划线报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiUnderlinedReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 2936000263595976482L;

    public TiankafeiUnderlinedReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.UNDERLINED.getCode();
        setDisplayText(ActionIdentificationEnum.UNDERLINED.getName());
        setIconFilePath("report/underline.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        List<CellElement> cellElementList = TiankafeiReportUtil.getSelectedCellElementList(tiankafeiExcelPanel);
        for (int index = 0, length = cellElementList.size(); index < length; index++) {
            boolean valueUnder = true;
            CellElement cellElement = cellElementList.get(index);
            int valueUnderLine = cellElement.getStyle().getFRFont().getUnderline();
            if (valueUnderLine != 0) {
                valueUnder = false;
            }
            if (cellElement.getStyle().getFRFont().getUnderline() == valueUnderLine) {
                ReportUtils.setReportFontUnderline(cellElement.getStyle(), valueUnder);
            }
        }
    }
}
