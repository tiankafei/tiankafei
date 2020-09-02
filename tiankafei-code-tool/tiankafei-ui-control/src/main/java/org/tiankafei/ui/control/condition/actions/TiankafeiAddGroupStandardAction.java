package org.tiankafei.ui.control.condition.actions;

import java.awt.event.ActionEvent;
import org.tiankafei.ui.control.TiankafeiConditionStandardControls;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义过滤条件新增分组事件
 *
 * @author tiankafei1
 */
public class TiankafeiAddGroupStandardAction extends AbstractTiankafeiActionListener {

    /**
     * 自定义过滤条件控件对象
     */
    private TiankafeiConditionStandardControls tiankafeiConditionStandardControls;

    /**
     * 新增条件面板
     */
    private TkfPanel tkfPanel;

    /**
     * 构造自定义过滤条件新增分组事件
     *
     * @param tiankafeiConditionStandardControls 自定义过滤条件控件对象
     * @param tkfPanel                           新增条件面板
     */
    public TiankafeiAddGroupStandardAction(TiankafeiConditionStandardControls tiankafeiConditionStandardControls, TkfPanel tkfPanel) {
        this.tiankafeiConditionStandardControls = tiankafeiConditionStandardControls;
        this.tkfPanel = tkfPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiankafeiConditionStandardControls.initAddGroupPanel(tkfPanel, null);
    }

}
