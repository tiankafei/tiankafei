package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 打开报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiOpenReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 4911624528056513285L;

    public TiankafeiOpenReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.OPEN_REPORT.getCode();
        setDisplayText(ActionIdentificationEnum.OPEN_REPORT.getName());
        setIconFilePath("report/open.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK)};
    }
}
