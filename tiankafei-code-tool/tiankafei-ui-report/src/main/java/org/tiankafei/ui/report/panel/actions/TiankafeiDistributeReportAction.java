package org.tiankafei.ui.report.panel.actions;

import com.fr.base.Constants;
import com.fr.report.CellElement;
import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;
import org.tiankafei.ui.report.panel.utils.TiankafeiReportUtil;

/**
 * 分散对齐报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiDistributeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8793699084746657776L;

    public TiankafeiDistributeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.DISTRIBUTE.getCode();
        setDisplayText(ActionIdentificationEnum.DISTRIBUTE.getName());
        setIconFilePath("report/defaultAlignment.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        List<CellElement> cellElementList = TiankafeiReportUtil.getSelectedCellElementList(tiankafeiExcelPanel);
        for (int index = 0, length = cellElementList.size(); index < length; index++) {
            cellElementList.get(index).getStyle().setHorizontalAlignment(Constants.DISTRIBUTED);
        }
    }
}
