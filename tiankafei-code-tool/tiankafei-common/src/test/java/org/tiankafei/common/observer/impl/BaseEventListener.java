package org.tiankafei.common.observer.impl;

import org.tiankafei.common.observer.EventListener;
import org.tiankafei.common.observer.EventModel;
import org.tiankafei.common.observer.ListenerManager;

/**
 * @author tiankafei
 * @since 1.0
 */
public abstract class BaseEventListener<E extends EventModel> implements EventListener<E> {

    protected ListenerManager listenerManager;

    public BaseEventListener(ListenerManager listenerManager) {
        this.listenerManager = listenerManager;
    }

}
