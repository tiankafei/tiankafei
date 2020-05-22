package cn.tiankafei.base.sort.shell;

import cn.tiankafei.base.sort.SortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SelectionSortUtil
 * @Description: 希尔排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class ShellSortUtil {

    public static <T> T[] sort(T[] arr, SortComparator sortComparator) {
        log.info("执行了希尔排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //数组的长度
        int length = arr.length;
        int h = 1;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    int result = sortComparator.compareTo(arr[j - gap], arr[j]);
                    if (result == 1) {
                        sortComparator.swap(arr, j - gap, j);
                    }
                }
            }
        }

//        for (int gap = length / 2; gap >0 ; gap /= 2) {
//            for (int i = gap; i < length; i++) {
//                for (int j = i; j > gap - 1; j -= gap) {
//                    int result = sortComparator.compareTo(arr[j - gap], arr[j]);
//                    if (result == 1) {
//                        Integer temp = arr[j - gap];
//                        arr[j - gap] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }

        return arr;
    }

}
