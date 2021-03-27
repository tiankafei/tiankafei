package org.tiankafei.ui.design.againsui.tree.drag;

import java.awt.Point;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.tiankafei.common.util.DataStreamUtil;
import org.tiankafei.ui.design.modelsui.TkfTree;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树拖拽目标
 *
 * @author tiankafei1
 */
public class TiankafeiTreeDropTarget extends DropTargetAdapter {

    /**
     * 自定义树对象
     */
    private TkfTree tkfTree;

    public TiankafeiTreeDropTarget(TkfTree tkfTree) {
        super();
        this.tkfTree = tkfTree;
        new DropTarget(tkfTree, DnDConstants.ACTION_MOVE, this);
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(DnDConstants.ACTION_COPY);
        Point point = dtde.getLocation();
        TreePath treePath = tkfTree.getPathForLocation(point.x, point.y);
        if (treePath != null) {
            try {
                //目标树节点
                TkfTreeNode targetNode = (TkfTreeNode) treePath.getLastPathComponent();
                int index = targetNode.getChildCount();
                //获取源树节点
                DefaultTreeModel tm = (DefaultTreeModel) tkfTree.getModel();
                DefaultMutableTreeNode sourceNode = readNode();
                tm.insertNodeInto(sourceNode, targetNode, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private TkfTreeNode readNode() throws Exception {
        FileInputStream objfile = null;
        ObjectInputStream objectInputStream = null;
        try {
            objfile = new FileInputStream("DragNode.OBJ");
            objectInputStream = new ObjectInputStream(objfile);
            TkfTreeNode tkfTreeNode = (TkfTreeNode) objectInputStream.readObject();
            return tkfTreeNode;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            DataStreamUtil.closeInputStream(objfile);
            DataStreamUtil.closeInputStream(objectInputStream);
        }
    }

}
