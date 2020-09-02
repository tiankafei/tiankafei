package org.tiankafei.ui.design.againsui.abstractinterface;

import javax.swing.tree.TreeModel;

/**
 * 树型表格模型接口
 *
 * @author tiankafei1
 */
public interface ITreeTableModel extends TreeModel {

    /**
     * 获取列的总数
     *
     * @return 列的总数
     */
    public int getColumnCount();

    /**
     * 获取当前列的标题
     *
     * @param column 列号
     * @return 该列的标题
     */
    public String getColumnName(int column);

    /**
     * 获取当前列的class type
     *
     * @param column 列号
     * @return 该列的class type
     */
    public Class<?> getColumnClass(int column);

    /**
     * 获取当前行当前列的值
     *
     * @param node   当前树节点的node对象
     * @param column 当前列
     * @return 当前行当前列的值
     */
    public Object getValueAt(Object node, int column);

    /**
     * 获取当前列是否可以编辑的标识
     *
     * @param node   当前树节点的node对象
     * @param column 当前列
     * @return 当前列是否可以编辑的标识
     */
    public boolean isCellEditable(Object node, int column);

    /**
     * 设置当前行当前列的值
     *
     * @param aValue 要设置的值
     * @param node   当前树节点的node对象
     * @param column 当前列
     */
    public void setValueAt(Object aValue, Object node, int column);

}
