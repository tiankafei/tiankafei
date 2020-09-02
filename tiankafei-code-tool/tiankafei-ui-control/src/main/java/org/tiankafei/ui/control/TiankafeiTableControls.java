package org.tiankafei.ui.control;

import java.awt.BorderLayout;
import java.util.List;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
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
public class TiankafeiTableControls extends TiankafeiDesignerVO {

    /**
     * 自定义表格对象
     */
    private TiankafeiTable tiankafeiTable;

    /**
     * 自定义表格属性对象
     */
    private TiankafeiTableAttributeVO tiankafeiTableAttributeVO;

    /**
     * 自定义表格分页对象
     */
    private TiankafeiTablePageVO tiankafeiTablePageVO;

    /**
     * 构造自定义表格对象控件
     */
    public TiankafeiTableControls() {
        tiankafeiTable = new TiankafeiTable();
        tiankafeiTableAttributeVO = new TiankafeiTableAttributeVO();
        tiankafeiTablePageVO = new TiankafeiTablePageVO();
    }

    /**
     * 初始化放置表格对象的面板
     *
     * @return 放置表格对象的面板
     * @throws BaseException 自定义异常
     */
    public TkfPanel initTiankafeiTablePanel() throws BaseException {
        //表格对象集合
        List<TiankafeiTable> tiankafeiTableList = tiankafeiTableAttributeVO.getTiankafeiTableList();
        tiankafeiTableList.add(tiankafeiTable);

        //表格大面板
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        TkfPanel tablePanel = tiankafeiPanel.initTiankafeiPanel();
        //设置自定义表格属性对象
        tiankafeiTable.setTiankafeiTableAttributeVO(tiankafeiTableAttributeVO);
        //设置自定义表格分页对象
        tiankafeiTable.setTiankafeiTablePageVO(tiankafeiTablePageVO);
        //初始化表格对象
        TkfTable tkfTable = tiankafeiTable.initTiankafeiTable();
        //初始化表格列渲染
        tiankafeiTable.initTableColumnModel();

        //表格滚动面板
        TiankafeiScrollPane tiankafeiScrollPane = new TiankafeiScrollPane(tkfTable);
        TkfScrollPane tkfScrollPane = tiankafeiScrollPane.initTiankafeiScrollPane();
        tablePanel.add(tkfScrollPane, BorderLayout.CENTER);

        AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil = TiankafeiControlsUiFactory.getAbstractTiankafeiTableControlsPageUtil(tiankafeiTableAttributeVO.isTablePageFlag());
        //初始化表格分页面板
        TkfPanel pageTkfPanel = abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePagePanel(tiankafeiTableAttributeVO, tiankafeiTablePageVO, tiankafeiTableList);
        tablePanel.add(pageTkfPanel, BorderLayout.SOUTH);
        //初始化表格分页面板的数据
        abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePageData(tiankafeiTableList, tiankafeiTablePageVO);

        return tablePanel;
    }

    /**
     * 获取表格数据集合
     *
     * @return 表格数据集合
     */
    public List<List<Object>> getDataListList() {
        return tiankafeiTable.getDataListList();
    }

    /**
     * 获取自定义表格对象
     *
     * @return 自定义表格对象
     */
    public TiankafeiTable getTiankafeiTable() {
        return tiankafeiTable;
    }

    /**
     * 设置自定义表格对象
     *
     * @param tiankafeiTable 自定义表格对象
     */
    public void setTiankafeiTable(TiankafeiTable tiankafeiTable) {
        this.tiankafeiTable = tiankafeiTable;
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
