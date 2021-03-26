package org.tiankafei.common.sort.merge;

import org.tiankafei.common.sort.comparator.SortComparator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SelectionSortUtil
 * @Description: 归并排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class MergeSortUtil {

    public static <T> T[] sortMin(T[] arr, SortComparator sortComparator) {
        log.info("执行了归并排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        sort(arr, 0, arr.length, sortComparator);
        return arr;
    }

    private static <T> void sort(T[] arr, int startLocation, int endLocation, SortComparator sortComparator) {
        if (startLocation == endLocation || endLocation - startLocation == 1) {
            return;
        }
        int mid = (endLocation + startLocation) / 2;

        sort(arr, startLocation, mid, sortComparator);
        sort(arr, mid, endLocation, sortComparator);

        merge(arr, startLocation, mid, endLocation, sortComparator);
    }

    /**
     * 执行归并排序的方法
     *
     * @param arr
     * @param startLocation
     * @param endLocation
     * @return
     */
    private static <T> void merge(T[] arr, int startLocation, int mid, int endLocation, SortComparator sortComparator) {
        if (startLocation > mid) {
            return;
        }
        List<T> temp = new ArrayList<T>(endLocation - startLocation);

        int leftStartLocation = startLocation;
        int rightStartLocation = mid;
        while (leftStartLocation < mid && rightStartLocation < endLocation) {
            int result = sortComparator.compareTo(arr[leftStartLocation], arr[rightStartLocation]);
            if (result >= 0) {
                temp.add(arr[rightStartLocation++]);
            } else if (result == -1) {
                temp.add(arr[leftStartLocation++]);
            }
        }
        while (leftStartLocation < mid) {
            temp.add(arr[leftStartLocation++]);
        }
        while (rightStartLocation < endLocation) {
            temp.add(arr[rightStartLocation++]);
        }
        //将临时变量的数组赋值给arr
        for (int tempIndex = 0, length = temp.size(); tempIndex < length; tempIndex++) {
            arr[startLocation++] = temp.get(tempIndex);
        }
    }

}
