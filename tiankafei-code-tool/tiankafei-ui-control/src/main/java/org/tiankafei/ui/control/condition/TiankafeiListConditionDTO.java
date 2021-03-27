package org.tiankafei.ui.control.condition;

import java.util.List;
import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义列表条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiListConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -3379933288537747364L;

    /**
     * 构造自定义列表条件对象
     */
    public TiankafeiListConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_LIST_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer();
        List<Object> paramList = createParamList();

        String[] array = tiankafeiCustomConditionDTO.getValue().toString().split(",");
        sqlBuffer.append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" IN (  ");
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
        return "列表";
    }

}
