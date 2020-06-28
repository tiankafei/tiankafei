package org.tiankafei.base.base.sort.bubble;

import org.tiankafei.base.base.sort.comparator.SortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * 第一轮，第一个位置和第二个位置比，前面值大的进行交换位置，然后第二个和第三个比，前面值大的交换位置，以此类推，一直比到最后一个值，第一轮会把最大值交换到最右边的位置
 * 第二轮，同上，一直比到倒数第二个值，会把第二个最大值放在倒数第二个位置
 * 以此类推
 *
 * @ClassName BubbleSortUtil
 * @Description: 冒泡排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class BubbleSortUtil<T> {

    public static <T> T[] sort(T[] arr, SortComparator sortComparator) {
        log.info("执行了冒泡排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //数组的长度
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            Boolean flag = Boolean.FALSE;
            for (int j = 0; j < length - i - 1; j++) {
                int result = sortComparator.compareTo(arr[j], arr[j + 1]);
                if (result == 1) {
                    sortComparator.swap(arr, j, j + 1);
                    flag = Boolean.TRUE;
                }
            }
            if (Boolean.FALSE.equals(flag)) {
                return arr;
            }
        }
        return arr;
    }

}
