package org.tiankafei.ui.control.condition;

import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiHandleConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;

/**
 * 自定义过滤条件并且操作抽象对象
 *
 * @author tiankafei1
 */
public class TiankafeiAndHandleConditionDTO extends AbstractTiankafeiHandleConditionDTO {

    private static final long serialVersionUID = -1078213453544980303L;

    @Override
    public String getHandleType() {
        return TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_AND;
    }

    @Override
    public String toString() {
        return "并且";
    }

}
