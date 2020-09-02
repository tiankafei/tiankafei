package org.tiankafei.ui.design.againsui.abstractinterface;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * 树型表格模型抽象类
 *
 * @author tiankafei1
 */
public abstract class AbstractTreeTableModel implements ITreeTableModel {

    protected Object root;

    /**
     * 事件监听对象
     */
    protected EventListenerList listenerList;

    /**
     * 构造树型表格模型抽象类
     *
     * @param root 根节点对象
     */
    public AbstractTreeTableModel(Object root) {
        this.root = root;
        listenerList = new EventListenerList();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public boolean isLeaf(Object node) {
        return getChildCount(node) == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        for (int i = 0; i < getChildCount(parent); i++) {
            if (getChild(parent, i).equals(child)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listenerList.add(TreeModelListener.class, l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listenerList.remove(TreeModelListener.class, l);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return Object.class;
    }

    @Override
    public boolean isCellEditable(Object node, int column) {
        return getColumnClass(column) == ITreeTableModel.class;
    }

    @Override
    public void setValueAt(Object aValue, Object node, int column) {

    }

    protected void fireTreeNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children) {
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        int number = 2;
        for (int i = listeners.length - number; i >= 0; i -= number) {
            if (listeners[i] == TreeModelListener.class) {
                if (e == null) {
                    e = new TreeModelEvent(source, path, childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesChanged(e);
            }
        }
    }

    protected void fireTreeNodesInserted(Object source, Object[] path, int[] childIndices, Object[] children) {
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        int number = 2;
        for (int i = listeners.length - number; i >= 0; i -= number) {
            if (listeners[i] == TreeModelListener.class) {
                if (e == null) {
                    e = new TreeModelEvent(source, path, childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesInserted(e);
            }
        }
    }

    protected void fireTreeNodesRemoved(Object source, Object[] path, int[] childIndices, Object[] children) {
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        int number = 2;
        for (int i = listeners.length - number; i >= 0; i -= number) {
            if (listeners[i] == TreeModelListener.class) {
                if (e == null) {
                    e = new TreeModelEvent(source, path, childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesRemoved(e);
            }
        }
    }

    protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices, Object[] children) {
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        int number = 2;
        for (int i = listeners.length - number; i >= 0; i -= number) {
            if (listeners[i] == TreeModelListener.class) {
                if (e == null) {
                    e = new TreeModelEvent(source, path, childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeStructureChanged(e);
            }
        }
    }

}
