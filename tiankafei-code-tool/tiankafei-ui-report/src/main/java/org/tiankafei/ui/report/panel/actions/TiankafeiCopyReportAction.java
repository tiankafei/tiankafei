package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 复制报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiCopyReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 8857297039465368855L;

    public TiankafeiCopyReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.COPY.getCode();
        setDisplayText(ActionIdentificationEnum.COPY.getName());
        setIconFilePath("report/copy.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        tiankafeiExcelPanel.copy();
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK)};
    }
}
