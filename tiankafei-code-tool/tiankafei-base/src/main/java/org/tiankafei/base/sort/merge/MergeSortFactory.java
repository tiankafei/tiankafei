package org.tiankafei.base.sort.merge;

import org.tiankafei.base.sort.comparator.SortComparator;
import org.tiankafei.base.sort.factory.SortFactory;

/**
 * @ClassName MergeSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class MergeSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return MergeSortUtil.sortMin(arr, sortComparator);
    }
}
