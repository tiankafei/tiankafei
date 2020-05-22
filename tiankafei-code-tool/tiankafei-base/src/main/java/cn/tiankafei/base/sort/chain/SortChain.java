package cn.tiankafei.base.sort.chain;

import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.singleton.SortComparatorSingleton;
import cn.tiankafei.base.sort.singleton.SortFactoryStrategy;

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
