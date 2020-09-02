package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiAction;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * @author 甜咖啡
 */
public abstract class AbstractTiankafeiReportAction extends AbstractTiankafeiAction {

    private static final long serialVersionUID = 3911683721768005779L;

    /**
     * excel面板对象
     */
    protected TiankafeiExcelPanel tiankafeiExcelPanel;

    /**
     * 标识
     */
    protected String identification = "";

    /**
     * 构造报表对象事件类
     *
     * @param tiankafeiExcelPanel excel面板对象
     */
    public AbstractTiankafeiReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        this.tiankafeiExcelPanel = tiankafeiExcelPanel;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiankafeiExcelPanel.startUndo();
        this.executePerformed(e);
        tiankafeiExcelPanel.stopUndo();
        tiankafeiExcelPanel.fireReportDataChanged();
    }

    /**
     * 执行事件处理
     *
     * @param e 事件对象
     */
    protected void executePerformed(ActionEvent e) {

    }

    /**
     * 获取标识
     *
     * @return 标识
     */
    public String getIdentification() {
        return identification;
    }

}
