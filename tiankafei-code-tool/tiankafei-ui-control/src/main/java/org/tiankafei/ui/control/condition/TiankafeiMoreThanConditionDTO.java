package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义大于条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiMoreThanConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -6588986907035608788L;

    /**
     * 构造自定义大于条件对象
     */
    public TiankafeiMoreThanConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_MORE_THAN_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" > ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "大于";
    }

}
