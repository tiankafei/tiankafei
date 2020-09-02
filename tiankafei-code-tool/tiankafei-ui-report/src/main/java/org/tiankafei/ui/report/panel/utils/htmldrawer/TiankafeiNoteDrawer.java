package org.tiankafei.ui.report.panel.utils.htmldrawer;

import com.fr.base.Style;
import com.fr.report.CellElement;
import com.fr.report.cellElement.Formula;
import com.fr.report.core.ChartReflectHelper;
import com.fr.report.core.paint.PaintUtil;
import com.fr.report.painter.AccountPainter;
import com.fr.report.painter.AccountTitlePainter;
import com.fr.report.painter.BarcodePainter;
import com.fr.web.core.HTMLWriterUtils;
import java.awt.Image;

/**
 * @author 甜咖啡
 */
public class TiankafeiNoteDrawer extends AbstractTiankafeiDrawer {


    @Override
    public String drawerHtmlContent(CellElement cellElement) {
        StringBuffer tdContentBuffer = new StringBuffer();

        Object value = cellElement.getValue();
        boolean flag = (value != null) &&
                (
                        (!(value instanceof Formula)) ||
                                (
                                        (!(value instanceof Image))
                                                && (!(value instanceof BarcodePainter))
                                                && (!ChartReflectHelper.instanceofChart(value))
                                                && (!(value instanceof AccountPainter))
                                                && (!(value instanceof AccountTitlePainter))
                                )
                );
        if (flag) {
            tdContentBuffer.append("<label style=\"margin:2px;\">");
            Style style = cellElement.getStyle();
            String myValue = PaintUtil.valueToText(value, style.getFormat());
            myValue = HTMLWriterUtils.htmlEncode(myValue);
            tdContentBuffer.append(myValue);
            tdContentBuffer.append("</label>");
        }
        return tdContentBuffer.toString();
    }
}
