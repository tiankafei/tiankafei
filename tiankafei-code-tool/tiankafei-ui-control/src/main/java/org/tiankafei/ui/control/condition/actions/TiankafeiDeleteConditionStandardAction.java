package org.tiankafei.ui.control.condition.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.control.TiankafeiConditionStandardControls;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义过滤条件删除条件事件
 *
 * @author tiankafei1
 */
public class TiankafeiDeleteConditionStandardAction extends AbstractTiankafeiActionListener {

    /**
     * 自定义过滤条件控件对象
     */
    private TiankafeiConditionStandardControls tiankafeiConditionStandardControls;

    /**
     * 新增条件面板
     */
    private TkfPanel conditionTkfPanel;

    /**
     * 构造自定义过滤条件删除条件事件
     *
     * @param tiankafeiConditionStandardControls 自定义过滤条件控件对象
     * @param conditionTkfPanel                  新增条件面板
     */
    public TiankafeiDeleteConditionStandardAction(TiankafeiConditionStandardControls tiankafeiConditionStandardControls, TkfPanel conditionTkfPanel) {
        this.tiankafeiConditionStandardControls = tiankafeiConditionStandardControls;
        this.conditionTkfPanel = conditionTkfPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiankafeiConditionStandardControls.deleteConditionPanel(conditionTkfPanel);
    }

}
