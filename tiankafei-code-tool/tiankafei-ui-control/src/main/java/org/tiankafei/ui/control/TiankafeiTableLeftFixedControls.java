package org.tiankafei.ui.control;

import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.DataStreamUtil;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;
import org.tiankafei.ui.design.modelsui.TkfTable;

/**
 * 自定义表格对象控件
 *
 * @author tiankafei
 */
public class TiankafeiTableLeftFixedControls extends TiankafeiDesignerVO {

    /**
     * 固定自定义表格对象
     */
    private TiankafeiTable fixedTiankafeiTable;

    /**
     * 滚动自定义表格对象
     */
    private TiankafeiTable scrollTiankafeiTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 自定义表格分页对象
     */
    private TiankafeiTablePageVO tiankafeiTablePageVO;

    /**
     * 固定列的列号(左侧固定)
     */
    private int fixedLeftColumnIndex;

    /**
     * 构造自定义表格对象控件
     */
    public TiankafeiTableLeftFixedControls() {
        fixedTiankafeiTable = new TiankafeiTable();
        scrollTiankafeiTable = new TiankafeiTable();
        tiankafeiTableAttributeVO = new TiankafeiTableAttributeVO();
        tiankafeiTablePageVO = new TiankafeiTablePageVO();
        fixedLeftColumnIndex = 0;
    }

    /**
     * 初始化放置表格对象的面板
     *
     * @return 放置表格对象的面板
     * @throws BaseException 自定义异常
     */
    public TkfPanel initTiankafeiTablePanel() throws BaseException {
        AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil = TiankafeiControlsUiFactory.getAbstractTiankafeiTableControlsPageUtil(tiankafeiTableAttributeVO.isTablePageFlag());
        //表格集合新增对象
        List<TiankafeiTable> tiankafeiTableList = Lists.newArrayList();
        tiankafeiTableList.add(fixedTiankafeiTable);
        tiankafeiTableList.add(scrollTiankafeiTable);

        //表格大面板
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        TkfPanel tablePanel = tiankafeiPanel.initTiankafeiPanel();

        //拷贝表格属性对象
        TiankafeiTableAttributeVO fixedTiankafeiTableAttributeVO = (TiankafeiTableAttributeVO) DataStreamUtil.copyObject(tiankafeiTableAttributeVO);
        fixedTiankafeiTableAttributeVO.setTiankafeiTableList(tiankafeiTableList);
        //固定表格对象的数据列以及数据集合
        int beginIndex = 0;
        int endIndex = fixedLeftColumnIndex;
        List<TableColumnDTO> fixedTableColumnList = getTableColumnList(tiankafeiTableAttributeVO.getTableColumnList(), beginIndex, endIndex);
        List<List<Object>> fixedDataListList = getDataListList(tiankafeiTableAttributeVO.getDataListList(), beginIndex, endIndex);
        fixedTiankafeiTableAttributeVO.setTableColumnList(fixedTableColumnList);
        fixedTiankafeiTableAttributeVO.setDataListList(fixedDataListList);

        //拷贝表格属性对象
        TiankafeiTableAttributeVO scrollTiankafeiTableAttributeVO = (TiankafeiTableAttributeVO) DataStreamUtil.copyObject(tiankafeiTableAttributeVO);
        scrollTiankafeiTableAttributeVO.setTiankafeiTableList(tiankafeiTableList);
        //滚动表格对象的数据列以及数据集合
        beginIndex = fixedLeftColumnIndex;
        endIndex = tiankafeiTableAttributeVO.getTableColumnList().size();
        List<TableColumnDTO> scrollTableColumnList = getTableColumnList(tiankafeiTableAttributeVO.getTableColumnList(), beginIndex, endIndex);
        List<List<Object>> scrollDataListList = getDataListList(tiankafeiTableAttributeVO.getDataListList(), beginIndex, endIndex);
        scrollTiankafeiTableAttributeVO.setTableColumnList(scrollTableColumnList);
        scrollTiankafeiTableAttributeVO.setDataListList(scrollDataListList);

        //设置固定列表格自定义表格属性对象
        fixedTiankafeiTable.setTiankafeiTableAttributeVO(fixedTiankafeiTableAttributeVO);
        //设置固定列表格自定义表格分页对象
        fixedTiankafeiTable.setTiankafeiTablePageVO(tiankafeiTablePageVO);
        //初始化固定列表格对象
        final TkfTable fixedTkfTable = fixedTiankafeiTable.initTiankafeiTable();

        //设置滚动列表格自定义表格属性对象
        scrollTiankafeiTable.setTiankafeiTableAttributeVO(scrollTiankafeiTableAttributeVO);
        //设置滚动列表格自定义表格分页对象
        scrollTiankafeiTable.setTiankafeiTablePageVO(tiankafeiTablePageVO);
        //初始化滚动列表格对象
        final TkfTable scrollTkfTable = scrollTiankafeiTable.initTiankafeiTable();

        fixedTkfTable.getTkfTableList().add(scrollTkfTable);
        scrollTkfTable.getTkfTableList().add(fixedTkfTable);

        //初始化表格分页面板
        TkfPanel pageTkfPanel = abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePagePanel(tiankafeiTableAttributeVO, tiankafeiTablePageVO, tiankafeiTableList);
        tablePanel.add(pageTkfPanel, BorderLayout.SOUTH);
        //初始化固定列表格列渲染
        fixedTiankafeiTable.initTableColumnModel();
        //初始化滚动列表格列渲染
        scrollTiankafeiTable.initTableColumnModel();

        //初始化表格分页面板的数据
        abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePageData(tiankafeiTableList, tiankafeiTablePageVO);

        JViewport tkfFixedViewport = new JViewport();
        tkfFixedViewport.setView(fixedTkfTable);
        tkfFixedViewport.setPreferredSize(fixedTkfTable.getPreferredSize());

        TiankafeiScrollPane tiankafeiScrollPane = new TiankafeiScrollPane(scrollTkfTable);
        TkfScrollPane tkfScrollPane = tiankafeiScrollPane.initTiankafeiScrollPane();
        tkfScrollPane.setRowHeaderView(tkfFixedViewport);
        tkfScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTkfTable.getTableHeader());
        tablePanel.add(tkfScrollPane, BorderLayout.CENTER);
        initFixedTableListSelectionListener(fixedTkfTable, scrollTkfTable);

