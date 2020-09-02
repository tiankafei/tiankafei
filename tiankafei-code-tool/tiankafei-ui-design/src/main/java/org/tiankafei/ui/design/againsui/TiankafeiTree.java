package org.tiankafei.ui.design.againsui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeCellRenderer;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeCheckBoxCellRenderer;
import org.tiankafei.ui.design.againsui.tree.renderer.TiankafeiTreeRadioCellRenderer;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTree;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树对象
 *
 * @author tiankafei
 */
public class TiankafeiTree extends TiankafeiDesignerVO {

    /**
     * 自定义树对象
     */
    private TkfTree tkfTree;

    /**
     * 自定义树节点属性对象
     */
    private TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO;

    /**
     * 根节点
     */
    private TkfTreeNode rootTkfTreeNode;

    /**
     * 构造自定义树对象
     */
    public TiankafeiTree() {
        tkfTree = new TkfTree();
        tiankafeiTreeAttributeVO = new TiankafeiTreeAttributeVO();
    }

    /**
     * 初始化自定义树对象
     *
     * @return 自定义树对象
     */
    public TkfTree initTiankafeiTree() {
        tkfTree.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件背景色
        tkfTree.setBackground(getBackgroundColor());
        //设置控件前景色
        tkfTree.setForeground(getForegroundColor());
        //设置字体
        tkfTree.setFont(new Font(getFontName(), getFontStyle(), getFontSize()));
        //设置浮现文本
        tkfTree.setToolTipText(getToolTipText());
        //设置行高
        tkfTree.setRowHeight(tiankafeiTreeAttributeVO.getTreeRowHeight());

        TiankafeiTreeNode rootTiankafeiTreeNode = new TiankafeiTreeNode();
        TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = rootTiankafeiTreeNode.getTiankafeiTreeNodeAttributeVO();
        tiankafeiTreeNodeAttributeVO.setExpandPathFlag(true);
        tiankafeiTreeNodeAttributeVO.setUserObject(tiankafeiTreeAttributeVO.getTreeRootNodeName());
        rootTkfTreeNode = rootTiankafeiTreeNode.initTiankafeiTreeNode();

        DefaultTreeModel treeDataModel = new DefaultTreeModel(rootTkfTreeNode);
        tkfTree.setModel(treeDataModel);
        tiankafeiTreeAttributeVO.setTreeDataModel(treeDataModel);
        //设置自定义树节点属性对象
        tkfTree.setTiankafeiTreeAttributeVO(tiankafeiTreeAttributeVO);
        //增加树节点
        List<TiankafeiTreeDTO> treeList = tiankafeiTreeAttributeVO.getTreeList();
        addTreeNode(treeList, rootTkfTreeNode);
        //展开子节点
        expandTreePath(rootTkfTreeNode);
        //根节点显示标识
        tkfTree.setRootVisible(tiankafeiTreeAttributeVO.isTreeRootNodeHiddelFlag());

        if (tiankafeiTreeAttributeVO.isTreeChooseFlag()) {
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tkfTree.setCellRenderer(new TiankafeiTreeCheckBoxCellRenderer(getForegroundColor()));
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tkfTree.setCellRenderer(new TiankafeiTreeRadioCellRenderer(getForegroundColor()));
            } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_NO == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                tkfTree.setCellRenderer(new TiankafeiTreeCellRenderer(tiankafeiTreeAttributeVO));
            }
        } else {
            tkfTree.setCellRenderer(new TiankafeiTreeCellRenderer(tiankafeiTreeAttributeVO));
        }

        //增加事件
        tkfTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tkfTree.getRowForLocation(e.getX(), e.getY());
                TreePath treePath = tkfTree.getPathForRow(row);
                if (treePath == null) {
                    return;
                }
                if (tiankafeiTreeAttributeVO.isTreeChooseFlag()) {
                    TkfTreeNode tkfTreeNode = ((TkfTreeNode) treePath.getLastPathComponent());
                    boolean checkedFlag = !tkfTreeNode.getTiankafeiTreeNodeAttributeVO().isNodeCheckedFlag();

                    if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                        checkNode(tkfTreeNode, checkedFlag);
                    } else if (TiankafeiDesignerConstants.CHOOSE_TYPE_RADIO == tiankafeiTreeAttributeVO.getTreeChooseType()) {
                        //更改跟节点状态
                        rootTkfTreeNode.getTiankafeiTreeNodeAttributeVO().setNodeCheckedFlag(false);
                        //递归更改子节点状态
                        updateChildTreeNodeStatus(rootTkfTreeNode);
                        tkfTreeNode.getTiankafeiTreeNodeAttributeVO().setNodeCheckedFlag(checkedFlag);
                    }
                    tkfTree.repaint();
                }
            }
        });

        return tkfTree;
    }

    /**
     * 更改子节点树状态
     *
     * @param tkfTreeNode
     */
    private void updateChildTreeNodeStatus(TkfTreeNode tkfTreeNode) {
        int childCount = tkfTreeNode.getChildCount();
        for (int i = 0, lem = childCount; i < lem; i++) {
            TkfTreeNode tempTkfTreeNode = (TkfTreeNode) tkfTreeNode.getChildAt(i);
            tempTkfTreeNode.getTiankafeiTreeNodeAttributeVO().setNodeCheckedFlag(false);
            updateChildTreeNodeStatus(tempTkfTreeNode);
        }
    }

    /**
     * 增加树节点
     *
     * @param tiankafeiTreeList 树节点对象集合
     * @param tkfTreeNode       树节点
     */
    private void addTreeNode(List<TiankafeiTreeDTO> tiankafeiTreeList, TkfTreeNode tkfTreeNode) {
        if (CollectionUtils.isNotEmpty(tiankafeiTreeList)) {
            for (int i = 0, lem = tiankafeiTreeList.size(); i < lem; i++) {
                TiankafeiTreeDTO tiankafeiTreeDTO = tiankafeiTreeList.get(i);

                TiankafeiTreeNode tiankafeiTreeNode = new TiankafeiTreeNode();
                TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tiankafeiTreeNode.getTiankafeiTreeNodeAttributeVO();
                tiankafeiTreeNodeAttributeVO.setUserObject(tiankafeiTreeDTO);
                tiankafeiTreeNodeAttributeVO.setNodeIconFilePath(tiankafeiTreeDTO.getNodeIconFilePath());
                tiankafeiTreeNodeAttributeVO.setNodeIconHeight(tiankafeiTreeDTO.getNodeIconHeight());
                tiankafeiTreeNodeAttributeVO.setNodeIconWidth(tiankafeiTreeDTO.getNodeIconWidth());
                TkfTreeNode tempTkfTreeNode = tiankafeiTreeNode.initTiankafeiTreeNode();
                tkfTreeNode.add(tempTkfTreeNode);

                List<TiankafeiTreeDTO> tempTiankafeiTreeList = tiankafeiTreeDTO.getTiankafeiTreeList();
                addTreeNode(tempTiankafeiTreeList, tempTkfTreeNode);
            }
        }
    }

    /**
     * 展开树节点
     *
     * @param tkfTreeNode
     */
    private void expandTreePath(TkfTreeNode tkfTreeNode) {
        int childCount = tkfTreeNode.getChildCount();
        if (childCount > 0) {
            TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tkfTreeNode.getTiankafeiTreeNodeAttributeVO();
            if (tiankafeiTreeNodeAttributeVO.isExpandPathFlag()) {
                tkfTree.expandPath(new TreePath(tkfTreeNode.getPath()));
            }
            for (int i = 0; i < childCount; i++) {
                TkfTreeNode tempTkfTreeNode = (TkfTreeNode) tkfTreeNode.getChildAt(i);
                //展开子节点
                expandTreePath(tempTkfTreeNode);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void checkNode(TkfTreeNode tkfTreeNode, boolean checkedFlag) {
        tkfTreeNode.getTiankafeiTreeNodeAttributeVO().setNodeCheckedFlag(checkedFlag);
        if (!tkfTreeNode.isLeaf()) {
            Enumeration<TreeNode> children = tkfTreeNode.children();
            while (children.hasMoreElements()) {
                checkNode((TkfTreeNode) children.nextElement(), checkedFlag);
            }
        }
    }

    /**
     * 获取自定义树节点属性对象
     *
     * @return 自定义树节点属性对象
     */
    public TiankafeiTreeAttributeVO getTiankafeiTreeAttributeVO() {
        return tiankafeiTreeAttributeVO;
    }

    /**
     * 设置自定义树节点属性对象
     *
     * @param tiankafeiTreeAttributeVO 自定义树节点属性对象
     */
    public void setTiankafeiTreeAttributeVO(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO) {
        this.tiankafeiTreeAttributeVO = tiankafeiTreeAttributeVO;
    }

    public TkfTreeNode getRootTkfTreeNode() {
        return rootTkfTreeNode;
    }

    public void setRootTkfTreeNode(TkfTreeNode rootTkfTreeNode) {
        this.rootTkfTreeNode = rootTkfTreeNode;
    }
}
