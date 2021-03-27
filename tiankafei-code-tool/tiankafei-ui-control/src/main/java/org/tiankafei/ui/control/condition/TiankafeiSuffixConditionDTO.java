package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义后缀条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiSuffixConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -7334222776955342124L;

    /**
     * 构造自定义后缀条件对象
     */
    public TiankafeiSuffixConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_SUFFIX_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" LIKE ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue() + "%");

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "后缀";
    }

}
