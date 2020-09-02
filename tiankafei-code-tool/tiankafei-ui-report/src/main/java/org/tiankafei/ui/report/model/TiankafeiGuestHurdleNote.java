package org.tiankafei.ui.report.model;

import com.fr.base.BaseUtils;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 宾栏单元格
 *
 * @author 甜咖啡
 */
public class TiankafeiGuestHurdleNote extends AbstractTiankafeiReportNote {

    private static final long serialVersionUID = -2943516376024323362L;

    /**
     * 是否刀型父节点
     */
    private boolean knifeTypeParentFlag;

    /**
     * 是否左侧刀型父节点
     */
    private boolean leftKnifeTypeParentFlag;

    /**
     * 是否右侧刀型父节点
     */
    private boolean rightKnifeTypeParentFlag;

    /**
     * 是否刀型空节点
     */
    private boolean knifeTypeNullFlag;

    /**
     * 是否父子级父节点
     */
    private boolean parentAndSonParentFlag;

    /**
     * 是否子节点
     */
    private boolean childFlag;

    @Override
    public void readXML(Element element) {
        super.readXML(element);

        NodeList nodeList = element.getChildNodes();
        for (int index = 0, length = nodeList.getLength(); index < length; index++) {
            Node node = nodeList.item(index);
            if (node instanceof Element) {
                Element currentElement = (Element) node;
                String tagName = currentElement.getTagName();
                if ("TiankafeiGuestHurdleNote".equals(tagName)) {
                    String tempValue = null;
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "knifeTypeParentFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setKnifeTypeParentFlag(getBooleanValue(tempValue));
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "leftKnifeTypeParentFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setLeftKnifeTypeParentFlag(getBooleanValue(tempValue));
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "rightKnifeTypeParentFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setRightKnifeTypeParentFlag(getBooleanValue(tempValue));
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "knifeTypeNullFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setKnifeTypeNullFlag(getBooleanValue(tempValue));
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "parentAndSonParentFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setParentAndSonParentFlag(getBooleanValue(tempValue));
                    }
                    if ((tempValue = BaseUtils.getAttrValue(currentElement, "childFlag")) != null && StringUtils.isNotEmpty(tempValue)) {
                        setChildFlag(getBooleanValue(tempValue));
                    }
                }
            }
        }
    }

    @Override
    public void writeXML(PrintWriter printWriter) {
        super.writeXML(printWriter);

        StringBuffer buffer = new StringBuffer();
        buffer.append("<TiankafeiGuestHurdleNote ");
        buffer.append(" knifeTypeParentFlag=\"" + getValue(this.knifeTypeParentFlag) + "\" ");
        buffer.append(" leftKnifeTypeParentFlag=\"" + getValue(this.leftKnifeTypeParentFlag) + "\" ");
        buffer.append(" rightKnifeTypeParentFlag=\"" + getValue(this.rightKnifeTypeParentFlag) + "\" ");
        buffer.append(" knifeTypeNullFlag=\"" + getValue(this.knifeTypeNullFlag) + "\" ");
        buffer.append(" parentAndSonParentFlag=\"" + getValue(this.parentAndSonParentFlag) + "\" ");
        buffer.append(" childFlag=\"" + getValue(this.childFlag) + "\" ");
        buffer.append(" />");
        printWriter.println(buffer.toString());
    }

    /**
     * 获取是否刀型父节点
     *
     * @return 是否刀型父节点
     */
    public boolean isKnifeTypeParentFlag() {
        return knifeTypeParentFlag;
    }

    /**
     * 设置是否刀型父节点
     *
     * @param knifeTypeParentFlag 是否刀型父节点
     */
    public void setKnifeTypeParentFlag(boolean knifeTypeParentFlag) {
        this.knifeTypeParentFlag = knifeTypeParentFlag;
    }

    /**
     * 获取是否左侧刀型父节点
     *
     * @return 是否左侧刀型父节点
     */
    public boolean isLeftKnifeTypeParentFlag() {
        return leftKnifeTypeParentFlag;
    }

    /**
     * 设置是否左侧刀型父节点
     *
     * @param leftKnifeTypeParentFlag 是否左侧刀型父节点
     */
    public void setLeftKnifeTypeParentFlag(boolean leftKnifeTypeParentFlag) {
        this.leftKnifeTypeParentFlag = leftKnifeTypeParentFlag;
    }

    /**
     * 获取是否右侧刀型父节点
     *
     * @return 是否右侧刀型父节点
     */
    public boolean isRightKnifeTypeParentFlag() {
        return rightKnifeTypeParentFlag;
    }

    /**
     * 设置是否右侧刀型父节点
     *
     * @param rightKnifeTypeParentFlag 是否右侧刀型父节点
     */
    public void setRightKnifeTypeParentFlag(boolean rightKnifeTypeParentFlag) {
        this.rightKnifeTypeParentFlag = rightKnifeTypeParentFlag;
    }

    /**
     * 获取是否刀型空节点
     *
     * @return 是否刀型空节点
     */
    public boolean isKnifeTypeNullFlag() {
        return knifeTypeNullFlag;
    }

    /**
     * 设置是否刀型空节点
     *
     * @param knifeTypeNullFlag 是否刀型空节点
     */
    public void setKnifeTypeNullFlag(boolean knifeTypeNullFlag) {
        this.knifeTypeNullFlag = knifeTypeNullFlag;
    }

    /**
     * 获取是否父子级父节点
     *
     * @return 是否父子级父节点
     */
    public boolean isParentAndSonParentFlag() {
        return parentAndSonParentFlag;
    }

    /**
     * 设置是否父子级父节点
     *
     * @param parentAndSonParentFlag 是否父子级父节点
     */
    public void setParentAndSonParentFlag(boolean parentAndSonParentFlag) {
        this.parentAndSonParentFlag = parentAndSonParentFlag;
    }

    /**
     * 获取是否子节点
     *
     * @return 是否子节点
     */
    public boolean isChildFlag() {
        return childFlag;
    }

    /**
     * 设置是否子节点
     *
     * @param childFlag 是否子节点
     */
    public void setChildFlag(boolean childFlag) {
        this.childFlag = childFlag;
    }
}
