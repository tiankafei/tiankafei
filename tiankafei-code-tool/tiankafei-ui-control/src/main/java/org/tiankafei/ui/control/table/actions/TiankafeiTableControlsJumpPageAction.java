package org.tiankafei.ui.control.table.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.common.dto.PaginatedDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfComboBox;

/**
 * 表格控件跳转事件
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsJumpPageAction extends AbstractTiankafeiActionListener {

    /**
     * 表格控件分页抽象类
     */
    private AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil;

    /**
     * 表格对象集合
     */
    private List<TiankafeiTable> tiankafeiTableList;

    /**
     * 表格分页对象
     */
    private TiankafeiTablePageVO tiankafeiTablePageVO;

    /**
     * 跳转页下拉框
     */
    private TkfComboBox<Integer> jumpPageTkfComboBox;

    /**
     * 构造表格控件跳转事件对象
     *
     * @param abstractTiankafeiTableControlsPageUtil 分页抽象类
     * @param tiankafeiTableList                     表格对象集合
     * @param tiankafeiTablePageVO                   表格分页对象
     * @param jumpPageTkfComboBox                    跳转页下拉框
     */
    public TiankafeiTableControlsJumpPageAction(AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil, List<TiankafeiTable> tiankafeiTableList, TiankafeiTablePageVO tiankafeiTablePageVO, TkfComboBox<Integer> jumpPageTkfComboBox) {
        this.abstractTiankafeiTableControlsPageUtil = abstractTiankafeiTableControlsPageUtil;
        this.tiankafeiTableList = tiankafeiTableList;
        this.tiankafeiTablePageVO = tiankafeiTablePageVO;
        this.jumpPageTkfComboBox = jumpPageTkfComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PaginatedDTO tablePaginatedDTO = tiankafeiTablePageVO.getTablePaginatedDTO();
        int currentPage = jumpPageTkfComboBox.getSelectedIndex() + 1;
        tablePaginatedDTO.setCurrentPage(currentPage);
        abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePageData(tiankafeiTableList, tiankafeiTablePageVO);
    }

}
