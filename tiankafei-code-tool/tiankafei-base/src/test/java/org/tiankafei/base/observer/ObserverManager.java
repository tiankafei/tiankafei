package org.tiankafei.base.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ObserverManager {

    protected List<IObserver> observerList = Lists.newArrayList();

    public void addObserver(IObserver observer){
        observerList.add(observer);
    }

    public void executeObserver(ObserverEvent event){
        observerList.stream().forEach(observer -> observer.execute(event));
    }

}
