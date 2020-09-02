package org.tiankafei.ui.report.panel.actions;

import com.fr.report.WorkSheet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.dto.TiankafeiReportDTO;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 重置报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiResetReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 6429229041204488954L;

    public TiankafeiResetReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.RESET.getCode();
        setDisplayText(ActionIdentificationEnum.RESET.getName());
        setIconFilePath("report/reset.gif");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "确定要重置报表吗？", "重置", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == option) {
            ((WorkSheet) tiankafeiExcelPanel.getReport()).reset();
            ((TiankafeiReportDTO) tiankafeiExcelPanel.getReport()).clearAllAttribute();
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK)};
    }
}
