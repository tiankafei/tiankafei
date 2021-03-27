package org.tiankafei.common.sort.observer;

import java.util.Observable;
import org.tiankafei.common.sort.observer.event.ObserverEvent;

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
