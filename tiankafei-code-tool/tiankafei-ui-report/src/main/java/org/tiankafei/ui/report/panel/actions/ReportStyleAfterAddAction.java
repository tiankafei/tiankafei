package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象向后新增事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleAfterAddAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -2677622790626361258L;

    /**
     * 构造报表对象向后新增事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleAfterAddAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.AFTER_ADD.getCode();
        setDisplayText(ActionIdentificationEnum.AFTER_ADD.getName());
    }

}
