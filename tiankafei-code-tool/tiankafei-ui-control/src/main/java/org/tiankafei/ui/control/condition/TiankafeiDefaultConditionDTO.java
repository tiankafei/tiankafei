package org.tiankafei.ui.control.condition;

import org.tiankafei.base.dto.SqlParamDTO;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;

/**
 * 自定义请选择条件对象
 *
 * @author tiankafei1
 */
public class TiankafeiDefaultConditionDTO extends AbstractTiankafeiConditionDTO {

    private static final long serialVersionUID = 1728637198846017057L;

    /**
     * 构造自定义请选择条件对象
     */
    public TiankafeiDefaultConditionDTO() {
        setCondition(TiankafeiConditionConstants.TIANKAFEI_DEFAULT_CONDITION);
    }

    @Override
    public SqlParamDTO getAbstractTiankafeiConditionSql(TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO) {
        //请选择

        return null;
    }

    @Override
    public String toString() {
        return "请选择";
    }

}
