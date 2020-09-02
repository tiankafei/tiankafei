package org.tiankafei.ui.control.condition.actions;

import java.awt.event.ItemEvent;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.dto.TiankafeiCustomConditionDTO;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiItemAction;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 过滤条件列表下拉框事件
 *
 * @author tiankafei1
 */
public class TiankafeiConditionTkfComboBoxAction extends AbstractTiankafeiItemAction {

    /**
     * 过滤条件当前面板对象
     */
    private TkfPanel conditionTkfPanel;

    /**
     * 过滤条件下拉列表
     */
    private TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox;

    /**
     * 序号
     */
    private int number;

    /**
     * 构造过滤条件列表下拉框事件
     *
     * @param conditionTkfPanel             过滤条件当前面板对象
     * @param tiankafeiConditionTkfComboBox 过滤条件下拉列表
     * @param number                        序号
     */
    public TiankafeiConditionTkfComboBoxAction(TkfPanel conditionTkfPanel, TkfComboBox<AbstractTiankafeiConditionDTO> tiankafeiConditionTkfComboBox, int number) {
        this.conditionTkfPanel = conditionTkfPanel;
        this.tiankafeiConditionTkfComboBox = tiankafeiConditionTkfComboBox;
        this.number = number;
    }

    @Override
    public void handleItemStateChanged(ItemEvent e) {
        try {
            AbstractTiankafeiConditionDTO abstractTiankafeiConditionDTO = (AbstractTiankafeiConditionDTO) tiankafeiConditionTkfComboBox.getSelectedItem();
            TiankafeiCustomConditionDTO tiankafeiCustomConditionDTO = (TiankafeiCustomConditionDTO) tiankafeiConditionTkfComboBox.getTiankafeiModelUiVO().getParamObject();
            //处理自定义过滤条件
            abstractTiankafeiConditionDTO.handleTiankafeiCondition(conditionTkfPanel, number, tiankafeiCustomConditionDTO);
        } catch (BaseException e1) {
            e1.printStackTrace();
        }
    }

}
