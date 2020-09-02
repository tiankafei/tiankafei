package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象父子级事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleParentAndSubAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -5236485523015038966L;

    /**
     * 构造报表对象父子级事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleParentAndSubAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.PARENT_AND_SUB.getCode();
        setDisplayText(ActionIdentificationEnum.PARENT_AND_SUB.getName());
    }

}
