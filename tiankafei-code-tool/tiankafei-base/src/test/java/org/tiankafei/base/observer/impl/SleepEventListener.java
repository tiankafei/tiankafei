package org.tiankafei.base.observer.impl;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.base.observer.ListenerManager;
import org.tiankafei.base.observer.event.SleepEventModel;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
public class SleepEventListener extends BaseEventListener<SleepEventModel> {

    public SleepEventListener(ListenerManager listenerManager) {
        super(listenerManager);
    }

    @Override
    public void onEvent(SleepEventModel event) {
        Object sourceEvent = event.getSource();
        // TODO 执行事件处理
        log.info("执行了{}观察者的方法", this.getClass().getName());
    }
}
