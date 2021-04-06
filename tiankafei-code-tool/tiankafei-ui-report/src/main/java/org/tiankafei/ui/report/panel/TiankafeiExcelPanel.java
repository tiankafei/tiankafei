package org.tiankafei.ui.report.panel;

import com.fr.cell.CellSelection;
import com.fr.cell.ReportPane;
import com.fr.cell.TiankafeiGrid;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import javax.swing.ActionMap;
import javax.swing.JPopupMenu;
import javax.swing.undo.UndoManager;
import org.tiankafei.ui.report.dto.TiankafeiReportDTO;
import org.tiankafei.ui.report.panel.actions.TiankafeiReportActionsManager;

/**
 * excel面板对象
 *
 * @author 甜咖啡
 */
public class TiankafeiExcelPanel extends ReportPane {

    private static final long serialVersionUID = -320123938509649369L;

    /**
     * 报表设计器事件管理对象
     */
    private TiankafeiReportActionsManager tiankafeiReportActionsManager;

    /**
     * 构造excel面板对象
     */
    public TiankafeiExcelPanel() {
        this(new TiankafeiReportDTO());
    }

    /**
     * 构造excel面板对象
     *
     * @param tiankafeiReportDTO excel对象
     */
    public TiankafeiExcelPanel(TiankafeiReportDTO tiankafeiReportDTO) {
        super(new TiankafeiGrid());
        //设置报表对象
        setReport(tiankafeiReportDTO);
        //设置回退步数
        UndoManager undoManager = this.getUndoManager();
        undoManager.setLimit(200);
        //删除默认键盘事件
        ActionMap actionMap = getActionMap();
        actionMap.remove("cut");
        actionMap.remove("copy");
        actionMap.remove("paste");
        actionMap.remove("delete_content");
        actionMap.remove("delete_all");

        getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (e.getValueIsAdjusting()) {
                    TiankafeiExcelPanel.this.resizeAndRepaint();
                }
            }
        });
        tiankafeiReportActionsManager = new TiankafeiReportActionsManager(this);
    }

    /**
     * 获取当前选中格子的行
     *
     * @return 当前选中格子的行
     */
    public int getFocusRow() {
        CellSelection cellSelection = getCellSelection();
        return cellSelection.getEditRow();
    }

    /**
     * 获取当前选中格子的列
     *
     * @return 当前选中格子的列
     */
    public int getFocusColumn() {
        CellSelection cellSelection = getCellSelection();
        return cellSelection.getEditColumn();
    }

    /**
     * 获取报表设计器事件管理对象
     *
     * @return 报表设计器事件管理对象
     */
    public TiankafeiReportActionsManager getTiankafeiReportActionsManager() {
        return tiankafeiReportActionsManager;
    }

    @Override
    public JPopupMenu createPopupMenu(MouseEvent mouseEvent) {
        return tiankafeiReportActionsManager.initTkfPopupMenu();
    }
}
