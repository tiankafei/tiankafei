package org.tiankafei.base.base.sort.decorator;

import org.tiankafei.base.base.sort.comparator.DoubleSortComparator;
import org.tiankafei.base.base.sort.comparator.IntegerSortComparator;
import org.tiankafei.base.base.sort.singleton.SortComparatorSingleton;
import org.tiankafei.base.base.sort.singleton.SortFactoryStrategy;

/**
 * 装饰着
 *
 * @author tiankafei
 */
public interface SortDecorator {

    /**
     * 策略模式
     */
    DoubleSortComparator doubleMinSortComparator = SortComparatorSingleton.getDoubleMinSortComparator();
    DoubleSortComparator doubleMaxSortComparator = SortComparatorSingleton.getDoubleMaxSortComparator();
    IntegerSortComparator integerMinSortComparator = SortComparatorSingleton.getIntegerMinSortComparator();
    IntegerSortComparator integerMaxSortComparator = SortComparatorSingleton.getIntegerMaxSortComparator();

    SortFactoryStrategy sortFactoryStrategy = SortFactoryStrategy.getInstance();

    void execute();

}
