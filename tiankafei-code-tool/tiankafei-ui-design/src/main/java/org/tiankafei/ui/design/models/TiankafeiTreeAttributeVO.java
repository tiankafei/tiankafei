package org.tiankafei.ui.design.models;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;

/**
 * 自定义树属性对象
 *
 * @author tiankafei1
 */
public class TiankafeiTreeAttributeVO implements Serializable {

    private static final long serialVersionUID = 1829277264448952353L;

    /**
     * 是否支持选择的标识
     */
    private Boolean treeChooseFlag;

    /**
     * 支持选择的情况，选取类型
     */
    private Integer treeChooseType;

    /**
     * 树的高度
     */
    private Integer treeRowHeight;

    /**
     * 表格树数据集合
     */
    private List<TiankafeiTreeDTO> treeList;

    /**
     * 树数据模型
     */
    private DefaultTreeModel treeDataModel;

    /**
     * 树节点移动标识
     */
    private Boolean treeMoveFlag;

    /**
     * 树根节点隐藏标识
     */
    private Boolean treeRootNodeHiddelFlag;

    /**
     * 树根节点名称
     */
    private String treeRootNodeName;

    /**
     * 树拖拽类型0不支持拖拽，1源树，2目标树，3即时源树又是目标树
     */
    private Integer treeDragType;

    /**
     * 树拖拽的时候源树是否需要删除的标识
     */
    private Boolean treeDragSourceDeleteFlag;

    /**
     * 表格树根节点对象
     */
    private TiankafeiTreeDTO treeTableRootDTO;

    /**
     * 树点击时行的背景色
     */
    private Color treeClickBackgroundColor;

    /**
     * 展开图标路径
     */
    private String expandIconFilePath;

    /**
     * 展开图标宽度
     */
    private Integer expandIconWidth;

    /**
     * 展开图标高度
     */
    private Integer expandIconHeight;

    /**
     * 关闭图标路径
     */
    private String closedIconFilePath;

    /**
     * 关闭图标宽度
     */
    private Integer closedIconWidth;

    /**
     * 关闭图标高度
     */
    private Integer closedIconHeight;

    /**
     * 叶节点图标路径
     */
    private String leafIconFilePath;

    /**
     * 叶节点图标宽度
     */
    private Integer leafIconWidth;

    /**
     * 叶节点图标高度
     */
    private Integer leafIconHeight;

    /**
     * 构造自定义树节点属性对象
     */
    public TiankafeiTreeAttributeVO() {
        treeChooseFlag = false;
        treeChooseType = TiankafeiDesignerConstants.CHOOSE_TYPE_NO;
        treeRowHeight = 20;
        treeList = Lists.newArrayList();
        treeMoveFlag = false;
        treeRootNodeHiddelFlag = true;
        treeRootNodeName = "根节点";
        treeDragType = TiankafeiDesignerConstants.TREE_DRAG_NO;
        treeDragSourceDeleteFlag = false;
        treeClickBackgroundColor = new Color(76, 127, 208);

        expandIconFilePath = "/images/folder_open.png";
        expandIconHeight = 16;
        expandIconWidth = 16;

        closedIconFilePath = "/images/folder_closed.png";
        closedIconHeight = 16;
        closedIconWidth = 16;

        leafIconFilePath = "/images/property.png";
        leafIconHeight = 16;
        leafIconWidth = 16;
    }

    /**
     * 获取是否支持选择的标识
     *
     * @return 是否支持选择的标识
     */
    public boolean isTreeChooseFlag() {
        return treeChooseFlag;
    }

    /**
     * 设置是否支持选择的标识
     *
     * @param treeChooseFlag 是否支持选择的标识
     */
    public void setTreeChooseFlag(boolean treeChooseFlag) {
        this.treeChooseFlag = treeChooseFlag;
    }

    /**
     * 获取支持选择的情况，选取类型
     *
     * @return 支持选择的情况，选取类型
     */
    public int getTreeChooseType() {
        return treeChooseType;
    }

    /**
     * 设置支持选择的情况，选取类型
     *
     * @param treeChooseType 支持选择的情况，选取类型
     */
    public void setTreeChooseType(int treeChooseType) {
        this.treeChooseType = treeChooseType;
    }

