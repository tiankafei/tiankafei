package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义小于等于条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiLessThanEqualConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 1225613392550287413L;

    /**
     * 构造自定义小于等于条件对象
     */
    public TiankafeiLessThanEqualConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_LESS_THAN_EQUAL_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" <= ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "小于等于";
    }

}
