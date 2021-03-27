package org.tiankafei.ui.control.table;

import java.util.List;
import org.tiankafei.common.dto.PaginatedDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.design.againsui.TiankafeiTable;
import org.tiankafei.ui.design.models.TiankafeiTablePageVO;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 表格控件不分页抽象类
 *
 * @author tiankafei1
 */
public class TiankafeiTableControlsNoPageUtil extends AbstractTiankafeiTableControlsPageUtil {

    @Override
    public void initTiankafeiTablePagePanel(TiankafeiTablePageVO tiankafeiTablePageVO, TkfPanel pageTkfPanel, List<TiankafeiTable> tiankafeiTableList) {

    }

    @Override
    public void initTiankafeiTablePageData(TiankafeiTablePageVO tiankafeiTablePageVO) {

    }

    @Override
    public String initTiankafeiTablePageTkfLabel(PaginatedDTO tablePaginatedDTO) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("共1页，").append(tablePaginatedDTO.getRecordCount()).append("条记录");
        return buffer.toString();
    }

    @Override
    public List<List<Object>> initTiankafeiTablePageDataList(PaginatedDTO tablePaginatedDTO, List<List<Object>> dataListList) {
        return dataListList;
    }

}
