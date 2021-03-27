package org.tiankafei.common.sort.observer;

import java.util.Observable;
import java.util.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tiankafei.common.sort.comparator.DoubleSortComparator;
import org.tiankafei.common.sort.comparator.IntegerSortComparator;
import org.tiankafei.common.sort.observer.event.ObserverEvent;
import org.tiankafei.common.sort.singleton.SortComparatorSingleton;
import org.tiankafei.common.sort.singleton.SortFactoryStrategy;

/**
 * 观察者模式
 *
 * @author tiankafei
 */
public interface SortObserver extends Observer {

    Logger log = LoggerFactory.getLogger("SortObserver");

    /**
     * 策略模式
     */
    DoubleSortComparator doubleMinSortComparator = SortComparatorSingleton.getDoubleMinSortComparator();
    DoubleSortComparator doubleMaxSortComparator = SortComparatorSingleton.getDoubleMaxSortComparator();
    IntegerSortComparator integerMinSortComparator = SortComparatorSingleton.getIntegerMinSortComparator();
    IntegerSortComparator integerMaxSortComparator = SortComparatorSingleton.getIntegerMaxSortComparator();

    SortFactoryStrategy sortFactoryStrategy = SortFactoryStrategy.getInstance();

    @Override
    default void update(Observable o, Object arg) {
        if (arg != null) {
            if (arg instanceof ObserverEvent) {
                ObserverEvent event = (ObserverEvent) arg;
                log.info("观察者模式接收到的事件对象：{}，事件对象包装的参数：{}", event, event.getObject());
            }
        }
        exec();
    }

    void exec();

}
