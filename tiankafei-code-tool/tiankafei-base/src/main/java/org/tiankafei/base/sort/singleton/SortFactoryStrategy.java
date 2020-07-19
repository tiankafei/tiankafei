package org.tiankafei.base.sort.singleton;

import org.tiankafei.base.sort.comparator.DoubleSortComparator;
import org.tiankafei.base.sort.comparator.IntegerSortComparator;
import org.tiankafei.base.sort.factory.SortFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName SortDecoratorImpl
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class SortFactoryStrategy {

    private static final int length = 100;

    private static class SortFactoryStrategySingle {
        private final static SortFactoryStrategy INSTANCE = new SortFactoryStrategy();
    }

    public static SortFactoryStrategy getInstance() {
        return SortFactoryStrategySingle.INSTANCE;
    }

    public void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        Double[] arr = doubleSortComparator.createArray(length);

        log.info("排序前：{}", doubleSortComparator.print(arr));
        Double[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        arr = sortFactory.sort(arr, doubleSortComparator);
        log.info("排序后：{}", doubleSortComparator.print(arr));

        Arrays.sort(arr1);
        boolean result = doubleSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    public void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        Double[] arr = doubleSortComparator.createArray(length);

        log.info("排序前：{}", doubleSortComparator.print(arr));
        Double[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        arr = sortFactory.sort(arr, doubleSortComparator);
        log.info("排序后：{}", doubleSortComparator.print(arr));

        Arrays.sort(arr1, Collections.reverseOrder());
        boolean result = doubleSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    public void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        Integer[] arr = integerSortComparator.createArray(length);

        log.info("排序前：{}", integerSortComparator.print(arr));
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        arr = sortFactory.sort(arr, integerSortComparator);
        log.info("排序后：{}", integerSortComparator.print(arr));

        Arrays.sort(arr1);
        boolean result = integerSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    public void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        Integer[] arr = integerSortComparator.createArray(length);

        log.info("排序前：{}", integerSortComparator.print(arr));
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        arr = sortFactory.sort(arr, integerSortComparator);
        log.info("排序后：{}", integerSortComparator.print(arr));

        Arrays.sort(arr1, Collections.reverseOrder());
        boolean result = integerSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }
}
