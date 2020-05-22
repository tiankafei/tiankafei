package cn.tiankafei.base.sort.decorator;

import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import cn.tiankafei.base.sort.factory.SortFactory;

/**
 * 装饰着
 *
 * @author tiankafei
 */
public interface SortDecorator {

    /**
     * 浮点型从小到大排序
     *
     * @param sortFactory
     * @param doubleSortComparator
     */
    void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator);

    /**
     * 浮点型从大到小排序
     *
     * @param sortFactory
     * @param doubleSortComparator
     */
    void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator);

    /**
     * 整型从小到大排序
     *
     * @param sortFactory
     * @param integerSortComparator
     */
    void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator);

    /**
     * 整型从大到小排序
     *
     * @param sortFactory
     * @param integerSortComparator
     */
    void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator);

}
