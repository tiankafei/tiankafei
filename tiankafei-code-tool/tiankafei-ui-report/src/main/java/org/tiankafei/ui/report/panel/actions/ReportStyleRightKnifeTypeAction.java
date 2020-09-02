package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象右侧刀型事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleRightKnifeTypeAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8356549653733015650L;

    /**
     * 构造报表对象右侧刀型事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleRightKnifeTypeAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.RIGHT_KNIFE_TYPE.getCode();
        setDisplayText(ActionIdentificationEnum.RIGHT_KNIFE_TYPE.getName());
    }

}
