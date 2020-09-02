package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象向前新增事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleBeforeAddAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -7286110659375702730L;

    /**
     * 构造报表对象向前新增事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleBeforeAddAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BEFORE_ADD.getCode();
        setDisplayText(ActionIdentificationEnum.BEFORE_ADD.getName());
    }

}
