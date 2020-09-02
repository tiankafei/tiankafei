package org.tiankafei.ui.design.againsui;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.tiankafei.base.dto.PaginatedDTO;
import org.tiankafei.ui.design.againsui.table.renderer.TiankafeiTableCellRenderer;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格对象
 *
 * @author tiankafei
 */
public class TiankafeiTable extends TiankafeiDesignerVO {

    /**
     * 自定义表格对象
     */
    private TkfTable tkfTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 自定义表格分页对象
     */
    private TiankafeiTablePageVO tiankafeiTablePageVO;

    /**
     * 构造自定义表格对象
     */
    public TiankafeiTable() {
        tkfTable = new TkfTable();
        tiankafeiTableAttributeVO = new TiankafeiTableAttributeVO();
        tiankafeiTablePageVO = new TiankafeiTablePageVO();
    }

    /**
     * 初始化自定义表格对象
     *
     * @return 自定义表格对象
     */
    public TkfTable initTiankafeiTable() {
        //自定义表格属性对象
        tkfTable.setTiankafeiTableAttributeVO(tiankafeiTableAttributeVO);
        //设置自定义控件模型UI对象
        tkfTable.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置表格选定方式
        tkfTable.setSelectionMode(tiankafeiTableAttributeVO.getTableSelectionMode());
        //设置单元格选择
        boolean tableSelectedCellFlag = tiankafeiTableAttributeVO.isTableSelectedCellFlag();
        if (tableSelectedCellFlag) {
            tkfTable.setCellSelectionEnabled(tableSelectedCellFlag);
        }
        //设置表格行高
        tkfTable.setRowHeight(tiankafeiTableAttributeVO.getTableRowHeight());
        //设置表格行间距
        tkfTable.setRowMargin(tiankafeiTableAttributeVO.getTableRowMargin());
        //设置表格水平线
        tkfTable.setShowHorizontalLines(tiankafeiTableAttributeVO.isTableShowHorizontalLineFlag());
        //设置表格垂直线
        tkfTable.setShowVerticalLines(tiankafeiTableAttributeVO.isTableShowVerticalLineFlag());
        //设置表格线颜色
        tkfTable.setGridColor(tiankafeiTableAttributeVO.getTableGridLineColor());
        //不自动调整列的宽度；使用滚动条
        tkfTable.setAutoResizeMode(TkfTable.AUTO_RESIZE_OFF);
        //设置点击时的背景色
        tkfTable.setSelectionBackground(tiankafeiTableAttributeVO.getTableClickBackgroundColor());
        //是否删除回车选中下一行的标识
        if (tiankafeiTableAttributeVO.isTableClearSelectNextRowFlag()) {
            tkfTable.getActionMap().getParent().remove("selectNextRowCell");
        }

        //表格头部标题集合
        List<String> tableHeaderTitleList = Lists.newArrayList();
        List<TableColumnDTO> tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();
        //组装表头数组集合
        for (int tableColumnIndex = 0, tableColumnLength = tableColumnList.size(); tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            tableHeaderTitleList.add(tableColumnList.get(tableColumnIndex).getHeader());
        }
        //设置表格模型
        DefaultTableModel tableDataModel = new DefaultTableModel(new Object[][]{}, tableHeaderTitleList.toArray());
        tkfTable.setModel(tableDataModel);
        //设置表格数据模型
        tiankafeiTableAttributeVO.setTableDataModel(tableDataModel);

        //获取表格头部对象
        JTableHeader tkfTableHeader = tkfTable.getTableHeader();
        //表格头部设置背景色
        tkfTableHeader.setBackground(tiankafeiTableAttributeVO.getTableGridLineColor());
        //表格头部设置前景色
        tkfTableHeader.setForeground(tiankafeiTableAttributeVO.getTableHeaderForegroundColor());
        //不可整列移动
        tkfTableHeader.setReorderingAllowed(false);
        //表格头部居中显示
        DefaultTableCellRenderer tableCellRenderer = (DefaultTableCellRenderer) tkfTableHeader.getDefaultRenderer();
        tableCellRenderer.setHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);

        //设置表格渲染
        TiankafeiTableCellRenderer tiankafeiTableCellRenderer = new TiankafeiTableCellRenderer(tkfTable);
        tkfTable.setDefaultRenderer(Object.class, tiankafeiTableCellRenderer);
        tkfTable.addMouseListener(tiankafeiTableCellRenderer);
        tkfTable.addMouseMotionListener(tiankafeiTableCellRenderer);

