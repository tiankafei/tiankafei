package org.tiankafei.base.base.sort.shell;

import org.tiankafei.base.base.sort.comparator.SortComparator;
import org.tiankafei.base.base.sort.factory.SortFactory;

/**
 * @ClassName ShellSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class ShellSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return ShellSortUtil.sort(arr, sortComparator);
    }
}
