package org.tiankafei.ui.control.condition;

import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiHandleConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;

/**
 * 自定义过滤条件或者操作抽象对象
 *
 * @author tiankafei1
 */
public class TiankafeiOrHandleConditionDTO extends AbstractTiankafeiHandleConditionDTO {

    private static final long serialVersionUID = 4389933275831090236L;

    @Override
    public String getHandleType() {
        return TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_OR;
    }

    @Override
    public String toString() {
        return "或者";
    }

}
