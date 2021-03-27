package org.tiankafei.ui.control.choose;

import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseAllAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseBottomAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseDownAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseTopAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiChooseUpAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiUnChooseAction;
import org.tiankafei.ui.control.choose.actions.TiankafeiUnChooseAllAction;
import org.tiankafei.ui.control.constants.TiankafeiChooseConstants;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiChooseAction;
import org.tiankafei.ui.design.modelsui.TkfList;

/**
 * @author 甜咖啡
 */
public class TiankafeiChooseFactory {

    public static AbstractTiankafeiChooseAction getAbstractTiankafeiChooseAction(String text, TkfList leftTkfList, TkfList rightTkfList) {
        AbstractTiankafeiChooseAction abstractTiankafeiChooseAction = null;
        if (TiankafeiChooseConstants.CHOOSE.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.UN_CHOOSE.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiUnChooseAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.CHOOSE_ALL.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseAllAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.UN_CHOOSE_ALL.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiUnChooseAllAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.CHOOSE_TOP.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseTopAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.CHOOSE_UP.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseUpAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.CHOOSE_DOWN.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseDownAction(leftTkfList, rightTkfList);
        } else if (TiankafeiChooseConstants.CHOOSE_BOTTOM.equals(text)) {
            abstractTiankafeiChooseAction = new TiankafeiChooseBottomAction(leftTkfList, rightTkfList);
        } else {
            throw new CommonException("不支持传入的参数对应的事件，请确认！");
        }
        return abstractTiankafeiChooseAction;
    }

}
