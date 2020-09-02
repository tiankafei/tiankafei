package org.tiankafei.ui.control.tabletree;

import javax.swing.tree.TreeModel;

/**
 * 自定义树型表格的数据模型接口
 *
 * @author tiankafei1
 */
public interface ITiankafeiTreeTableModel extends TreeModel {

    /**
     * 获取列数量
     *
     * @return 列数量
     */
    public int getColumnCount();

    /**
     * 获取列标题名称
     *
     * @param column 列号
     * @return 列标题名称
     */
    public String getColumnName(int column);

    /**
     * 获取列的class
     *
     * @param column 列号
     * @return 列的class
     */
    public Class<?> getColumnClass(int column);

    /**
     * 获取树型表格当前列的值
     *
     * @param node   树节点
     * @param column 列号
     * @return 树型表格当前列的值
     */
    public Object getValueAt(Object node, int column);

    /**
     * 属性表格当前列是否可编辑
     *
     * @param node   树节点
     * @param column 列号
     * @return 否可编辑的标识
     */
    public boolean isCellEditable(Object node, int column);

    /**
     * 设置树型表格当前列的值
     *
     * @param aValue 要设置的值
     * @param node   树节点
     * @param column 列号
     */
    public void setValueAt(Object aValue, Object node, int column);

    /**
     * 获取根节点对象
     *
     * @return
     */
    @Override
    public Object getRoot();

}
