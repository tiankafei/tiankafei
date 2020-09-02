package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象左侧刀型事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleLeftKnifeTypeAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 3937582368713066251L;

    /**
     * 构造报表对象左侧刀型事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleLeftKnifeTypeAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.LEFT_KNIFE_TYPE.getCode();
        setDisplayText(ActionIdentificationEnum.LEFT_KNIFE_TYPE.getName());
    }

}
