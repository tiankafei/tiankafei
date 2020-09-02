package org.tiankafei.ui.control.condition.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.control.TiankafeiConditionControls;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义过滤条件删除条件事件
 *
 * @author tiankafei1
 */
public class TiankafeiDeleteConditionAction extends AbstractTiankafeiActionListener {

    /**
     * 自定义过滤条件控件对象
     */
    private TiankafeiConditionControls tiankafeiConditionControls;

    /**
     * 新增条件面板
     */
    private TkfPanel conditionTkfPanel;

    /**
     * 构造自定义过滤条件删除条件事件
     *
     * @param tiankafeiConditionControls 自定义过滤条件控件对象
     * @param conditionTkfPanel          新增条件面板
     */
    public TiankafeiDeleteConditionAction(TiankafeiConditionControls tiankafeiConditionControls, TkfPanel conditionTkfPanel) {
        this.tiankafeiConditionControls = tiankafeiConditionControls;
        this.conditionTkfPanel = conditionTkfPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiankafeiConditionControls.deleteConditionPanel(conditionTkfPanel);
    }

}
