package org.tiankafei.ui.report.panel.actions;

import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 报表对象刀型直接节点事件类
 *
 * @author 甜咖啡
 */
public class ReportStyleKnifeDirectNodeAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -7527696816724638381L;

    /**
     * 构造对象刀型直接节点事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public ReportStyleKnifeDirectNodeAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.KNIFE_DIRECT_NODE.getCode();
        setDisplayText(ActionIdentificationEnum.KNIFE_DIRECT_NODE.getName());
    }

}
