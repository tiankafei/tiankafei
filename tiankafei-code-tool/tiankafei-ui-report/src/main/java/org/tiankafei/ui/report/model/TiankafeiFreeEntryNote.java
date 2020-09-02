package org.tiankafei.ui.report.model;

import com.fr.base.BaseUtils;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 自由项单元格
 *
 * @author 甜咖啡
 */
public class TiankafeiFreeEntryNote extends AbstractTiankafeiReportNote {

    private static final long serialVersionUID = 5440949577140251153L;

    /**
     * 自由项标签唯一标识
     */
    private String freeEntryLabelId;

    @Override
    public void readXML(Element element) {
        super.readXML(element);

        NodeList nodeList = element.getChildNodes();
        for (int index = 0, length = nodeList.getLength(); index < length; index++) {
            Node node = nodeList.item(index);
            if (node instanceof Element) {
                Element currentElement = (Element) node;
                String tagName = currentElement.getTagName();
                if ("TiankafeiFreeEntryNote".equals(tagName)) {
                    String tempValue = null;
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "freeEntryLabelId")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setFreeEntryLabelId(tempValue);
                    }
                }
            }
        }
    }

    @Override
    public void writeXML(PrintWriter printWriter) {
        super.writeXML(printWriter);

        StringBuffer buffer = new StringBuffer();
        buffer.append("<TiankafeiFreeEntryNote ");
        buffer.append(" freeEntryLabelId=\"" + getValue(this.freeEntryLabelId) + "\" ");
        buffer.append(" />");
        printWriter.println(buffer.toString());
    }

    /**
     * 获取自由项标签唯一标识
     *
     * @return 自由项标签唯一标识
     */
    public String getFreeEntryLabelId() {
        return freeEntryLabelId;
    }

    /**
     * 设置自由项标签唯一标识
     *
     * @param freeEntryLabelId 自由项标签唯一标识
     */
    public void setFreeEntryLabelId(String freeEntryLabelId) {
        this.freeEntryLabelId = freeEntryLabelId;
    }
}
