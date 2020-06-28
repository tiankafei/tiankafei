package org.tiankafei.base.base.sort.chain;

import org.tiankafei.base.base.sort.comparator.DoubleSortComparator;
import org.tiankafei.base.base.sort.comparator.IntegerSortComparator;
import org.tiankafei.base.base.sort.singleton.SortComparatorSingleton;
import org.tiankafei.base.base.sort.singleton.SortFactoryStrategy;

/**
 * 责任链模式
 *
 * @author tiankafei
 */
public interface SortChain {

    /**
     * 策略模式
     */
    DoubleSortComparator doubleMinSortComparator = SortComparatorSingleton.getDoubleMinSortComparator();
    DoubleSortComparator doubleMaxSortComparator = SortComparatorSingleton.getDoubleMaxSortComparator();
    IntegerSortComparator integerMinSortComparator = SortComparatorSingleton.getIntegerMinSortComparator();
    IntegerSortComparator integerMaxSortComparator = SortComparatorSingleton.getIntegerMaxSortComparator();

    SortFactoryStrategy sortFactoryStrategy = SortFactoryStrategy.getInstance();

    /**
     * 执行
     *
     * @param standSortChain
     * @return
     */
    Boolean execute(StandSortChain standSortChain);

}
