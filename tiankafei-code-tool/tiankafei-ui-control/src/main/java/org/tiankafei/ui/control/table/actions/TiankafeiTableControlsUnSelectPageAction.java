package org.tiankafei.ui.control.table.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.models.TiankafeiTableDataModelVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 表格控件反选事件
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsUnSelectPageAction extends AbstractTiankafeiActionListener {

    /**
     * 分页对象
     */
    private List<TiankafeiTable> tiankafeiTableList;

    /**
     * 构造表格控件反选事件对象
     *
     * @param tiankafeiTableList 表格对象集合
     */
    public TiankafeiTableControlsUnSelectPageAction(List<TiankafeiTable> tiankafeiTableList) {
        this.tiankafeiTableList = tiankafeiTableList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TiankafeiTable tiankafeiTable = tiankafeiTableList.get(0);
        TkfTable tkfTable = tiankafeiTable.getTkfTable();
        TiankafeiTableDataModelVO tiankafeiTableDataModelVO = tkfTable.getTiankafeiTableDataModelVO();

        int tableChooseColumnIndex = tiankafeiTableDataModelVO.getTableChooseColumnIndex();
        DefaultTableModel tableDataModel = tiankafeiTableDataModelVO.getTableDataModel();
        int rowCount = tableDataModel.getRowCount();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Boolean value = (Boolean) tableDataModel.getValueAt(rowIndex, tableChooseColumnIndex);
            tableDataModel.setValueAt(!value.booleanValue(), rowIndex, tableChooseColumnIndex);
        }

        //刷新延迟问题
        tkfTable.updateUI();
        for (int i = 1, lem = tiankafeiTableList.size(); i < lem; i++) {
            tiankafeiTable = tiankafeiTableList.get(i);
            tkfTable = tiankafeiTable.getTkfTable();
            tkfTable.updateUI();
        }
    }

}
