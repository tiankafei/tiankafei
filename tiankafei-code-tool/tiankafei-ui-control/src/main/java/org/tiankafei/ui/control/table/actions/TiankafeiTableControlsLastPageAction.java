package org.tiankafei.ui.control.table.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.base.dto.PaginatedDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;

/**
 * 表格控件最后一页事件
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsLastPageAction extends AbstractTiankafeiActionListener {

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
     * 构造表格控件最后一页事件对象
     *
     * @param abstractTiankafeiTableControlsPageUtil 分页抽象类
     * @param tiankafeiTableList                     表格对象集合
     * @param tiankafeiTablePageVO                   表格分页对象
     */
    public TiankafeiTableControlsLastPageAction(AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil, List<TiankafeiTable> tiankafeiTableList, TiankafeiTablePageVO tiankafeiTablePageVO) {
        this.abstractTiankafeiTableControlsPageUtil = abstractTiankafeiTableControlsPageUtil;
        this.tiankafeiTableList = tiankafeiTableList;
        this.tiankafeiTablePageVO = tiankafeiTablePageVO;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PaginatedDTO tablePaginatedDTO = tiankafeiTablePageVO.getTablePaginatedDTO();
        int pageCount = tablePaginatedDTO.getPageCount();
        tablePaginatedDTO.setCurrentPage(pageCount);
        abstractTiankafeiTableControlsPageUtil.initTiankafeiTablePageData(tiankafeiTableList, tiankafeiTablePageVO);
    }

}