    /**
     * 获取树的高度
     *
     * @return 树的高度
     */
    public int getTreeRowHeight() {
        return treeRowHeight;
    }

    /**
     * 设置树的高度
     *
     * @param treeRowHeight 树的高度
     */
    public void setTreeRowHeight(int treeRowHeight) {
        this.treeRowHeight = treeRowHeight;
    }

    /**
     * 获取树数据模型
     *
     * @return 树数据模型
     */
    public DefaultTreeModel getTreeDataModel() {
        return treeDataModel;
    }

    /**
     * 设置树数据模型
     *
     * @param treeDataModel 树数据模型
     */
    public void setTreeDataModel(DefaultTreeModel treeDataModel) {
        this.treeDataModel = treeDataModel;
    }

    /**
     * 获取树节点移动标识
     *
     * @return 树节点移动标识
     */
    public boolean isTreeMoveFlag() {
        return treeMoveFlag;
    }

    /**
     * 设置树节点移动标识
     *
     * @param treeMoveFlag 树节点移动标识
     */
    public void setTreeMoveFlag(boolean treeMoveFlag) {
        this.treeMoveFlag = treeMoveFlag;
    }

    /**
     * 获取表格树数据集合
     *
     * @return 表格树数据集合
     */
    public List<TiankafeiTreeDTO> getTreeList() {
        return treeList;
    }

    /**
     * 设置表格树数据集合
     *
     * @param treeList 表格树数据集合
     */
    public void setTreeList(List<TiankafeiTreeDTO> treeList) {
        this.treeList = treeList;
    }

    /**
     * 获取树根节点隐藏标识
     *
     * @return 树根节点隐藏标识
     */
    public boolean isTreeRootNodeHiddelFlag() {
        return treeRootNodeHiddelFlag;
    }

    /**
     * 设置树根节点隐藏标识
     *
     * @param treeRootNodeHiddelFlag 树根节点隐藏标识
     */
    public void setTreeRootNodeHiddelFlag(boolean treeRootNodeHiddelFlag) {
        this.treeRootNodeHiddelFlag = treeRootNodeHiddelFlag;
    }

    /**
     * 获取树根节点名称
     *
     * @return 树根节点名称
     */
    public String getTreeRootNodeName() {
        return treeRootNodeName;
    }

    /**
     * 设置树根节点名称
     *
     * @param treeRootNodeName 树根节点名称
     */
    public void setTreeRootNodeName(String treeRootNodeName) {
        this.treeRootNodeName = treeRootNodeName;
    }

    /**
     * 获取树拖拽类型0不支持拖拽，1源树，2目标树，3即时源树又是目标树
     *
     * @return 树拖拽类型
     */
    public int getTreeDragType() {
        return treeDragType;
    }

    /**
     * 设置树拖拽类型0不支持拖拽，1源树，2目标树，3即时源树又是目标树
     *
     * @param treeDragType 树拖拽类型
     */
    public void setTreeDragType(int treeDragType) {
        this.treeDragType = treeDragType;
    }

    /**
     * 获取树拖拽的时候源树是否需要删除的标识
     *
     * @return 树拖拽的时候源树是否需要删除的标识
     */
    public boolean isTreeDragSourceDeleteFlag() {
        return treeDragSourceDeleteFlag;
    }

    /**
     * 设置树拖拽的时候源树是否需要删除的标识
     *
     * @param treeDragSourceDeleteFlag 树拖拽的时候源树是否需要删除的标识
     */
    public void setTreeDragSourceDeleteFlag(boolean treeDragSourceDeleteFlag) {
        this.treeDragSourceDeleteFlag = treeDragSourceDeleteFlag;
    }

    /**
     * 获取表格树根节点对象
     *
     * @return 表格树根节点对象
     */
    public TiankafeiTreeDTO getTreeTableRootDTO() {
        return treeTableRootDTO;
    }

    /**
     * 设置表格树根节点对象
     *
     * @param treeTableRootDTO 表格树根节点对象
     */
    public void setTreeTableRootDTO(TiankafeiTreeDTO treeTableRootDTO) {
        this.treeTableRootDTO = treeTableRootDTO;
    }

