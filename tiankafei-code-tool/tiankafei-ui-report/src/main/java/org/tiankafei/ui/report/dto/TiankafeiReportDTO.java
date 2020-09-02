package org.tiankafei.ui.report.dto;

import com.fr.base.BaseUtils;
import com.fr.report.WorkSheet;
import java.io.PrintWriter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 报表对象
 *
 * @author 甜咖啡
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class TiankafeiReportDTO extends WorkSheet {

    private static final long serialVersionUID = 8135242822247493528L;

    /**
     * 报表id
     */
    private String reportId;

    @Override
    public void readXML(Element element) {
        super.readXML(element);

        NodeList nodeList = element.getChildNodes();
        for (int index = 0, length = nodeList.getLength(); index < length; index++) {
            Node node = nodeList.item(index);
            if (node instanceof Element) {
                Element currentElement = (Element) node;
                String tagName = currentElement.getTagName();
                if ("TiankafeiReportAttributes".equals(tagName)) {
                    String attributeName = BaseUtils.getAttrValue(currentElement, "reportId");
                    if (StringUtils.isNotEmpty(attributeName)) {
                        setReportId(attributeName);
                    }
                }
            }
        }
    }

    @Override
    public void writeXML(PrintWriter printWriter) {
        super.writeXML(printWriter);

        StringBuffer buffer = new StringBuffer();
        buffer.append("<TiankafeiReportAttributes");

        if (StringUtils.isNotEmpty(getReportId())) {
            buffer.append(" reportId=\"").append(getReportId()).append("\"");
        }

        buffer.append("/>");
        printWriter.println(buffer.toString());
    }

    /**
     * 清空所有属性
     */
    public void clearAllAttribute() {
        System.out.println("重置");
    }

}
