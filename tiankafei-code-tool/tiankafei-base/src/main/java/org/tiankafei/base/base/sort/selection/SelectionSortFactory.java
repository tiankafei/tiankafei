package org.tiankafei.base.base.sort.selection;

import org.tiankafei.base.base.sort.comparator.SortComparator;
import org.tiankafei.base.base.sort.factory.SortFactory;

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
