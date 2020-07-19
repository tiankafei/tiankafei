package org.tiankafei.base.sort.singleton;

import org.tiankafei.base.sort.comparator.impl.DoubleMaxSortComparator;
import org.tiankafei.base.sort.comparator.impl.DoubleMinSortComparator;
import org.tiankafei.base.sort.comparator.impl.IntegerMaxSortComparator;
import org.tiankafei.base.sort.comparator.impl.IntegerMinSortComparator;

/**
 * 单例模式
 *
 * @ClassName SortComparatorSingleton
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
public class SortComparatorSingleton {

    private SortComparatorSingleton() {

    }

    private static class SortComparatorSingletonDoubleMin {
        private final static DoubleMinSortComparator INSTANCE = new DoubleMinSortComparator();
    }

    private static class SortComparatorSingletonDoubleMax {
        private final static DoubleMaxSortComparator INSTANCE = new DoubleMaxSortComparator();
    }

    private static class SortComparatorSingletonIntegerMin {
        private final static IntegerMinSortComparator INSTANCE = new IntegerMinSortComparator();
    }

    private static class SortComparatorSingletonIntegerMax {
        private final static IntegerMaxSortComparator INSTANCE = new IntegerMaxSortComparator();
    }

    public static DoubleMinSortComparator getDoubleMinSortComparator() {
        return SortComparatorSingletonDoubleMin.INSTANCE;
    }

    public static DoubleMaxSortComparator getDoubleMaxSortComparator() {
        return SortComparatorSingletonDoubleMax.INSTANCE;
    }

    public static IntegerMinSortComparator getIntegerMinSortComparator() {
        return SortComparatorSingletonIntegerMin.INSTANCE;
    }

    public static IntegerMaxSortComparator getIntegerMaxSortComparator() {
        return SortComparatorSingletonIntegerMax.INSTANCE;
    }

}
