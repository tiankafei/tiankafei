package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义非列表条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiNoListConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 7667845647672979253L;

    /**
     * 构造自定义非列表条件对象
     */
    public TiankafeiNoListConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_NO_LIST_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer();
        List<Object> paramList = createParamList();

        String[] array = tiankafeiCustomConditionDTO.getValue().toString().split(",");
        sqlBuffer.append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" NOT IN (  ");
        for (int i = 0, lem = array.length; i < lem; i++) {
            sqlBuffer.append("?");
            if (i != lem - 1) {
                sqlBuffer.append(", ");
            }
            paramList.add(array[i]);
        }
        sqlBuffer.append(" ) ");

        return new SqlParamDTO(sqlBuffer.toString(), paramList);
    }

    @Override
    public String toString() {
        return "非列表";
    }

}
