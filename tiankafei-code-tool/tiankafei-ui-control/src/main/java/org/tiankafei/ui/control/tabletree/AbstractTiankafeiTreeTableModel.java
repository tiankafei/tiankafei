package org.tiankafei.ui.control.tabletree;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * 自定义抽象树型表格数据模型
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiTreeTableModel implements ITiankafeiTreeTableModel {

    /**
     * 根节点对象
     */
    protected Object root;

    /**
     * 事件监听集合
     */
    protected EventListenerList listenerList;

    /**
     * 构造自定义抽象树型表格数据模型
     */
    public AbstractTiankafeiTreeTableModel() {
        listenerList = new EventListenerList();
    }

    /**
     * 构造自定义抽象树型表格数据模型
     *
     * @param root 根节点对象
     */
    public AbstractTiankafeiTreeTableModel(Object root) {
        this();
        this.root = root;
    }

    /**
     * 获取根节点对象
     */
    @Override
    public Object getRoot() {
        return root;
    }

    /**
     * 设置根节点对象
     *
     * @param root 根节点对象
     */
    public void setRoot(Object root) {
        this.root = root;
    }

    /**
     * 获取是否叶节点的标识
     */
    @Override
    public boolean isLeaf(Object node) {
        return getChildCount(node) == 0;
    }

    /**
     * 获取列的class
     */
    @Override
    public Class<?> getColumnClass(int column) {
        return Object.class;
    }

    /**
     * 属性表格当前列是否可编辑
     */
    @Override
    public boolean isCellEditable(Object node, int column) {
        return getColumnClass(column) == ITiankafeiTreeTableModel.class;
    }

    /**
     * 设置树型表格当前列的值
     */
    @Override
    public void setValueAt(Object aValue, Object node, int column) {
    }

    /**
     * 增加树模型监听事件
     */
    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        listenerList.add(TreeModelListener.class, treeModelListener);
    }

    /**
     * 删除树模型监听事件
     */
    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
        listenerList.remove(TreeModelListener.class, treeModelListener);
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
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

}

