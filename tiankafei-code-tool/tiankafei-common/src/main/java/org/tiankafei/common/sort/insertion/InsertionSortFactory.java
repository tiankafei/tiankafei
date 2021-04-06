package org.tiankafei.common.sort.insertion;

import org.tiankafei.common.sort.comparator.SortComparator;
import org.tiankafei.common.sort.factory.SortFactory;

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
