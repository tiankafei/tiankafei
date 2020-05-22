package cn.tiankafei.base.sort.count;

import cn.tiankafei.base.sort.comparator.impl.IntegerMinSortComparator;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MainSelectionSort
 * @Description: 计数排序主方法
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class MainCountSort {

    public static void main(String[] args) {
        IntegerMinSortComparator integerMinSortComparator = new IntegerMinSortComparator();
        int length = 10000;
        int range = 50;
        Integer[] arr = integerMinSortComparator.createArray(length, range);
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, length);

        System.out.print("排序前：");
        log.info(integerMinSortComparator.print(arr));
        System.out.print("从小到大排序后：");
        arr = CountSortUtil.sortMin(arr, range);
        log.info(integerMinSortComparator.print(arr));
//        System.out.print("从大到小排序后：");
//        arr = CountSortUtil.sortMax(arr, range);
//        SortUtil.print(arr);
//        Arrays.sort(arr1, Collections.reverseOrder());
//        boolean result = SortUtil.equalsArray(arr, arr1);
//        System.out.println(result);

        System.out.print("从小到大排序后：");
        arr = CountSortUtil.sortMin(arr, range);
        log.info(integerMinSortComparator.print(arr));

        Arrays.sort(arr1);
        boolean result = integerMinSortComparator.equalsArray(arr, arr1);
        System.out.println(result);
    }

}