        return tkfTable;
    }

    /**
     * 初始化表格列渲染
     */
    public void initTableColumnModel() {
        tkfTable.initTableColumnModel();
    }

    /**
     * 获取表格数据集合
     *
     * @return 表格数据集合
     */
    public List<List<Object>> getDataListList() {
        List<TiankafeiTable> tiankafeiTableList = tiankafeiTableAttributeVO.getTiankafeiTableList();
        //更改选中行的值
        for (int i = 0, lem = tiankafeiTableList.size(); i < lem; i++) {
            TiankafeiTable tiankafeiTable = tiankafeiTableList.get(i);
            //表格对象
            TkfTable tkfTable = tiankafeiTable.getTkfTable();
            //表格属性对象
            TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tiankafeiTable.getTiankafeiTableAttributeVO();
            tiankafeiTableAttributeVO.getExportDataListList().clear();

            //表格数据集合
            List<List<Object>> dataListList = tiankafeiTableAttributeVO.getDataListList();
            //表格数据模型对象
            AbstractTableModel tableDataModel = tiankafeiTableAttributeVO.getTableDataModel();
            //分页对象
            PaginatedDTO tablePaginatedDTO = tiankafeiTable.getTiankafeiTablePageVO().getTablePaginatedDTO();
            //当前页
            int currentPage = tablePaginatedDTO.getCurrentPage();
            int rowCount = tableDataModel.getRowCount();
            int colCount = tableDataModel.getColumnCount();
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                boolean flag = true;
                if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
                    flag = tkfTable.getTableChooseColumnValue(rowIndex);
                }
                if (flag) {
                    int index = (currentPage - 1) * tablePaginatedDTO.getPageSize() + rowIndex;
                    //选中行的列数据集合
                    List<Object> dataList = dataListList.get(index);
                    for (int colIndex = 0; colIndex < colCount; colIndex++) {
                        //更改选中行的各列的值
                        Object object = tableDataModel.getValueAt(rowIndex, colIndex);
                        dataList.set(colIndex, object);
                    }
                    tiankafeiTableAttributeVO.getExportDataListList().add(dataList);
                }
            }
        }

        //最终要返回的数据集合
        List<List<Object>> endDataListList = Lists.newArrayList();
        //表格数据集合
        List<List<Object>> exportDataListList = tiankafeiTableList.get(0).getTiankafeiTableAttributeVO().getExportDataListList();
        endDataListList.addAll(exportDataListList);
        for (int tableIndex = 1, tableLength = tiankafeiTableList.size(); tableIndex < tableLength; tableIndex++) {
            //表格数据集合
            exportDataListList = tiankafeiTableList.get(tableIndex).getTiankafeiTableAttributeVO().getExportDataListList();
            for (int rowIndex = 0, rowLength = exportDataListList.size(); rowIndex < rowLength; rowIndex++) {
                List<Object> exportDataList = exportDataListList.get(rowIndex);
                endDataListList.get(rowIndex).addAll(exportDataList);
            }
        }
        return endDataListList;
    }

    /**
     * 填充表格数据
     *
     * @param pageDataListList 填充数据集合
     */
    public void fillTableData(List<List<Object>> pageDataListList) {
        tkfTable.fillTableData(pageDataListList);
    }

    /**
     * 获取自定义表格对象
     *
     * @return 自定义表格对象
     */
    public TkfTable getTkfTable() {
        return tkfTable;
    }

    /**
     * 设置自定义表格对象
     *
     * @param tkfTable 自定义表格对象
     */
    public void setTkfTable(TkfTable tkfTable) {
        this.tkfTable = tkfTable;
    }

    /**
     * 获取自定义表格属性对象
     *
     * @return 自定义表格属性对象
     */
    public TiankafeiTableAttributeVO getTiankafeiTableAttributeVO() {
        return tiankafeiTableAttributeVO;
    }

    /**
     * 设置自定义表格属性对象
     *
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     */
    public void setTiankafeiTableAttributeVO(TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        this.tiankafeiTableAttributeVO = tiankafeiTableAttributeVO;
    }

    /**
     * 获取自定义表格分页对象
     *
     * @return 自定义表格分页对象
     */
    public TiankafeiTablePageVO getTiankafeiTablePageVO() {
        return tiankafeiTablePageVO;
    }

    /**
     * 设置自定义表格分页对象
     *
     * @param tiankafeiTablePageVO 自定义表格分页对象
     */
    public void setTiankafeiTablePageVO(TiankafeiTablePageVO tiankafeiTablePageVO) {
        this.tiankafeiTablePageVO = tiankafeiTablePageVO;
    }

}
