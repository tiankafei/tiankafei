package org.tiankafei.base.observer.impl;

import lombok.extern.slf4j.Slf4j;
import org.tiankafei.base.observer.IObserver;
import org.tiankafei.base.observer.ObserverEvent;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
public class Observer2Impl implements IObserver<ObserverEvent> {

    @Override
    public void execute(ObserverEvent event) {
        Object sourceEvent = event.getSourceEvent();
        // TODO 执行事件处理
        log.info("执行了{}观察者的方法", this.getClass().getName());
    }

}
