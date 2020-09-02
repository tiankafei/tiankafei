package org.tiankafei.ui.control;

import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiTableControlsPageUtil;
import org.tiankafei.ui.control.table.TiankafeiTableControlsNoPageUtil;
import org.tiankafei.ui.control.table.TiankafeiTableControlsPageUtil;

/**
 * 自定义控件UI工厂类
 *
 * @author tiankafei1
 */
public class TiankafeiControlsUiFactory {

    public static AbstractTiankafeiTableControlsPageUtil getAbstractTiankafeiTableControlsPageUtil(boolean tablePageFlag) {
        AbstractTiankafeiTableControlsPageUtil abstractTiankafeiTableControlsPageUtil = null;

        if (tablePageFlag) {
            abstractTiankafeiTableControlsPageUtil = new TiankafeiTableControlsPageUtil();
        } else {
            abstractTiankafeiTableControlsPageUtil = new TiankafeiTableControlsNoPageUtil();
        }

        return abstractTiankafeiTableControlsPageUtil;
    }

}
