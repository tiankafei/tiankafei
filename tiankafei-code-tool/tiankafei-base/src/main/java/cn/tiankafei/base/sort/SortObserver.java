package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.observer.event.ObserverEvent;
import cn.tiankafei.base.sort.singleton.SortComparatorSingleton;

/**
 * 观察者模式
 *
 * @author tiankafei
 */
public interface SortObserver {

    /**
     * 策略模式
     */
    DoubleSortComparator doubleMinSortComparator = SortComparatorSingleton.getDoubleMinSortComparator();
    DoubleSortComparator doubleMaxSortComparator = SortComparatorSingleton.getDoubleMaxSortComparator();
    IntegerSortComparator integerMinSortComparator = SortComparatorSingleton.getIntegerMinSortComparator();
    IntegerSortComparator integerMaxSortComparator = SortComparatorSingleton.getIntegerMaxSortComparator();

    /**
     * 事件处理
     *
     * @param event
     * @param <T>
     */
    public <T> void action(ObserverEvent<T> event);

}
