package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 拆分单元格报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiUnMergeReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -6372232557443466041L;

    public TiankafeiUnMergeReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.UN_MERGE.getCode();
        setDisplayText(ActionIdentificationEnum.UN_MERGE.getName());
        setIconFilePath("report/unmerge.png");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "确定要取消单元格合并吗？", "取消单元格合并", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == option) {
            tiankafeiExcelPanel.unMergeCell();
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK)};
    }
}
