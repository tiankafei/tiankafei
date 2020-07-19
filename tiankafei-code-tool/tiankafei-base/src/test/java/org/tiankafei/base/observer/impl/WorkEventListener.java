package org.tiankafei.base.observer.impl;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.base.observer.EventListener;
import org.tiankafei.base.observer.ListenerManager;
import org.tiankafei.base.observer.event.SleepEventModel;
import org.tiankafei.base.observer.event.WorkEventModel;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
public class WorkEventListener implements EventListener<WorkEventModel> {

    @Override
    public void onEvent(WorkEventModel event) {
        Object sourceEvent = event.getSource();
        // TODO 执行事件处理
        log.info("执行了{}观察者的方法", this.getClass().getName());

        ListenerManager listenerManager = new SleepListenerManager();
        listenerManager.addObserver(new SleepEventListener());
        listenerManager.executeObserver(new SleepEventModel(new Object()));
    }

}
