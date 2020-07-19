package org.tiankafei.base.observer;

import org.tiankafei.base.observer.impl.Observer1Impl;
import org.tiankafei.base.observer.impl.Observer2Impl;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {
        ObserverManager observerManager = new ObserverManager();

        observerManager.addObserver(new Observer1Impl());
        observerManager.addObserver(new Observer2Impl());

        Object object = new Object();
        observerManager.executeObserver(new ObserverEvent(object));
    }

}
