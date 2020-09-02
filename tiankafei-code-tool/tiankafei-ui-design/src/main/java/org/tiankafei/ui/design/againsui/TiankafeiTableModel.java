package org.tiankafei.ui.design.againsui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.tiankafei.ui.design.dto.TableColumnDTO;

/**
 * 自定义表格模型
 *
 * @author tiankafei1
 */
public class TiankafeiTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1002550729180201649L;

    /**
     * 自定义表格列对象集合
     */
    private List<TableColumnDTO> tableColumnList;

    /**
     * 表格数据集合
     */
    private List<List<Object>> dataListList;

    public TiankafeiTableModel(List<TableColumnDTO> tableColumnList, List<List<Object>> dataListList) {
        this.tableColumnList = tableColumnList;
        this.dataListList = dataListList;
    }

    @Override
    public int getRowCount() {
        return dataListList.size();
    }

    @Override
    public int getColumnCount() {
        return tableColumnList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Object> dataList = dataListList.get(rowIndex);
        return dataList.get(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        List<Object> dataList = dataListList.get(rowIndex);
        dataList.set(columnIndex, aValue);
    }

}
