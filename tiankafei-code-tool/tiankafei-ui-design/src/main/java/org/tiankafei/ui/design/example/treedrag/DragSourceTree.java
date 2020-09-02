package org.tiankafei.ui.design.example.treedrag;

import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * <p>
 * Title: JTree之间的拖拽中的DragSourceTree
 * </p>
 * <p>
 * Description:通过向从“源树”中拖拽结点在目标树中重新构造一棵树，实现JTree之间的拖拽单向拖拽，这个类是“源树”。
 * </p>
 *
 * @author awaysrain(绝对零度)
 * @version 1.0
 */
public class DragSourceTree extends JTree implements DragGestureListener, DragSourceListener {

    private static final long serialVersionUID = 864308002542114808L;

    private DragSource dragSource = null;

    public DragSourceTree() {
        super();
        dragSource = DragSource.getDefaultDragSource();
        dragSource.createDefaultDragGestureRecognizer(this, java.awt.dnd.DnDConstants.ACTION_MOVE, this);
    }

    /**
     * dragGestureRecognized
     *
     * @param dge DragGestureEvent
     */
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        java.awt.Cursor cursor = null;
        cursor = DragSource.DefaultMoveDrop;
        java.awt.Point jap = dge.getDragOrigin();
        int x = (int) jap.getX();
        int y = (int) jap.getY();
        javax.swing.tree.TreePath tp = this.getPathForLocation(x, y);
        if (tp != null) {
            DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) tp.getLastPathComponent();
            serializableNode(node1);
        }
        // event start
        dge.startDrag(cursor, new StringSelection("drag"), this);
    }

    /**
     * dragEnter
     *
     * @param dsde DragSourceDragEvent
     */
    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    /**
     * dragOver
     *
     * @param dsde DragSourceDragEvent
     */
    @Override
    public void dragOver(DragSourceDragEvent dsde) {
    }

    /**
     * dropActionChanged
     *
     * @param dsde DragSourceDragEvent
     */
    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
    }

    /**
     * dragDropEnd
     *
     * @param dsde DragSourceDropEvent
     */
    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
    }

    /**
     * dragExit
     *
     * @param dse DragSourceEvent
     */
    @Override
    public void dragExit(DragSourceEvent dse) {
    }

    /**
     * Serializable node
     *
     * @param node DefaultMutableTreeNode
     */
    private void serializableNode(DefaultMutableTreeNode node) {
        FileOutputStream objfile = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objfile = new FileOutputStream("DragNode.OBJ");
            objectOutputStream = new ObjectOutputStream(objfile);
            objectOutputStream.writeObject(node);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                if (objfile != null) {
                    objfile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
