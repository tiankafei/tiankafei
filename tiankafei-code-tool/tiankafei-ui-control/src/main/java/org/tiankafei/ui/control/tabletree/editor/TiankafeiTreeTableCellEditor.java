package org.tiankafei.ui.control.tabletree.editor;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import org.tiankafei.ui.control.TiankafeiTreeTableControls;
import org.tiankafei.ui.control.tabletree.ITiankafeiTreeTableModel;
import org.tiankafei.ui.control.tabletree.util.TiankafeiTreeTableTextField;

/**
 * 自定义树型表格单元格编辑器
 *
 * @author tiankafei1
 */
public class TiankafeiTreeTableCellEditor extends DefaultCellEditor {

    private static final long serialVersionUID = -6171948284962748127L;

    /**
     * 自定义表格树当中的树对象
     */
    private TiankafeiTreeTableControls.TkfTreeTableCellRenderer tree;

    /**
     * 树型表格控件对象
     */
    private TiankafeiTreeTableControls table;

    /**
     * 构造自定义树型表格单元格编辑器
     *
     * @param tree  自定义表格树当中的树对象
     * @param table 树型表格控件对象
     */
    public TiankafeiTreeTableCellEditor(TiankafeiTreeTableControls.TkfTreeTableCellRenderer tree, TiankafeiTreeTableControls table) {
        super(new TiankafeiTreeTableTextField());
        this.tree = tree;
        this.table = table;
    }

    /**
     * 渲染表格列
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int r, int c) {
        Component component = super.getTableCellEditorComponent(table, value, isSelected, r, c);
        boolean rv = tree.isRootVisible();
        int offsetRow = rv ? r : r - 1;
        Rectangle bounds = tree.getRowBounds(offsetRow);
        int offset = bounds.x;
        TreeCellRenderer treeCellRenderer = tree.getCellRenderer();
        if (treeCellRenderer instanceof DefaultTreeCellRenderer) {
            Object node = tree.getPathForRow(offsetRow).getLastPathComponent();
            Icon icon;
            if (tree.getModel().isLeaf(node)) {
                icon = ((DefaultTreeCellRenderer) treeCellRenderer).getLeafIcon();
            } else if (tree.isExpanded(offsetRow)) {
                icon = ((DefaultTreeCellRenderer) treeCellRenderer).getOpenIcon();
            } else {
                icon = ((DefaultTreeCellRenderer) treeCellRenderer).getClosedIcon();
            }
            if (icon != null) {
                offset += ((DefaultTreeCellRenderer) treeCellRenderer).getIconTextGap() + icon.getIconWidth();
            }
        }
        ((TiankafeiTreeTableTextField) getComponent()).offset = offset;
        return component;
    }

    /**
     * 表格列是否可编辑
     */
    @Override
    public boolean isCellEditable(EventObject e) {
        if (e instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) e;
            if (me.getModifiers() == 0 || me.getModifiers() == InputEvent.BUTTON1_MASK) {
                for (int counter = table.getColumnCount() - 1; counter >= 0; counter--) {
                    if (table.getColumnClass(counter) == ITiankafeiTreeTableModel.class) {
                        MouseEvent newMe = new MouseEvent(tree, me.getID(),
                                me.getWhen(), me.getModifiers(), me.getX() - table.getCellRect(0, counter, true).x,
                                me.getY(), me.getClickCount(),
                                me.isPopupTrigger());
                        tree.dispatchEvent(newMe);
                        break;
                    }
                }
            }
            int number = 3;
            if (me.getClickCount() >= number) {
                return true;
            }
            return false;
        }
        if (e == null) {
            return true;
        }
        return false;
    }

}
