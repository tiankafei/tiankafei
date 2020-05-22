package cn.tiankafei.base.sort.selection;

import cn.tiankafei.base.sort.SortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * 第一轮从第一个位置开始找到一个最小值，放在第一个位置，
 * 第二轮从第二个位置开始找到一个最小值，放在第二个位置，
 * 以此类推
 *
 * @ClassName SelectionSortUtil
 * @Description: 选择排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class SelectionSortUtil {

    public static <T> T[] sort(T[] arr, SortComparator sortComparator) {
        log.info("执行了选择排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //数组的长度
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int location = i;
            for (int j = i + 1; j < length; j++) {
                int result = sortComparator.compareTo(arr[location], arr[j]);
                if (result > 0) {
                    location = j;
                }
            }
            if (location != i) {
                sortComparator.swap(arr, i, location);
            }
        }

        return arr;
    }

}
