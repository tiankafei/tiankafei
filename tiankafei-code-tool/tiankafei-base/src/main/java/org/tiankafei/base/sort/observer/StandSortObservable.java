package org.tiankafei.base.sort.observer;

import org.tiankafei.base.sort.observer.event.ObserverEvent;

import java.util.Observable;

/**
 * 这是被监听的对象
 *
 * @ClassName StandSortObserver
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class StandSortObservable extends Observable {

    public void execute(ObserverEvent event) {
        setChanged();
        notifyObservers(event);
        clearChanged();
    }

}
