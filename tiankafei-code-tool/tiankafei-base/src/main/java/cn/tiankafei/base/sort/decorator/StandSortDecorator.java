package cn.tiankafei.base.sort.decorator;

import cn.tiankafei.base.sort.SortDecorator;
import cn.tiankafei.base.sort.SortFactory;
import cn.tiankafei.base.sort.comparator.DoubleSortComparator;
import cn.tiankafei.base.sort.comparator.IntegerSortComparator;
import java.util.Arrays;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SortDecoratorImpl
 * @Author tiankafei
 * @Date 2019/12/1
 * @Version V1.0
 **/
@Slf4j
public class StandSortDecorator implements SortDecorator {

    private static final int length = 100;

    @Override
    public void testDoubleMin(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        Double[] arr = doubleSortComparator.createArray(length);

        log.info("排序前：");
        log.info(doubleSortComparator.print(arr));
        Double[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        log.info("排序后：");
        arr = sortFactory.sort(arr, doubleSortComparator);
        log.info(doubleSortComparator.print(arr));

        Arrays.sort(arr1);
        boolean result = doubleSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    @Override
    public void testDoubleMax(SortFactory<Double> sortFactory, DoubleSortComparator doubleSortComparator) {
        Double[] arr = doubleSortComparator.createArray(length);

        log.info("排序前：");
        log.info(doubleSortComparator.print(arr));
        Double[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        log.info("排序后：");
        arr = sortFactory.sort(arr, doubleSortComparator);
        log.info(doubleSortComparator.print(arr));

        Arrays.sort(arr1, Collections.reverseOrder());
        boolean result = doubleSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    @Override
    public void testIntegerMin(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        Integer[] arr = integerSortComparator.createArray(length);

        log.info("排序前：");
        log.info(integerSortComparator.print(arr));
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        log.info("排序后：");
        arr = sortFactory.sort(arr, integerSortComparator);
        log.info(integerSortComparator.print(arr));

        Arrays.sort(arr1);
        boolean result = integerSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }

    @Override
    public void testIntegerMax(SortFactory<Integer> sortFactory, IntegerSortComparator integerSortComparator) {
        Integer[] arr = integerSortComparator.createArray(length);

        log.info("排序前：");
        log.info(integerSortComparator.print(arr));
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);

        log.info("排序后：");
        arr = sortFactory.sort(arr, integerSortComparator);
        log.info(integerSortComparator.print(arr));

        Arrays.sort(arr1, Collections.reverseOrder());
        boolean result = integerSortComparator.equalsArray(arr, arr1);
        log.info("与系统排序方法比对结果：" + result);
    }
}
