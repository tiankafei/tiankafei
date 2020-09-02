package org.tiankafei.ui.design.example.treedrag;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Title: JTree之间的拖拽中的DragTargetTree
 * Description:通过向从“源树”中拖拽结点在目标树中重新构造一棵树，实现JTree之间的拖拽单向拖拽，这个类是“目的树”
 *
 * @author awaysrain(绝对零度)
 * @version 1.0
 */
public class DragTargetTree extends JTree implements DropTargetListener {

    private static final long serialVersionUID = 5487068900561589199L;

    /**
     * Construct the target tree
     */
    public DragTargetTree() {
        super();
        new DropTarget(this, java.awt.dnd.DnDConstants.ACTION_MOVE, this);
    }

    /**
     * dragEnter
     *
     * @param dtde DropTargetDragEvent
     */
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    /**
     * dragOver
     *
     * @param dtde DropTargetDragEvent
     */
    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    /**
     * dropActionChanged
     *
     * @param dtde DropTargetDragEvent
     */
    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    /**
     * drop
     *
     * @param dtde DropTargetDropEvent
     */
    @Override
    public void drop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(java.awt.dnd.DnDConstants.ACTION_COPY);
        java.awt.Point ap = dtde.getLocation();
        int x = (int) ap.getX();
        int y = (int) ap.getY();
        DefaultMutableTreeNode parnode;
        javax.swing.tree.TreePath tp = this.getPathForLocation(x, y);
        if (tp != null) {
            try {
                // get drop tree node with treepath
                DefaultMutableTreeNode no1 = (DefaultMutableTreeNode) tp.getLastPathComponent();
                parnode = no1;
                int index = parnode.getChildCount();
                // get drop tree mode
                javax.swing.tree.DefaultTreeModel tm = (javax.swing.tree.DefaultTreeModel) this.getModel();
                DefaultMutableTreeNode node2 = new DefaultMutableTreeNode();
                node2 = readNode();
                tm.insertNodeInto(node2, parnode, index);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * dragExit
     *
     * @param dte DropTargetEvent
     */
    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    /**
     * read the node
     *
     * @return DefaultMutableTreeNode
     * @throws Exception
     */
    private DefaultMutableTreeNode readNode() throws Exception {
        FileInputStream objfile = null;
        ObjectInputStream objectInputStream = null;
        try {
            objfile = new FileInputStream("DragNode.OBJ");
            objectInputStream = new ObjectInputStream(objfile);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) objectInputStream.readObject();
            return node;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
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
