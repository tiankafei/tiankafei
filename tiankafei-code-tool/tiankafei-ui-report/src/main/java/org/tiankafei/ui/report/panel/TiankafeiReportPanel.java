package org.tiankafei.ui.report.panel;

import java.awt.BorderLayout;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfToolBar;
import org.tiankafei.ui.report.dto.TiankafeiReportDTO;
import org.tiankafei.ui.report.panel.actions.TiankafeiReportActionsManager;

/**
 * 报表设计器面板(带部分设置功能)
 *
 * @author 甜咖啡
 */
public class TiankafeiReportPanel extends TkfPanel {

    private static final long serialVersionUID = -6090803052900673054L;

    /**
     * excel面板对象
     */
    private TiankafeiExcelPanel tiankafeiExcelPanel;

    /**
     * 报表设计器事件管理对象
     */
    private TiankafeiReportActionsManager tiankafeiReportActionsManager;

    /**
     * 构造报表设计器面板
     */
    public TiankafeiReportPanel() {
        this(new TiankafeiReportDTO());
    }

    /**
     * 构造报表设计器面板
     *
     * @param tiankafeiReportDTO 报表对象
     */
    public TiankafeiReportPanel(TiankafeiReportDTO tiankafeiReportDTO) {
        tiankafeiExcelPanel = new TiankafeiExcelPanel(tiankafeiReportDTO);
        //报表设计器事件管理对象
        tiankafeiReportActionsManager = tiankafeiExcelPanel.getTiankafeiReportActionsManager();
    }

    /**
     * 初始化报表面板
     *
     * @throws BaseException 自定义异常
     */
    public void initComponent() throws BaseException {
        this.setLayout(new BorderLayout());
        //加入excel面板
        this.add(tiankafeiExcelPanel, BorderLayout.CENTER);

        //初始化功能面板
        TkfToolBar functionTkfToolBar = tiankafeiReportActionsManager.initTkfToolBar();
        this.add(functionTkfToolBar, BorderLayout.NORTH);
    }

    /**
     * 获取报表设计器事件管理对象
     *
     * @return 报表设计器事件管理对象
     */
    public TiankafeiReportActionsManager getTiankafeiReportActionsManager() {
        return tiankafeiReportActionsManager;
    }
}
