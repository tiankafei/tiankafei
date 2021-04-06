package org.tiankafei.ui.report.panel.actions;

import com.fr.report.Report;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import org.tiankafei.ui.report.enums.ActionIdentificationEnum;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;
import org.tiankafei.ui.report.panel.utils.TiankafeiCreateHtmlUtil;
import org.tiankafei.ui.report.panel.utils.TiankafeiReportUtil;

/**
 * 保存报表对象事件
 *
 * @author 甜咖啡
 */
public class TiankafeiSaveReportAction extends AbstractTiankafeiReportAction {

    private static final long serialVersionUID = -9182016962745440644L;

    public TiankafeiSaveReportAction(TiankafeiExcelPanel tiankafeiExcelPanel) {
        super(tiankafeiExcelPanel);
        identification = ActionIdentificationEnum.SAVE_REPORT.getCode();
        setDisplayText(ActionIdentificationEnum.SAVE_REPORT.getName());
        setIconFilePath("report/save.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Report report = tiankafeiExcelPanel.getReport();
        byte[] byteArray = TiankafeiReportUtil.getReportByteArray(report);
        System.out.println(new String(byteArray));
        System.out.println(new TiankafeiCreateHtmlUtil(report).createReportHtml());
    }

    @Override
    public KeyStroke[] getKeyStrokeArray() {
        return new KeyStroke[]{KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK)};
    }
}
