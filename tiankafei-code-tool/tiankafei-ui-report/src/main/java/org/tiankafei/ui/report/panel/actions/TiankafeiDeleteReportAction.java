package org.tiankafei.ui.report.panel.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * 删除报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiDeleteReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -1756710188355301068L;

    public TiankafeiDeleteReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.DELETE.getCode();
        setDisplayText(ActionIdentificationEnum.DELETE.getName());
        setIconFilePath("report/delete.gif");
    }

    @Override
    public void executePerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "确定要删除当前选中的单元格吗？", "删除", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == option) {
            tiankafeiExcelPanel.clearAll();
            //删内容
            //tiankafeiExcelPanel.clearContents();

            //删样式
            //tiankafeiExcelPanel.clearFormats();

            //删格子
            //tiankafeiExcelPanel.clearAll();
        }
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK)};
    }
}
