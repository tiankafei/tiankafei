package org.tiankafei.ui.report.panel.utils;

import com.fr.cell.CellSelection;
import com.fr.report.CellElement;
import com.fr.report.Report;
import com.fr.report.WorkSheet;
import com.fr.report.io.TemplateExporter;
import com.fr.report.io.TemplateImporter;
import com.google.common.collect.Lists;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.ui.report.dto.TiankafeiReportDTO;
import org.tiankafei.ui.report.panel.TiankafeiExcelPanel;

/**
 * @author 甜咖啡
 */
public class TiankafeiReportUtil {

    /**
     * 获取选中的单元格集合
     *
     * @param tiankafeiExcelPanel excel面板
     * @return 单元格集合
     */
    public static List<CellElement> getSelectedCellElementList(TiankafeiExcelPanel tiankafeiExcelPanel) {
        CellSelection cellSelection = tiankafeiExcelPanel.getCellSelection();
        int row = cellSelection.getRow();
        int column = cellSelection.getColumn();
        int columnSpan = cellSelection.getColumnSpan();
        int rowSpan = cellSelection.getRowSpan();
        CellElement[] cellElementArray = ((WorkSheet) tiankafeiExcelPanel.getReport()).getCellElements(column, row, columnSpan, rowSpan);

        //单元格集合
        List<CellElement> cellElementList = Lists.newArrayList();
        if (cellElementArray != null && cellElementArray.length != 0) {
            for (int index = 0, length = cellElementArray.length; index < length; index++) {
                cellElementList.add(cellElementArray[index]);
            }
        }
        return cellElementList;
    }

    /**
     * 获取报表对象的二进制数组
     *
     * @param report 报表对象
     * @return 返回byte数组
     */
    public static byte[] getReportByteArray(Report report) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TemplateExporter templateExporter = new TemplateExporter(byteArrayOutputStream);
            templateExporter.exportReport(report);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("报表转换数据失败！");
        }
    }

    /**
     * 获取报表对象
     *
     * @param byteArray byte数组
     * @return 报表对象
     */
    public static TiankafeiReportDTO getTiankafeiReportDTO(byte[] byteArray) {
        try {
            String tiankafeiReportXml = new String(byteArray);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(tiankafeiReportXml.getBytes("UTF-8"));

            TemplateImporter templateImporter = new TemplateImporter(byteArrayInputStream);
            TiankafeiReportDTO tiankafeiReportDTO = (TiankafeiReportDTO) templateImporter.generateReport();

            return tiankafeiReportDTO;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new CommonException("不支持的编码！");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("数据转换失败！");
        }
    }

}
