package org.tiankafei.ui.control.condition;

import org.tiankafei.common.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义为空条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiNullConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = -5346777067010328704L;

    /**
     * 构造自定义为空条件对象
     */
    public TiankafeiNullConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_NULL_CONDITION);
    }

    @Override
    public void handleTiankafeiCondition(TkfPanel conditionTkfPanel, int number, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        //删除
        deleteTiankafeiCondition(conditionTkfPanel, number);
    }

    @Override
    public String setAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO, int number) {
        //为空不需要赋值
        return null;
    }

    @Override
    public void clearAbstractTiankafeiConditionValue(TkfPanel tempTkfPanel, int number) {
        //不做任何处理
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        StringBuffer sqlBuffer = createSqlBuffer().append(" ").append(TiankafeiConditionConstants.TIANKAFEI_CONDITION_COLUMN).append(" IS NULL ");

        return new SqlParamDTO(sqlBuffer.toString());
    }

    @Override
    public String toString() {
        return "为空";
    }

}
