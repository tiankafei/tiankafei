package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义非后缀条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiNoSuffixConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -1614225613578966461L;

    /**
     * 构造自定义非后缀条件对象
     */
    public TiankafeiNoSuffixConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_NO_SUFFIX_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" NOT LIKE ? ");
        List<Object> paramList = addParam(tiankafeiCustomConditionDTO.getValue() + "%");

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "非后缀";
    }

}
