package org.tiankafei.ui.report.panel.utils;

import com.fr.base.Style;
import com.fr.base.background.Background;
import com.fr.base.background.ColorBackground;
import com.fr.report.CellElement;
import com.fr.report.Report;
import com.fr.report.io.core.IOHelper;
import com.fr.report.io.xml.SynchronizedStyleList;
import com.fr.util.Utils;
import com.google.common.collect.Lists;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.ui.report.panel.utils.htmldrawer.AbstractTiankafeiDrawer;
import org.tiankafei.ui.report.panel.utils.htmldrawer.TiankafeiNoteFactory;

/**
 * 报表设计器创建html工具类
 *
 * @author 甜咖啡
 */
public class TiankafeiCreateHtmlUtil {

    /**
     * 报表对象
     */
    private Report report;

    /**
     * 同步样式集合
     */
    private SynchronizedStyleList synchronizedStyleList;

    /**
     * 报表总宽度
     */
    private double contentWidth;

    /**
     * 报表总高度
     */
    private double contentHeight;

    /**
     * 列宽集合
     */
    private List<Double> columnWidthList;

    /**
     * 行高集合
     */
    private List<Double> rowHeightList;

    /**
     * 构造报表设计器创建html工具类
     *
     * @param report 报表对象
     */
    public TiankafeiCreateHtmlUtil(Report report) {
        this.report = report;
        //列集合
        int columnLength = report.getLastColumn() + 1;
        BigDecimal columnWidthBigDecimal = new BigDecimal("0.0");
        columnWidthList = Lists.newArrayListWithCapacity(columnLength + 1);
        for (int i = 0; i < columnLength; i++) {
            double columnWidth = report.getColumnWidth(i);
            columnWidthList.add(columnWidth);
            columnWidthBigDecimal = columnWidthBigDecimal.add(new BigDecimal(Double.toString(columnWidth)));
        }
        if (columnWidthBigDecimal.doubleValue() <= 0.0) {
            contentWidth = 1.0D;
        } else {
            contentWidth = columnWidthBigDecimal.doubleValue();
        }

        //行集合
        int rowLength = report.getLastRow() + 1;
        BigDecimal rowHeightBigDecimal = new BigDecimal("0.0");
        rowHeightList = Lists.newArrayListWithCapacity(rowLength + 1);
        for (int i = 0; i < rowLength; i++) {
            double rowHeight = report.getRowHeight(i);
            rowHeightList.add(rowHeight);
            rowHeightBigDecimal = rowHeightBigDecimal.add(new BigDecimal(Double.toString(rowHeight)));
        }
        if (rowHeightBigDecimal.doubleValue() <= 0.0) {
            contentHeight = 1.0D;
        } else {
            contentHeight = rowHeightBigDecimal.doubleValue();
        }

        //同步样式集合
        synchronizedStyleList = SynchronizedStyleList.getSynchronizedCellStyleList(Thread.currentThread());
        Style defaultStyle = new Style();
        defaultStyle.setBorderTop(0);
        defaultStyle.setBorderTopColor(Color.lightGray);
        defaultStyle.setBorderLeft(0);
        defaultStyle.setBorderLeftColor(Color.lightGray);
        defaultStyle.setBorderBottom(0);
        defaultStyle.setBorderBottomColor(Color.lightGray);
        defaultStyle.setBorderRight(0);
        defaultStyle.setBorderRightColor(Color.lightGray);
        synchronizedStyleList.addStyle(defaultStyle);
    }

    /**
     * 创建报表html
     *
     * @return 报表html
     */
    public String createReportHtml() {
        StringBuffer reportBuffer = new StringBuffer();

        //创建表格开始html
        reportBuffer.append(createTableStartHtml());
        //创建表格colgroup的html
        reportBuffer.append(createTableColgroup());

        for (int rowIndex = 0, rowLength = rowHeightList.size(); rowIndex < rowLength; rowIndex++) {
            //创建行开始d的html
            reportBuffer.append(createTrStartHtml(rowIndex));
            for (int colIndex = 0, colLength = columnWidthList.size(); colIndex < colLength; colIndex++) {
                CellElement cellElement = report.getCellElement(colIndex, rowIndex);
                if (cellElement == null) {
                    //创建默认单元格html
                    reportBuffer.append(createDefaultTdHtml(colIndex, rowIndex));
                } else {
                    //创建单元格html
                    reportBuffer.append(createTdHtml(colIndex, rowIndex, cellElement));
                }
            }
            //创建行结束html
            reportBuffer.append(createTrEndHtml());
        }
        //创建表格结束html
        reportBuffer.append(createTableEndHtml());

        //创建报表样式html
        String style = createReportStyleHtml(synchronizedStyleList);
        reportBuffer.append(style);

        SynchronizedStyleList.removeSynchronizedCellStyleList(Thread.currentThread());
        return reportBuffer.toString();
    }

