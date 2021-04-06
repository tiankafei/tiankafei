package org.tiankafei.ui.control.abstractinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.common.dto.PaginatedDTO;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsExportPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsSelectAllPageAction;
import org.tiankafei.ui.control.table.actions.TiankafeiTableControlsUnSelectPageAction;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 表格控件分页抽象类
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiTableControlsPageUtil {

    /**
     * 左侧分页标签
     */
    public TkfLabel tablePageTkfLabel;

    /**
     * 初始化表格分页面板
     *
     * @param tiankafeiTableAttributeVO 表格属性对象
     * @param tiankafeiTablePageVO      自定义表格分页对象
     * @param tiankafeiTableList        表格对象集合
     * @return 表格分页面板
     */
    public TkfPanel initTiankafeiTablePagePanel(TiankafeiTableAttributeVO tiankafeiTableAttributeVO, TiankafeiTablePageVO tiankafeiTablePageVO, List<TiankafeiTable> tiankafeiTableList) {
        TiankafeiPanel pageTiankafeiPanel = new TiankafeiPanel();
        TkfPanel pageTkfPanel = pageTiankafeiPanel.initTiankafeiPanel();

        //左侧分页标签
        TiankafeiLabel tablePageTiankafeiLabel = new TiankafeiLabel();
        tablePageTiankafeiLabel.setWidth(160);
        tablePageTiankafeiLabel.setForegroundColor(Color.RED);
        tablePageTkfLabel = tablePageTiankafeiLabel.initTiankafeiLabel();
        pageTkfPanel.add(tablePageTkfLabel, BorderLayout.WEST);

        //初始化表格分页面板
        initTiankafeiTablePagePanel(tiankafeiTablePageVO, pageTkfPanel, tiankafeiTableList);

        //初始化表格操作按钮面板
        TkfPanel buttonTkfPanel = initTiankafeiTableButtonPanel(tiankafeiTableAttributeVO, tiankafeiTableList);
        pageTkfPanel.add(buttonTkfPanel, BorderLayout.SOUTH);

        return pageTkfPanel;
    }

    /**
     * 初始化表格分页面板
     *
     * @param tiankafeiTablePageVO 表格分页对象
     * @param pageTkfPanel         表格分页面板
     * @param tiankafeiTableList   表格对象集合
     */
    public abstract void initTiankafeiTablePagePanel(TiankafeiTablePageVO tiankafeiTablePageVO, TkfPanel pageTkfPanel, List<TiankafeiTable> tiankafeiTableList);

    /**
     * 初始化表格分页面板的数据
     *
     * @param tiankafeiTableList   表格对象集合
     * @param tiankafeiTablePageVO 表格分页对象
     */
    public void initTiankafeiTablePageData(List<TiankafeiTable> tiankafeiTableList, TiankafeiTablePageVO tiankafeiTablePageVO) {
        for (int i = 0, lem = tiankafeiTableList.size(); i < lem; i++) {
            TiankafeiTable tiankafeiTable = tiankafeiTableList.get(i);
            //自定义表格属性对象
            TiankafeiTableAttributeVO tiankafeiTableAttributeVO = tiankafeiTable.getTiankafeiTableAttributeVO();
            //表格数据集合
            List<List<Object>> dataListList = tiankafeiTableAttributeVO.getDataListList();
            if (CollectionUtils.isNotEmpty(dataListList)) {
                //初始化分页面板的数据集合
                List<List<Object>> pageDataListList = initTiankafeiTablePageDataList(tiankafeiTablePageVO.getTablePaginatedDTO(), dataListList);
                tiankafeiTable.fillTableData(pageDataListList);
            }
        }
        //初始化分页面板左侧标签的显示信息
        String pageInfo = initTiankafeiTablePageTkfLabel(tiankafeiTablePageVO.getTablePaginatedDTO());
        tablePageTkfLabel.setText(pageInfo);
        //初始化表格分页面板的数据
        initTiankafeiTablePageData(tiankafeiTablePageVO);
    }

    /**
     * 初始化表格分页面板的数据
     *
     * @param tiankafeiTablePageVO 表格分页对象
     */
    public abstract void initTiankafeiTablePageData(TiankafeiTablePageVO tiankafeiTablePageVO);

    /**
     * 初始化分页面板左侧标签的显示信息
     *
     * @param tablePaginatedDTO 分页对象
     * @return 分页面板左侧标签的显示信息
     */
    public abstract String initTiankafeiTablePageTkfLabel(PaginatedDTO tablePaginatedDTO);

    /**
     * 初始化分页面板的数据集合
     *
     * @param tablePaginatedDTO 分页对象
     * @param dataListList      所有的数据集合
     * @return 分页面板的数据集合
     */
    public abstract List<List<Object>> initTiankafeiTablePageDataList(PaginatedDTO tablePaginatedDTO, List<List<Object>> dataListList);

    /**
     * 初始化表格操作按钮面板
     *
     * @param tiankafeiTableAttributeVO 表格属性对象
     * @param tiankafeiTableList        表格对象集合
     * @return 表格操作按钮面板
     */
    private TkfPanel initTiankafeiTableButtonPanel(TiankafeiTableAttributeVO tiankafeiTableAttributeVO, List<TiankafeiTable> tiankafeiTableList) {
        TiankafeiPanel buttonTiankafeiPanel = new TiankafeiPanel();
        TkfPanel buttonTkfPanel = buttonTiankafeiPanel.initTiankafeiPanel();
        buttonTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //表格支持选择，且是复选框的时候
        if (tiankafeiTableAttributeVO.isTableChooseFlag()) {
            if (TiankafeiDesignerConstants.CHOOSE_TYPE_CHECKBOX == tiankafeiTableAttributeVO.getTableChooseType()) {
                //全选按钮
                TiankafeiButton selectAllTiankafeiButton = new TiankafeiButton();
                selectAllTiankafeiButton.setText("本页全选");
                TkfButton selectAllTkfButton = selectAllTiankafeiButton.initTiankafeiButton();
                selectAllTkfButton.addActionListener(new TiankafeiTableControlsSelectAllPageAction(tiankafeiTableList));
                buttonTkfPanel.add(selectAllTkfButton);

                //反选按钮
                TiankafeiButton unselectedTiankafeiButton = new TiankafeiButton();
                unselectedTiankafeiButton.setText("反选");
                TkfButton unselectedTkfButton = unselectedTiankafeiButton.initTiankafeiButton();
                unselectedTkfButton.addActionListener(new TiankafeiTableControlsUnSelectPageAction(tiankafeiTableList));
                buttonTkfPanel.add(unselectedTkfButton);
            }
        }

        if (tiankafeiTableAttributeVO.isTableExportFlag()) {
            //导出按钮
            TiankafeiButton exportTiankafeiButton = new TiankafeiButton();
            exportTiankafeiButton.setText("导出");
            TkfButton exportTkfButton = exportTiankafeiButton.initTiankafeiButton();
            exportTkfButton.addActionListener(new TiankafeiTableControlsExportPageAction(tiankafeiTableList));
            buttonTkfPanel.add(exportTkfButton);
        }

        return buttonTkfPanel;
    }

}
