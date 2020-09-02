package org.tiankafei.ui.design.example.moretabletitle;

import java.util.List;
import javax.swing.table.AbstractTableModel;

class DtableModel extends AbstractTableModel {

    private static final long serialVersionUID = -925102957037787236L;
    private List<CellData>[] listData;
    private int column;

    public DtableModel(List<CellData>[] listData, int column) {
        this.listData = listData;
        this.column = column;
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public int getRowCount() {
        return listData.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CellData cellData = listData[rowIndex].get(columnIndex);
        return cellData == null ? null : cellData.getValue();
    }
}