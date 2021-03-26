package org.tiankafei.common.sort.quick;

import org.tiankafei.common.sort.comparator.SortComparator;
import org.tiankafei.common.sort.factory.SortFactory;

/**
 * @ClassName QuickSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class QuickSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return QuickSortUtil.sort(arr, sortComparator);
    }
}
