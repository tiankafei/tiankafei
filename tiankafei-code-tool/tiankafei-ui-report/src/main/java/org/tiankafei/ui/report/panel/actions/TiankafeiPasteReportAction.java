package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 粘贴报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiPasteReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8051942023636267631L;

    public TiankafeiPasteReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.PASTE.getCode();
        setDisplayText(ActionIdentificationEnum.PASTE.getName());
        setIconFilePath("report/paste.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        if (tiankafeiExcelPanel.paste()) {
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK)};
    }
}