    /**
     * 创建表格开始html
     *
     * @return 表格开始html
     */
    private String createTableStartHtml() {
        StringBuffer tableStartBuffer = new StringBuffer();

        tableStartBuffer.append("<table id=\"grid\" style=\"");
        tableStartBuffer.append("overflow:hidden;table-layout:fixed;border-collapse:collapse;");
        tableStartBuffer.append("width:" + (int) contentWidth + "px;");
        tableStartBuffer.append("height:" + (int) contentHeight + "px;");
        tableStartBuffer.append("\" cellspacing=\"0\" cellpadding=\"0\">");

        return tableStartBuffer.toString();
    }

    /**
     * 创建表格colgroup的html
     *
     * @return 表格colgroup的html
     */
    private String createTableColgroup() {
        StringBuffer colgroupBuffer = new StringBuffer();
        colgroupBuffer.append("<colgroup>");
        for (int colIndex = 0, columnLength = columnWidthList.size(); colIndex < columnLength; colIndex++) {
            colgroupBuffer.append("<col width=\"").append(columnWidthList.get(colIndex)).append("\">");
        }
        colgroupBuffer.append("</colgroup>");
        return colgroupBuffer.toString();
    }

    /**
     * 创建行开始d的html
     *
     * @param rowIndex 行号
     * @return 行开始d的html
     */
    private String createTrStartHtml(int rowIndex) {
        StringBuffer trStartBuffer = new StringBuffer();
        trStartBuffer.append("<tr style=\"height:").append(rowHeightList.get(rowIndex)).append("px;\">");
        return trStartBuffer.toString();
    }

    /**
     * 创建默认单元格html
     *
     * @param colIndex 列号
     * @param rowIndex 行号
     * @return 默认单元格html
     */
    private String createDefaultTdHtml(int colIndex, int rowIndex) {
        StringBuffer defaultTdBuffer = new StringBuffer();
        defaultTdBuffer.append("<td id=\"" + colIndex + "_" + rowIndex + "\" class=\"S_0\"></td>");
        return defaultTdBuffer.toString();
    }

    /**
     * 创建单元格html
     *
     * @param colIndex    列号
     * @param rowIndex    行号
     * @param cellElement 单元格对象
     * @return 单元格html
     */
    private String createTdHtml(int colIndex, int rowIndex, CellElement cellElement) {
        StringBuffer tdBuffer = new StringBuffer();
        int cellColumn = cellElement.getColumn();
        int cellRow = cellElement.getRow();
        if ((colIndex == cellColumn) && (rowIndex == cellRow)) {
            //创建单元格开始html
            tdBuffer.append(createTdStartHtml(colIndex, rowIndex, cellElement));
            //创建单元格内容html
            tdBuffer.append(createTdContent(cellElement));
            //创建单元格结束html
            tdBuffer.append(createTdEndHtml());
        }
        return tdBuffer.toString();
    }

    /**
     * 创建单元格开始html
     *
     * @param colIndex    列号
     * @param rowIndex    行号
     * @param cellElement 单元格
     * @return 单元格开始html
     */
    private String createTdStartHtml(int colIndex, int rowIndex, CellElement cellElement) {
        StringBuffer tdStartBuffer = new StringBuffer();

        tdStartBuffer.append("<td id=\"" + colIndex + "_" + rowIndex + "\"");
        if (cellElement.getColumnSpan() > 1) {
            tdStartBuffer.append(" colspan=\"" + cellElement.getColumnSpan() + "\"");
        }
        if (cellElement.getRowSpan() > 1) {
            tdStartBuffer.append(" rowspan=\"" + cellElement.getRowSpan() + "\"");
        }
        tdStartBuffer.append(" class=\"");
        Style style = cellElement.getStyle();
        if (style == null) {
            tdStartBuffer.append("S_0\">");
        } else {
            int cellStyleIndex = synchronizedStyleList.indexOfStyle(style);
            tdStartBuffer.append("S_" + cellStyleIndex + "\">");
        }
        return tdStartBuffer.toString();
    }

