package org.tiankafei.ui.control.dto;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiHandleConditionDTO;

/**
 * 自定义组合条件对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
public class TiankafeiAssembleConditionDTO implements Serializable {

    private static final long serialVersionUID = 8095493396815993702L;

    /**
     * 自定义过滤条件操作抽象对象
     */
    private AbstractTiankafeiHandleConditionDTO abstractTiankafeiHandleConditionDTO;

    /**
     * 自定义过滤条件操作抽象对象索引位置
     */
    private Integer abstractTiankafeiHandleConditionIndex;

    /**
     * 自定义条件集合
     */
    private List<TiankafeiCustomConditionDTO> tiankafeiCustomConditionList;

    /**
     * 自定义组合条件对象集合
     */
    private List<TiankafeiAssembleConditionDTO> tiankafeiAssembleConditionList;

    /**
     * SQL参数对象
     */
    private SqlParamDTO sqlParamDTO;

    /**
     * 构造自定义组合条件对象
     */
    public TiankafeiAssembleConditionDTO() {
        abstractTiankafeiHandleConditionIndex = -1;
        tiankafeiCustomConditionList = Lists.newArrayList();
        tiankafeiAssembleConditionList = Lists.newArrayList();
        sqlParamDTO = new SqlParamDTO();
    }

}
