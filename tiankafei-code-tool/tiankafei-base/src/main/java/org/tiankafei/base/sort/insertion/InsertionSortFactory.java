package org.tiankafei.base.sort.insertion;

import org.tiankafei.base.sort.comparator.SortComparator;
import org.tiankafei.base.sort.factory.SortFactory;

/**
 * @ClassName InsertionSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class InsertionSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return InsertionSortUtil.sort(arr, sortComparator);
    }
}