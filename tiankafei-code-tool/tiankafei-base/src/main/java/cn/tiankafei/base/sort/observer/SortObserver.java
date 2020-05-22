package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.SortFactoryStrategy;
import cn.tiankafei.base.sort.singleton.SortComparatorSingleton;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 *
 * @author tiankafei
 */
public interface SortObserver extends Observer {

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
        exec();
    }

    void exec() ;

}
