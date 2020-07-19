package org.tiankafei.base.sort.quick;

import org.tiankafei.base.sort.comparator.SortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * 第一轮：以最右边的数据为标准，从左到右遍历，找到第一个大于标准值得位置；从右到左遍历，找到第一个小于标准值得位置，然年两者交换位置，然后跳出里层循环；当左右索引位置相同时，跳出最外面的循环，同时记录刚才的索引位置。如果当前位置和标准值的位置不相等时，该索引的位置与标准值的位置进行交换
 * 第二轮：获取第一轮返回的索引位置，以该位置为基准，分成两堆儿，递归调用；第一推从0，到mid；第二堆从mid+1，到length
 *
 * @ClassName SelectionSortUtil
 * @Description: 快排排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class QuickSortUtil {

    public static <T> T[] sort(T[] arr, SortComparator sortComparator) {
        log.info("执行了快速排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        sort(arr, 0, arr.length, sortComparator);
        return arr;
    }

    private static <T> void sort(T[] arr, int left, int right, SortComparator sortComparator) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right, sortComparator);
        sort(arr, left, mid, sortComparator);
        sort(arr, mid + 1, right, sortComparator);
    }

    private static <T> Integer partition(T[] arr, int left, int right, SortComparator sortComparator) {
        T standValue = arr[right - 1];
        int mid = left;
        out:
        for (int lefetIndex = left; lefetIndex < right; lefetIndex++) {
            int leftResult = sortComparator.compareTo(arr[lefetIndex], standValue);
            if (leftResult >= 0) {
                for (int rightIndex = right - 1; rightIndex >= 0; rightIndex--) {
                    if (lefetIndex == rightIndex) {
                        mid = lefetIndex;
                        break out;
                    }
                    int rightResult = sortComparator.compareTo(arr[rightIndex], standValue);
                    if (rightResult < 0) {
                        sortComparator.swap(arr, lefetIndex, rightIndex);
                        break;
                    }
                }
            }
        }
        if (mid != right - 1) {
            sortComparator.swap(arr, mid, right - 1);
        }
        return mid;
    }

}
