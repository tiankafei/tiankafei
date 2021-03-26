package org.tiankafei.base.observer.impl;

import org.tiankafei.base.observer.EventListener;
import org.tiankafei.base.observer.EventModel;
import org.tiankafei.base.observer.ListenerManager;

/**
 * @author tiankafei
 * @since 1.0
 */
public abstract class BaseEventListener<E extends EventModel> implements EventListener<E> {

    protected ListenerManager listenerManager;

    public BaseEventListener(ListenerManager listenerManager){
        this.listenerManager = listenerManager;
    }

}
