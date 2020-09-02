package org.tiankafei.ui.control.condition.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.control.TiankafeiConditionControls;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义过滤条件删除分组事件
 *
 * @author tiankafei1
 */
public class TiankafeiDeleteGroupAction extends AbstractTiankafeiActionListener {

    /**
     * 自定义过滤条件控件对象
     */
    private TiankafeiConditionControls tiankafeiConditionControls;

    /**
     * 新增条件面板
     */
    private TkfPanel tkfPanel;

    /**
     * 构造自定义过滤条件删除分组事件
     *
     * @param tiankafeiConditionControls 自定义过滤条件控件对象
     * @param tkfPanel                   新增条件面板
     */
    public TiankafeiDeleteGroupAction(TiankafeiConditionControls tiankafeiConditionControls, TkfPanel tkfPanel) {
        this.tiankafeiConditionControls = tiankafeiConditionControls;
        this.tkfPanel = tkfPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiankafeiConditionControls.deleteGroupPanel(tkfPanel);
    }

}