    /**
     * 获取树点击时行的背景色
     *
     * @return 树点击时行的背景色
     */
    public Color getTreeClickBackgroundColor() {
        return treeClickBackgroundColor;
    }

    /**
     * 设置树点击时行的背景色
     *
     * @param treeClickBackgroundColor 树点击时行的背景色
     */
    public void setTreeClickBackgroundColor(Color treeClickBackgroundColor) {
        this.treeClickBackgroundColor = treeClickBackgroundColor;
    }

    /**
     * 获取展开图标路径
     *
     * @return 展开图标路径
     */
    public String getExpandIconFilePath() {
        return expandIconFilePath;
    }

    /**
     * 设置展开图标路径
     *
     * @param expandIconFilePath 展开图标路径
     */
    public void setExpandIconFilePath(String expandIconFilePath) {
        this.expandIconFilePath = expandIconFilePath;
    }

    /**
     * 获取展开图标宽度
     *
     * @return 展开图标宽度
     */
    public int getExpandIconWidth() {
        return expandIconWidth;
    }

    /**
     * 设置展开图标宽度
     *
     * @param expandIconWidth 展开图标宽度
     */
    public void setExpandIconWidth(int expandIconWidth) {
        this.expandIconWidth = expandIconWidth;
    }

    /**
     * 获取展开图标高度
     *
     * @return 展开图标高度
     */
    public int getExpandIconHeight() {
        return expandIconHeight;
    }

    /**
     * 设置展开图标高度
     *
     * @param expandIconHeight 展开图标高度
     */
    public void setExpandIconHeight(int expandIconHeight) {
        this.expandIconHeight = expandIconHeight;
    }

    /**
     * 获取关闭图标路径
     *
     * @return 关闭图标路径
     */
    public String getClosedIconFilePath() {
        return closedIconFilePath;
    }

    /**
     * 设置关闭图标路径
     *
     * @param closedIconFilePath 关闭图标路径
     */
    public void setClosedIconFilePath(String closedIconFilePath) {
        this.closedIconFilePath = closedIconFilePath;
    }

    /**
     * 获取关闭图标宽度
     *
     * @return 关闭图标宽度
     */
    public int getClosedIconWidth() {
        return closedIconWidth;
    }

    /**
     * 设置关闭图标宽度
     *
     * @param closedIconWidth 关闭图标宽度
     */
    public void setClosedIconWidth(int closedIconWidth) {
        this.closedIconWidth = closedIconWidth;
    }

    /**
     * 获取关闭图标高度
     *
     * @return 关闭图标高度
     */
    public int getClosedIconHeight() {
        return closedIconHeight;
    }

    /**
     * 设置关闭图标高度
     *
     * @param closedIconHeight 关闭图标高度
     */
    public void setClosedIconHeight(int closedIconHeight) {
        this.closedIconHeight = closedIconHeight;
    }

    /**
     * 获取叶节点图标路径
     *
     * @return 叶节点图标路径
     */
    public String getLeafIconFilePath() {
        return leafIconFilePath;
    }

    /**
     * 设置叶节点图标路径
     *
     * @param leafIconFilePath 叶节点图标路径
     */
    public void setLeafIconFilePath(String leafIconFilePath) {
        this.leafIconFilePath = leafIconFilePath;
    }

    /**
     * 获取叶节点图标宽度
     *
     * @return 叶节点图标宽度
     */
    public int getLeafIconWidth() {
        return leafIconWidth;
    }

    /**
     * 设置叶节点图标宽度
     *
     * @param leafIconWidth 叶节点图标宽度
     */
    public void setLeafIconWidth(int leafIconWidth) {
        this.leafIconWidth = leafIconWidth;
    }

    /**
     * 获取叶节点图标高度
     *
     * @return 叶节点图标高度
     */
    public int getLeafIconHeight() {
        return leafIconHeight;
    }

    /**
     * 设置叶节点图标高度
     *
     * @param leafIconHeight 叶节点图标高度
     */
    public void setLeafIconHeight(int leafIconHeight) {
        this.leafIconHeight = leafIconHeight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
