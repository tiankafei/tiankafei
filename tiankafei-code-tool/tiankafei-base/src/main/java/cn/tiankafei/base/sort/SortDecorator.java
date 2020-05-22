package cn.tiankafei.base.sort;

import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;

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
    public void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator);

    /**
     * 浮点型从大到小排序
     *
     * @param sortFactory
     * @param doubleSortComparator
     */
    public void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator);

    /**
     * 整型从小到大排序
     *
     * @param sortFactory
     * @param integerSortComparator
     */
    public void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator);

    /**
     * 整型从大到小排序
     *
     * @param sortFactory
     * @param integerSortComparator
     */
    public void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator);

}
