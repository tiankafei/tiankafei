package org.tiankafei.ui.control.choose.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiChooseAction;
import org.tiankafei.ui.design.modelsui.TkfList;

/**
 * 上移置顶事件
 *
 * @author 甜咖啡
 */
public class TiankafeiChooseTopAction extends AbstractTiankafeiChooseAction {

    @SuppressWarnings("rawtypes")
    public TiankafeiChooseTopAction(TkfList leftTkfList, TkfList rightTkfList) {
        super(leftTkfList, rightTkfList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}
