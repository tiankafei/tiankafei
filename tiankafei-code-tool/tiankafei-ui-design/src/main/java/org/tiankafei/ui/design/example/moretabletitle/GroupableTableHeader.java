package org.tiankafei.ui.design.example.moretabletitle;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

class GroupableTableHeader extends JTableHeader {

    private static final long serialVersionUID = 3816656817027843651L;
    // private static final String uiClassID = "GroupableTableHeaderUI";

    protected Vector<ColumnGroup> columnGroups = null;

    public GroupableTableHeader(TableColumnModel model) {
        super(model);
        setUI(new GroupableTableHeaderUi(this));
        setReorderingAllowed(false);
    }

    @Override
    public void setReorderingAllowed(boolean b) {
        reorderingAllowed = false;
    }

    public void addColumnGroup(ColumnGroup g) {
        if (columnGroups == null) {
            columnGroups = new Vector<ColumnGroup>();
        }
        columnGroups.addElement(g);
    }

    public Enumeration<Object> getColumnGroups(TableColumn col) {
        if (columnGroups == null) {
            return null;
        }
        Enumeration<ColumnGroup> em = columnGroups.elements();
        while (em.hasMoreElements()) {
            ColumnGroup cGroup = (ColumnGroup) em.nextElement();
            Vector<Object> vRet = (Vector<Object>) cGroup.getColumnGroups(col, new Vector<Object>());
            if (vRet != null) {
                return vRet.elements();
            }
        }
        return null;
    }

    public void setColumnMargin() {
        if (columnGroups == null) {
            return;
        }
        int columnMargin = getColumnModel().getColumnMargin();
        Enumeration<ColumnGroup> em = columnGroups.elements();
        while (em.hasMoreElements()) {
            ColumnGroup cGroup = (ColumnGroup) em.nextElement();
            cGroup.setColumnMargin(columnMargin);
        }
    }

}