package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 取消冻结报表事件对象
 *
 * @author 甜咖啡
 */
public class TiankafeiUnFreezeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -6176225901212260411L;

    /**
     * 构造取消报冻结报表事件对象
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public TiankafeiUnFreezeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.UN_FREEZE.getCode();
        setDisplayText(ActionIdentificationEnum.UN_FREEZE.getName());
        setIconFilePath("report/ec_frozen.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        tiankafeiExcelPanel.setFrozenColumn(0);
        tiankafeiExcelPanel.setFrozenRow(0);
    }
}