    /**
     * 创建单元格内容html
     *
     * @param cellElement 单元格
     * @return 单元格内容html
     */
    private String createTdContent(CellElement cellElement) {
        StringBuffer tdContentBuffer = new StringBuffer();
        AbstractTiankafeiDrawer htmlDrawer = TiankafeiNoteFactory.createHtmlDrawer(cellElement.getNote());
        String tdContent = htmlDrawer.drawerHtmlContent(cellElement);
        if (StringUtils.isNotEmpty(tdContent)) {
            tdContentBuffer.append(tdContent);
        }
        return tdContentBuffer.toString();
    }

    /**
     * 创建单元格结束html
     *
     * @return 单元格结束html
     */
    private String createTdEndHtml() {
        return "</td>";
    }

    /**
     * 创建行结束html
     *
     * @return 行结束html
     */
    private String createTrEndHtml() {
        return "</tr>";
    }

    /**
     * 创建表格结束html
     *
     * @return 表格结束html
     */
    private String createTableEndHtml() {
        return "</table>";
    }

    /**
     * 创建报表样式html
     *
     * @param synchronizedStyleList
     * @return 样式html
     */
    private String createReportStyleHtml(SynchronizedStyleList synchronizedStyleList) {
        StringBuffer styleBuf = new StringBuffer();
        styleBuf.append("<style>");
        for (int i = 0; i < synchronizedStyleList.getStyleCount(); i++) {
            Style style = synchronizedStyleList.getStyle(i);

            styleBuf.append(".S_").append(i).append(" {");
            if ((style.getBorderTop() == style.getBorderBottom())
                    && (style.getBorderTop() == style.getBorderLeft())
                    && (style.getBorderTop() == style.getBorderRight())
                    && (style.getBorderTopColor() == style.getBorderBottomColor())
                    && (style.getBorderTopColor() == style.getBorderLeftColor())
                    && (style.getBorderTopColor() == style.getBorderRightColor())) {

                String boderString = IOHelper.createCSSBorder(-1, style.getBorderTop(), style.getBorderTopColor());
                if ((boderString != null) && (boderString.length() > 0)) {
                    styleBuf.append(boderString);
                }
            } else {
                String boderString = IOHelper.createCSSBorder(1, style.getBorderTop(), style.getBorderTopColor());
                if ((boderString != null) && (boderString.length() > 0)) {
                    styleBuf.append(boderString);
                }
                boderString = IOHelper.createCSSBorder(4, style.getBorderRight(), style.getBorderRightColor());
                if ((boderString != null) && (boderString.length() > 0)) {
                    styleBuf.append(boderString);
                }
                boderString = IOHelper.createCSSBorder(3, style.getBorderBottom(), style.getBorderBottomColor());
                if ((boderString != null) && (boderString.length() > 0)) {
                    styleBuf.append(boderString);
                }
                boderString = IOHelper.createCSSBorder(2, style.getBorderLeft(), style.getBorderLeftColor());
                if ((boderString != null) && (boderString.length() > 0)) {
                    styleBuf.append(boderString);
                }
            }
            String fontString = IOHelper.createCSSFont(style.getFRFont());
            if ((fontString != null) && (fontString.length() > 0)) {
                styleBuf.append(fontString);
            }
            styleBuf.append(createCssBackground(style.getBackground()));

            int horizontalAlignment = style.getHorizontalAlignment();
            if (horizontalAlignment == 2) {
                styleBuf.append("text-align:left;");
            } else if (horizontalAlignment == 0) {
                styleBuf.append("text-align:center;");
            } else if (horizontalAlignment == 4) {
                styleBuf.append("text-align:right;");
            } else if (horizontalAlignment == 5) {
                styleBuf.append("text-align:justify;");
            }
            int verticalAlignment = style.getVerticalAlignment();
            if (verticalAlignment == 1) {
                styleBuf.append("vertical-align:top;");
            } else if (verticalAlignment == 0) {
                styleBuf.append("vertical-align:middle;");
            } else if (verticalAlignment == 3) {
                styleBuf.append("vertical-align:bottom;");
            }
            if (style.getTextStyle() == 0) {
                styleBuf.append("white-space:normal;");
            } else {
                styleBuf.append("white-space:nowrap;");
            }
            styleBuf.append("}");
        }
        styleBuf.append("</style>");
        return styleBuf.toString();
    }

    private String createCssBackground(Background background) {
        if (background == null) {
            return "";
        }
        if ((background instanceof ColorBackground)) {
            return "background-color:" + Utils.javaColorToCSSColor(((ColorBackground) background).getColor()) + ";";
        }
        return "";
    }

}
