package org.tiankafei.ui.report.model;

import java.io.PrintWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 题目标题单元格
 *
 * @author 甜咖啡
 */
public class TiankafeiQuestionTitleNote extends AbstractTiankafeiReportNote {

    private static final long serialVersionUID = -5106680818878914222L;

    @Override
    public void readXML(Element element) {
        super.readXML(element);

        NodeList nodeList = element.getChildNodes();
        for (int index = 0, length = nodeList.getLength(); index < length; index++) {
            Node node = nodeList.item(index);
            if (node instanceof Element) {
                Element currentElement = (Element) node;
                String tagName = currentElement.getTagName();
                if ("TiankafeiQuestionTitleNote".equals(tagName)) {

                }
            }
        }
    }

    @Override
    public void writeXML(PrintWriter printWriter) {
        super.writeXML(printWriter);

        StringBuffer buffer = new StringBuffer();
        buffer.append("<TiankafeiQuestionTitleNote ");
        buffer.append(" />");
        printWriter.println(buffer.toString());
    }

}
