package org.tiankafei.common.observer;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.common.observer.event.EatEventModel;
import org.tiankafei.common.observer.event.SleepEventModel;
import org.tiankafei.common.observer.event.WorkEventModel;
import org.tiankafei.common.observer.impl.EatEventListener;
import org.tiankafei.common.observer.impl.SleepEventListener;
import org.tiankafei.common.observer.impl.WorkEventListener;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ListenerManager<E extends EventListener> {

    protected List<EventListener> observerList = Lists.newArrayList();

    public void addObserver(EventListener eventListener) {
        observerList.add(eventListener);
    }

    public void onEatEvent(EatEventModel event) {
        observerList.stream().filter(eventListener -> eventListener instanceof EatEventListener).forEach(observer -> observer.onEvent(event));
    }

    public void onWorkEvent(WorkEventModel event) {
        observerList.stream().filter(eventListener -> eventListener instanceof WorkEventListener).forEach(observer -> observer.onEvent(event));
    }

    public void onSleepEvent(SleepEventModel event) {
        observerList.stream().filter(eventListener -> eventListener instanceof SleepEventListener).forEach(observer -> observer.onEvent(event));
    }

}
