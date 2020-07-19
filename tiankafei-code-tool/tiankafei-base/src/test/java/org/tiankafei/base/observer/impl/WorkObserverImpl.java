package org.tiankafei.base.observer.impl;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.base.observer.EventObject;
import org.tiankafei.base.observer.IObserver;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
public class WorkObserverImpl implements IObserver {

    @Override
    public void publishEvent(EventObject event) {
        Object sourceEvent = event.getSource();
        // TODO 执行事件处理
        log.info("执行了{}观察者的方法", this.getClass().getName());
    }
}
