package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义不等于条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiNoEqualConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -1964354875931681841L;

    /**
     * 构造自定义不等于条件对象
     */
    public TiankafeiNoEqualConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_NO_EQUAL_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" <> ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "不等于";
    }

}
