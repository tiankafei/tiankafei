package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 合并单元格报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiMergeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = 774718404168049887L;

    public TiankafeiMergeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.MERGE.getCode();
        setDisplayText(ActionIdentificationEnum.MERGE.getName());
        setIconFilePath("report/merge.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "确定要合并单元格吗？", "合并单元格", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == option) {
            tiankafeiExcelPanel.mergeCell();
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK)};
    }
}
