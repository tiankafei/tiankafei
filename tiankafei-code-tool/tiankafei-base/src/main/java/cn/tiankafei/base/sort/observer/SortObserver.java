package cn.tiankafei.base.sort.observer;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.decorator.StandSortDecorator;
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

    @Override
    default void update(Observable o, Object arg) {
        if(arg instanceof StandSortDecorator){
            SortDecorator sortDecorator = (SortDecorator) arg;
            exec(sortDecorator);
        }
    }

    void exec(SortDecorator sortDecorator) ;

}
