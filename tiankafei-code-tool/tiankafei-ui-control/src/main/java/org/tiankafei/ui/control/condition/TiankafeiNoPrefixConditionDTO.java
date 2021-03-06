package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义非前缀条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiNoPrefixConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 7549019824838499981L;

    /**
     * 构造自定义非前缀条件对象
     */
    public TiankafeiNoPrefixConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_NO_PREFIX_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" NOT LIKE ? ");
        List<Object> paramList = addParam("%" + tiankafeiCustomConditionDTO.getValue());

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "非前缀";
    }

}
