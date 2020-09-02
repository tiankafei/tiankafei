package org.tiankafei.ui.report.model;

import com.fr.base.BaseUtils;
import com.fr.report.write.AbstractNote;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.util.LogUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author 甜咖啡
 */
public abstract class AbstractTiankafeiReportNote extends AbstractNote {

    private static final long serialVersionUID = -2290868935513203806L;

    /**
     * 唯一标识
     */
    private String uuid;

    /**
     * 物理表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    @Override
    public void readXML(Element element) {
        super.readXML(element);

        NodeList nodeList = element.getChildNodes();
        for (int index = 0, length = nodeList.getLength(); index < length; index++) {
            Node node = nodeList.item(index);
            if (node instanceof Element) {
                Element currentElement = (Element) node;
                String tagName = currentElement.getTagName();
                if ("AbstractTiankafeiReportNote".equals(tagName)) {
                    String tempValue = null;
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "uuid")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setUuid(tempValue);
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "tableName")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setTableName(tempValue);
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "columnName")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setColumnName(tempValue);
                    }
                }
            }
        }
    }

    @Override
    public void writeXML(PrintWriter printWriter) {
        super.writeXML(printWriter);

        StringBuffer buffer = new StringBuffer();
        buffer.append("<AbstractTiankafeiReportNote ");
        buffer.append(" uuid=\"" + getValue(this.uuid) + "\" ");
        buffer.append(" tableName=\"" + getValue(this.tableName) + "\" ");
        buffer.append(" columnName=\"" + getValue(this.columnName) + "\" ");
        buffer.append(" />");
        printWriter.println(buffer.toString());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("没有找到实现类对象");
    }

    /**
     * 获取boolean类型值
     *
     * @param value 值
     * @return 返回值
     */
    protected boolean getBooleanValue(String value) {
        return Boolean.valueOf(value);
    }

    /**
     * 获取integer类型值
     *
     * @param value 值
     * @return 返回值
     */
    protected int getIntegerValue(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            LogUtil.error(value + "不是数字，请检查！");
            return -1;
        }
    }

    /**
     * 获取写入xml的值
     *
     * @param value 值
     * @return 返回值
     */
    protected String getValue(Object value) {
        String result = "";
        if (value != null) {
            String str = value.toString();
            if (StringUtils.isNotEmpty(str)) {
                result = str;
            }
        }
        return result;
    }

    /**
     * 获取唯一标识
     *
     * @return 唯一标识
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置唯一标识
     *
     * @param uuid 唯一标识
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取物理表名
     *
     * @return 物理表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置物理表名
     *
     * @param tableName 物理表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取字段名
     *
     * @return 字段名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置字段名
     *
     * @param columnName 字段名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
