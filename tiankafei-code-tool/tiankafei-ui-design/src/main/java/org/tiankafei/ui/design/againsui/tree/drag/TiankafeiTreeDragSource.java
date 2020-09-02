package org.tiankafei.ui.design.againsui.tree.drag;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.DataStreamUtil;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTree;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树拖拽源
 *
 * @author tiankafei1
 */
public class TiankafeiTreeDragSource extends DragSourceAdapter implements DragGestureListener {

    /**
     * 自定义树对象
     */
    private TkfTree tkfTree;

    public TiankafeiTreeDragSource(TkfTree tkfTree) {
        this.tkfTree = tkfTree;
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(tkfTree, DnDConstants.ACTION_COPY_OR_MOVE, this);
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO = tkfTree.getTiankafeiTreeAttributeVO();
        Cursor cursor = null;
        if (tiankafeiTreeAttributeVO.isTreeDragSourceDeleteFlag()) {
            cursor = DragSource.DefaultMoveDrop;
        } else {
            cursor = DragSource.DefaultCopyDrop;
        }
        Point point = dge.getDragOrigin();
        TreePath treePath = tkfTree.getPathForLocation(point.x, point.y);
        if (treePath != null) {
            TkfTreeNode tkfTreeNode = (TkfTreeNode) treePath.getLastPathComponent();
            try {
                serializableNode(tkfTreeNode);
            } catch (BaseException e) {
                e.printStackTrace();
            }

            if (tiankafeiTreeAttributeVO.isTreeDragSourceDeleteFlag()) {
                //源树节点拖拽时删除节点
                DefaultTreeModel treeDataModel = tiankafeiTreeAttributeVO.getTreeDataModel();
                treeDataModel.removeNodeFromParent(tkfTreeNode);
            }
        }
        dge.startDrag(cursor, new StringSelection("drag"), this);
    }

    private void serializableNode(TkfTreeNode tkfTreeNode) throws BaseException {
        FileOutputStream objfile = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objfile = new FileOutputStream("DragNode.OBJ");
            objectOutputStream = new ObjectOutputStream(objfile);
            objectOutputStream.writeObject(tkfTreeNode);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            DataStreamUtil.closeOutputStream(objfile);
            DataStreamUtil.closeOutputStream(objectOutputStream);
        }
    }

}
