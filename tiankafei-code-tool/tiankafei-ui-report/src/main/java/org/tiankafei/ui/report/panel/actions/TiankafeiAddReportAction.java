package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 新增报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiAddReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -7026364723645562968L;

    public TiankafeiAddReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.ADD_REPORT.getCode();
        setDisplayText(ActionIdentificationEnum.ADD_REPORT.getName());
        setIconFilePath("report/new.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK)};
    }
}
