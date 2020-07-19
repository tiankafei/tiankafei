package org.tiankafei.base.observer;

import com.google.common.collect.Lists;
import org.tiankafei.base.observer.impl.EatEventListener;
import org.tiankafei.base.observer.impl.SleepEventListener;
import org.tiankafei.base.observer.impl.WorkEventListener;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ListenerManager<E extends EventListener> {

    protected List<EventListener> observerList = Lists.newArrayList();

    public void addObserver(EventListener eventListener){
        observerList.add(eventListener);
    }

    public void onEatEvent(EventModel event){
        observerList.stream().filter(eventListener -> eventListener instanceof EatEventListener).forEach(observer -> observer.onEvent(event));
    }

    public void onWorkEvent(EventModel event){
        observerList.stream().filter(eventListener -> eventListener instanceof WorkEventListener).forEach(observer -> observer.onEvent(event));
    }

    public void onSleepEvent(EventModel event){
        observerList.stream().filter(eventListener -> eventListener instanceof SleepEventListener).forEach(observer -> observer.onEvent(event));
    }

}
