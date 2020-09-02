package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 规则管理报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiRuleManageReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 1146119790038763053L;

    public TiankafeiRuleManageReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.RULE_MANAGE.getCode();
        setDisplayText(ActionIdentificationEnum.RULE_MANAGE.getName());
        setIconFilePath("report/formula.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
