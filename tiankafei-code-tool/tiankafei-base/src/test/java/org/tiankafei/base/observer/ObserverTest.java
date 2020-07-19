package org.tiankafei.base.observer;

import org.tiankafei.base.observer.event.EatEventModel;
import org.tiankafei.base.observer.impl.EatEventListener;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {
        ObserverManager observerManager = new ObserverManager();
        observerManager.addObserver(new EatEventListener());
        observerManager.executeObserver(new EatEventModel(new Object()));
    }

}
