package com.fr.cell;

import com.fr.cell.core.GridUtils;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * @author 甜咖啡
 */
public class TiankafeiGrid extends Grid {

    private static final long serialVersionUID = 244180467111335820L;

    public TiankafeiGrid() {
        super();
        ActionMap actionMap = getActionMap();

        actionMap.remove("up");
        actionMap.put("up", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                upKeyPressed(false);
            }
        });

        actionMap.remove("up_shift");
        actionMap.put("up_shift", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                upKeyPressed(true);
            }
        });

        actionMap.remove("down");
        actionMap.put("down", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                downKeyPressed(false);
            }
        });

        actionMap.remove("down_shift");
        actionMap.put("down_shift", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                downKeyPressed(true);
            }
        });

        actionMap.remove("left");
        actionMap.put("left", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                leftKeyPressed(false);
            }
        });

        actionMap.remove("left_shift");
        actionMap.put("left_shift", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                leftKeyPressed(true);
            }
        });

        actionMap.remove("right");
        actionMap.put("right", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                rightKeyPressed(false);
            }
        });

        actionMap.remove("right_shift");
        actionMap.put("right_shift", new AbstractAction() {
            private static final long serialVersionUID = -1514655555258913279L;

            @Override
            public void actionPerformed(ActionEvent e) {
                rightKeyPressed(true);
            }
        });
    }

    /**
     * 鼠标往下箭头事件
     *
     * @param paramBoolean 是否shift
     */
    private void downKeyPressed(boolean paramBoolean) {
        ReportPane reportPane = getReportPane();
        CellSelection cellSelection = reportPane.getCellSelection();
        if (cellSelection == null) {
            return;
        }
        if (paramBoolean) {
            if (shiftDown(reportPane, cellSelection)) {
                reportPane.setCellSelection(cellSelection);
                repaint();
            }
        } else {
            GridUtils.doSelectCell(reportPane, cellSelection.getEditColumn(), cellSelection.getEditRow() + cellSelection.getEditRowSpan());
            makeRowVisible(reportPane, cellSelection.getEditRow() + cellSelection.getEditRowSpan() + 1);
            repaint();
        }
        //更新最左侧序号的宽度
        TiankafeiExcelPanel tiankafeiExcelPanel = (TiankafeiExcelPanel) getParent();
        tiankafeiExcelPanel.resizeAndRepaint();
    }

    /**
     * 鼠标向上箭头事件
     *
     * @param paramBoolean 是否shift
     */
    private void upKeyPressed(boolean paramBoolean) {
        ReportPane reportPane = getReportPane();
        CellSelection cellSelection = reportPane.getCellSelection();
        if (cellSelection == null) {
            return;
        }
        if (paramBoolean) {
            if (shiftUp(reportPane, cellSelection)) {
                reportPane.setCellSelection(cellSelection);
                repaint();
            }
        } else if (cellSelection.getEditRow() > 0) {
            GridUtils.doSelectCell(reportPane, cellSelection.getEditColumn(), cellSelection.getEditRow() - 1);
            makeRowVisible(reportPane, cellSelection.getEditRow() - 1);
            repaint();
        }
        //更新最左侧序号的宽度
        TiankafeiExcelPanel tiankafeiExcelPanel = (TiankafeiExcelPanel) getParent();
        tiankafeiExcelPanel.resizeAndRepaint();
    }

    /**
     * 鼠标向左箭头事件
     *
     * @param paramBoolean 是否shift
     */
    private void leftKeyPressed(boolean paramBoolean) {
        ReportPane reportPane = getReportPane();
        CellSelection cellSelection = reportPane.getCellSelection();
        if (cellSelection == null) {
            return;
        }
        if (paramBoolean) {
            if (shiftLeft(reportPane, cellSelection)) {
                getReportPane().setCellSelection(cellSelection);
                repaint();
            }
        } else if (cellSelection.getEditColumn() > 0) {
            GridUtils.doSelectCell(reportPane, cellSelection.getEditColumn() - 1, cellSelection.getEditRow());
            makeColumnVisible(reportPane, cellSelection.getEditColumn() - 1);
            repaint();
        }
    }

    /**
     * 鼠标向右箭头事件
     *
     * @param paramBoolean 是否shift
     */
    private void rightKeyPressed(boolean paramBoolean) {
        ReportPane reportPane = getReportPane();
        CellSelection cellSelection = reportPane.getCellSelection();
        if (cellSelection == null) {
            return;
        }
        if (paramBoolean) {
            if (shiftRight(reportPane, cellSelection)) {
                reportPane.setCellSelection(cellSelection);
                repaint();
            }
        } else {
            GridUtils.doSelectCell(reportPane, cellSelection.getEditColumn() + cellSelection.getEditColumnSpan(), cellSelection.getEditRow());
            makeColumnVisible(reportPane, cellSelection.getColumn() + cellSelection.getColumnSpan() + 1);
            repaint();
        }
    }

}
