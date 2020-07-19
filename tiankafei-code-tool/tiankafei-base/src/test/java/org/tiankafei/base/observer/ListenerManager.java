package org.tiankafei.base.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
public abstract class ListenerManager<E extends EventListener> {

    protected List<EventListener> observerList = Lists.newArrayList();

    public void addObserver(EventListener eventListener){
        observerList.add(eventListener);
    }

    public void executeObserver(EventModel event){
        observerList.stream().forEach(observer -> observer.onEvent(event));
    }

}
