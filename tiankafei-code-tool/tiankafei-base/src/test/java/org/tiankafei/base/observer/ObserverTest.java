package org.tiankafei.base.observer;

import org.tiankafei.base.observer.impl.EatObserverImpl;
import org.tiankafei.base.observer.impl.SleepObserverImpl;
import org.tiankafei.base.observer.impl.WorkObserverImpl;

import java.util.EventObject;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {
        ObserverManager observerManager = new ObserverManager();

        observerManager.addObserver(new EatObserverImpl());
        observerManager.addObserver(new WorkObserverImpl());
        observerManager.addObserver(new SleepObserverImpl());

        Object object = new Object();
        observerManager.executeObserver(new EventObject(object));
    }

}
