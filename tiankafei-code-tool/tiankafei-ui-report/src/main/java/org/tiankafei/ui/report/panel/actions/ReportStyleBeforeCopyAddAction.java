package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象向前复制新增事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleBeforeCopyAddAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -3844660665266651661L;

    /**
     * 构造报表对象向前复制新增事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleBeforeCopyAddAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.BEFORE_COPY_ADD.getCode();
        setDisplayText(ActionIdentificationEnum.BEFORE_COPY_ADD.getName());
    }

}
