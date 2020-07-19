package org.tiankafei.base.observer;

import org.tiankafei.base.observer.event.EatEventModel;
import org.tiankafei.base.observer.impl.EatEventListener;
import org.tiankafei.base.observer.impl.EatListenerManager;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
public class ListenerTest {

    public static void main(String[] args) {
        ListenerManager listenerManager = new EatListenerManager();
        listenerManager.addObserver(new EatEventListener());
        listenerManager.executeObserver(new EatEventModel(new Object()));
    }

}
