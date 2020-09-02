package org.tiankafei.ui.control.tabletree;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreePath;

/**
 * 自定义树型表格模型适配器
 *
 * @author tiankafei1
 */
public class TiankafeiTreeTableModelAdapter extends AbstractTableModel {

    private static final long serialVersionUID = 3965700310275987790L;

    /**
     * 树对象
     */
    private JTree tree;

    /**
     * 自定义树型表格的数据模型接口
     */
    private ITiankafeiTreeTableModel tiankafeiTreeTableModel;

    /**
     * 构造自定义树型表格模型适配器
     *
     * @param tiankafeiTreeTableModel 自定义树型表格的数据模型接口
     * @param tree                    树对象
     */
    public TiankafeiTreeTableModelAdapter(ITiankafeiTreeTableModel tiankafeiTreeTableModel, JTree tree) {
        this.tiankafeiTreeTableModel = tiankafeiTreeTableModel;
        this.tree = tree;

        tree.addTreeExpansionListener(new TreeExpansionListener() {
            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                fireTableDataChanged();
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                fireTableDataChanged();
            }
        });
    }

    @Override
    public int getColumnCount() {
        return tiankafeiTreeTableModel.getColumnCount();
    }

    @Override
    public String getColumnName(int column) {
        return tiankafeiTreeTableModel.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return tiankafeiTreeTableModel.getColumnClass(column);
    }

    @Override
    public int getRowCount() {
        return tree.getRowCount();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return tiankafeiTreeTableModel.getValueAt(nodeForRow(row), column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return tiankafeiTreeTableModel.isCellEditable(nodeForRow(row), column);
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        tiankafeiTreeTableModel.setValueAt(value, nodeForRow(row), column);
    }

    /**
     * 获取当前行的树节点对象
     *
     * @param row 行号
     * @return 当前行的树节点对象
     */
    protected Object nodeForRow(int row) {
        TreePath treePath = tree.getPathForRow(row);
        return treePath.getLastPathComponent();
    }

}
