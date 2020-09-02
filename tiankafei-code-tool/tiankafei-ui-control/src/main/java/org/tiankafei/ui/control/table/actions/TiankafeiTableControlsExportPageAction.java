package org.tiankafei.ui.control.table.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.againsui.TiankafeiTable;

/**
 * 表格控件导出事件
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsExportPageAction extends AbstractTiankafeiActionListener {

    /**
     * 分页对象
     */
    private List<TiankafeiTable> tiankafeiTableList;

    /**
     * 构造表格控件导出事件对象
     *
     * @param tiankafeiTableList 表格对象集合
     */
    public TiankafeiTableControlsExportPageAction(List<TiankafeiTable> tiankafeiTableList) {
        this.tiankafeiTableList = tiankafeiTableList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TiankafeiTable tiankafeiTable = tiankafeiTableList.get(0);
        List<List<Object>> dataListList = tiankafeiTable.getDataListList();
        System.out.println("导出事件输出=" + dataListList.size());
    }

}
