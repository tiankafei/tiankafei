package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象向后复制新增事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleAfterCopyAddAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 6412932406139826210L;

    /**
     * 构造报表对象向后复制新增事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleAfterCopyAddAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.AFTER_COPY_ADD.getCode();
        setDisplayText(ActionIdentificationEnum.AFTER_COPY_ADD.getName());
    }

}
