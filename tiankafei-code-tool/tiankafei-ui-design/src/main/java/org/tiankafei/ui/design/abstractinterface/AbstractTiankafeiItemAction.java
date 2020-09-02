package org.tiankafei.ui.design.abstractinterface;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 抽象Item事件
 *
 * @author tiankafei
 */
public abstract class AbstractTiankafeiItemAction implements ItemListener {

    /**
     * 构造抽象Item事件对象
     */
    public AbstractTiankafeiItemAction() {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            handleItemStateChanged(e);
        }
    }

    /**
     * 处理下拉框项改变事件
     *
     * @param e 下拉框项事件对象
     */
    public abstract void handleItemStateChanged(ItemEvent e);

}
