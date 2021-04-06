package org.tiankafei.common.sort.factory;

import org.tiankafei.common.sort.comparator.SortComparator;

/**
 * 工厂方法
 *
 * @author tiankafei
 */
public interface SortFactory<T> {

    /**
     * 排序方法
     *
     * @param arr            要排序的数组
     * @param sortComparator 要排序的策略模式
     * @return
     */
    T[] sort(T[] arr, SortComparator<T> sortComparator);

}