        return tablePanel;
    }

    /**
     * 初始化固定表格选择行监听事件
     *
     * @param fixedTkfTable
     * @param scrollTkfTable
     */
    private void initFixedTableListSelectionListener(TkfTable fixedTkfTable, TkfTable scrollTkfTable) {
        fixedTkfTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int tkfFixedLeftTableRowIndex = fixedTkfTable.getSelectedRow();
                if (tkfFixedLeftTableRowIndex != -1) {
                    scrollTkfTable.setRowSelectionInterval(tkfFixedLeftTableRowIndex, tkfFixedLeftTableRowIndex);
                }
            }
        });
        scrollTkfTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int tkfScrollTableRowIndex = scrollTkfTable.getSelectedRow();
                if (tkfScrollTableRowIndex != -1) {
                    fixedTkfTable.setRowSelectionInterval(tkfScrollTableRowIndex, tkfScrollTableRowIndex);
                }
            }
        });
    }

    /**
     * 获取分表之后的表格列集合
     *
     * @param tableColumnList 表格列集合
     * @param beginIndex      开始位置
     * @param endIndex        结束位置
     * @return 分表之后的表格列集合
     */
    private List<TableColumnDTO> getTableColumnList(List<TableColumnDTO> tableColumnList, int beginIndex, int endIndex) {
        List<TableColumnDTO> endTableColumnList = Lists.newArrayList();
        for (int colIndex = beginIndex; colIndex < endIndex; colIndex++) {
            endTableColumnList.add(tableColumnList.get(colIndex));
        }
        return endTableColumnList;
    }

    /**
     * 获取分表之后的表格数据集合
     *
     * @param dataListList 表格数据集合
     * @param beginIndex   开始位置
     * @param endIndex     结束位置
     * @return 分表之后的表格数据集合
     */
    private List<List<Object>> getDataListList(List<List<Object>> dataListList, int beginIndex, int endIndex) {
        List<List<Object>> endDataListList = Lists.newArrayList();
        for (int rowIndex = 0, rowLength = dataListList.size(); rowIndex < rowLength; rowIndex++) {
            List<Object> endColumnList = Lists.newArrayList();
            List<Object> dataList = dataListList.get(rowIndex);
            for (int colIndex = beginIndex; colIndex < endIndex; colIndex++) {
                endColumnList.add(dataList.get(colIndex));
            }
            endDataListList.add(endColumnList);
        }
        return endDataListList;
    }

    /**
     * 获取表格数据集合
     *
     * @return 表格数据集合
     */
    public List<List<Object>> getDataListList() {
        return fixedTiankafeiTable.getDataListList();
    }

    /**
     * 获取固定自定义表格对象
     *
     * @return 固定自定义表格对象
     */
    public TiankafeiTable getFixedTiankafeiTable() {
        return fixedTiankafeiTable;
    }

    /**
     * 设置固定自定义表格对象
     *
     * @param fixedTiankafeiTable 固定自定义表格对象
     */
    public void setFixedTiankafeiTable(TiankafeiTable fixedTiankafeiTable) {
        this.fixedTiankafeiTable = fixedTiankafeiTable;
    }

    /**
     * 获取滚动自定义表格对象
     *
     * @return 滚动自定义表格对象
     */
    public TiankafeiTable getScrollTiankafeiTable() {
        return scrollTiankafeiTable;
    }

    /**
     * 设置滚动自定义表格对象
     *
     * @param scrollTiankafeiTable 滚动自定义表格对象
     */
    public void setScrollTiankafeiTable(TiankafeiTable scrollTiankafeiTable) {
        this.scrollTiankafeiTable = scrollTiankafeiTable;
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

    /**
     * 获取固定列的列号(左侧固定)
     *
     * @return 固定列的列号(左侧固定)
     */
    public int getFixedLeftColumnIndex() {
        return fixedLeftColumnIndex;
    }

    /**
     * 设置固定列的列号(左侧固定)
     *
     * @param fixedLeftColumnIndex 固定列的列号(左侧固定)
     */
    public void setFixedLeftColumnIndex(int fixedLeftColumnIndex) {
        this.fixedLeftColumnIndex = fixedLeftColumnIndex;
    }

}
