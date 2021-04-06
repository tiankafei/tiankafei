package org.tiankafei.common.sort.bubble;

import org.tiankafei.common.sort.comparator.SortComparator;
import org.tiankafei.common.sort.factory.SortFactory;

/**
 * @ClassName BubbleSortFactory
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class BubbleSortFactory<T> implements SortFactory<T> {
    @Override
    public T[] sort(T[] arr, SortComparator<T> sortComparator) {
        return BubbleSortUtil.sort(arr, sortComparator);
    }

}
