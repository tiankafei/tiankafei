package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 回退报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiGoBackReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -7671593039915375165L;

    public TiankafeiGoBackReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.GO_BACK.getCode();
        setDisplayText(ActionIdentificationEnum.GO_BACK.getName());
        setIconFilePath("report/undo.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoManager undoManager = tiankafeiExcelPanel.getUndoManager();
        if (undoManager.canUndo()) {
            undoManager.undo();

            tiankafeiExcelPanel.requestFocus();
            tiankafeiExcelPanel.repaint(10L);
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK)};
    }
}
