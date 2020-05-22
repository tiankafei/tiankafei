package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.chain.StandSortChain;
import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.singleton.SortComparatorSingleton;

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

    /**
     * 执行
     *
     * @param sortDecorator
     * @param standSortChain
     * @return
     */
    Boolean execute(SortDecorator sortDecorator, StandSortChain standSortChain);

}
