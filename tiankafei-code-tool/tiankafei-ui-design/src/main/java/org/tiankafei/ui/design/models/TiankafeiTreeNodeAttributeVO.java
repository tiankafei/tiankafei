package org.tiankafei.ui.design.models;

import java.awt.Color;
import java.io.Serializable;

/**
 * 自定义树节点属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiTreeNodeAttributeVO implements Serializable {

    private static final long serialVersionUID = 1829277264448952353L;

    /**
     * 节点选中时的颜色
     */
    private Color nodeChooseColor;

    /**
     * 节点是否选中的标识
     */
    private Boolean nodeCheckedFlag;

    /**
     * 节点对象
     */
    private Object userObject;

    /**
     * 节点是否展开的标识
     */
    private Boolean expandPathFlag;

    /**
     * 节点图标路径
     */
    private String nodeIconFilePath;

    /**
     * 节点图标宽度
     */
    private Integer nodeIconWidth;

    /**
     * 节点图标高度
     */
    private Integer nodeIconHeight;

    /**
     * 构造自定义树节点属性对象
     */
    public TiankafeiTreeNodeAttributeVO() {
        nodeChooseColor = Color.BLUE;
        nodeCheckedFlag = false;
        expandPathFlag = false;
        nodeIconWidth = 26;
        nodeIconHeight = 26;
    }

    /**
     * 获取节点选中时的颜色
     *
     * @return 节点选中时的颜色
     */
    public Color getNodeChooseColor() {
        return nodeChooseColor;
    }

    /**
     * 设置节点选中时的颜色
     *
     * @param nodeChooseColor 节点选中时的颜色
     */
    public void setNodeChooseColor(Color nodeChooseColor) {
        this.nodeChooseColor = nodeChooseColor;
    }

    /**
     * 获取节点是否选中的标识
     *
     * @return 节点是否选中的标识
     */
    public boolean isNodeCheckedFlag() {
        return nodeCheckedFlag;
    }

    /**
     * 设置节点是否选中的标识
     *
     * @param nodeCheckedFlag 节点是否选中的标识
     */
    public void setNodeCheckedFlag(boolean nodeCheckedFlag) {
        this.nodeCheckedFlag = nodeCheckedFlag;
    }

    /**
     * 获取节点对象
     *
     * @return 节点对象
     */
    public Object getUserObject() {
        return userObject;
    }

    /**
     * 设置节点对象
     *
     * @param userObject 节点对象
     */
    public void setUserObject(Object userObject) {
        this.userObject = userObject;
    }

    /**
     * 获取节点是否展开的标识
     *
     * @return 节点是否展开的标识
     */
    public boolean isExpandPathFlag() {
        return expandPathFlag;
    }

    /**
     * 设置节点是否展开的标识
     *
     * @param expandPathFlag 节点是否展开的标识
     */
    public void setExpandPathFlag(boolean expandPathFlag) {
        this.expandPathFlag = expandPathFlag;
    }

    /**
     * 获取节点图标路径
     *
     * @return 节点图标路径
     */
    public String getNodeIconFilePath() {
        return nodeIconFilePath;
    }

    /**
     * 设置节点图标路径
     *
     * @param nodeIconFilePath 节点图标路径
     */
    public void setNodeIconFilePath(String nodeIconFilePath) {
        this.nodeIconFilePath = nodeIconFilePath;
    }

    /**
     * 获取节点图标宽度
     *
     * @return 节点图标宽度
     */
    public int getNodeIconWidth() {
        return nodeIconWidth;
    }

    /**
     * 设置节点图标宽度
     *
     * @param nodeIconWidth 节点图标宽度
     */
    public void setNodeIconWidth(int nodeIconWidth) {
        this.nodeIconWidth = nodeIconWidth;
    }

    /**
     * 获取节点图标高度
     *
     * @return 节点图标高度
     */
    public int getNodeIconHeight() {
        return nodeIconHeight;
    }

    /**
     * 设置节点图标高度
     *
     * @param nodeIconHeight 节点图标高度
     */
    public void setNodeIconHeight(int nodeIconHeight) {
        this.nodeIconHeight = nodeIconHeight;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
