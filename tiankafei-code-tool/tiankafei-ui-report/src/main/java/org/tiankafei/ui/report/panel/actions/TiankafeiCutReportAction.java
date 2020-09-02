package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 剪切报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiCutReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 2639895327018592280L;

    public TiankafeiCutReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.CUT.getCode();
        setDisplayText(ActionIdentificationEnum.CUT.getName());
        setIconFilePath("report/cut.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        tiankafeiExcelPanel.cut();
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK)};
    }
}
