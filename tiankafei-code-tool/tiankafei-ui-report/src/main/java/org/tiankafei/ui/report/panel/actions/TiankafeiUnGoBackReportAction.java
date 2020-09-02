package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 撤销回退报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiUnGoBackReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 4420604543001324923L;

    public TiankafeiUnGoBackReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.UN_GO_BACK.getCode();
        setDisplayText(ActionIdentificationEnum.UN_GO_BACK.getName());
        setIconFilePath("report/redo.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoManager undoManager = tiankafeiExcelPanel.getUndoManager();
        if (undoManager.canRedo()) {
            undoManager.redo();

            tiankafeiExcelPanel.requestFocus();
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK)};
    }
}
