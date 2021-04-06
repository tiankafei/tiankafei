package org.tiankafei.common.sort.selection;

import org.tiankafei.common.sort.comparator.SortComparator;
import org.tiankafei.common.sort.factory.SortFactory;

/**
 * @ClassName SelectionSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class SelectionSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return SelectionSortUtil.sort(arr, sortComparator);
    }
}
