package org.tiankafei.common.observer;

import org.tiankafei.common.observer.event.EatEventModel;
import org.tiankafei.common.observer.event.SleepEventModel;
import org.tiankafei.common.observer.event.WorkEventModel;
import org.tiankafei.common.observer.impl.EatEventListener;
import org.tiankafei.common.observer.impl.EatListenerManager;
import org.tiankafei.common.observer.impl.SleepEventListener;
import org.tiankafei.common.observer.impl.WorkEventListener;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ListenerTest {

    public static void main(String[] args) {
        ListenerManager listenerManager = new EatListenerManager();

        listenerManager.addObserver(new EatEventListener(listenerManager));
        listenerManager.addObserver(new WorkEventListener(listenerManager));
        listenerManager.addObserver(new SleepEventListener(listenerManager));

        listenerManager.onEatEvent(new EatEventModel(new Object()));
        listenerManager.onWorkEvent(new WorkEventModel(new Object()));
        listenerManager.onSleepEvent(new SleepEventModel(new Object()));
    }

}
