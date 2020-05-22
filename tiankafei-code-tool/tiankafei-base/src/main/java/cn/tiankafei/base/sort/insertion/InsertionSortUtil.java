package cn.tiankafei.base.sort.insertion;

import cn.tiankafei.base.sort.comparator.SortComparator;
import lombok.extern.slf4j.Slf4j;

/**
 * 第一轮，第一个值和第二个值进行比较，后面小的进行交换位置
 * 第二轮，第二个和第三个值进行比较，后面小的进行交换位置，第一个和第二个进行比较，后面小的进行交换位置
 * 以此类推，每一轮，后面的值和前面的值比较，后面的值小，就往前面插入
 *
 * @ClassName SelectionSortUtil
 * @Description: 直接插入排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
@Slf4j
public class InsertionSortUtil {

    public static <T> T[] sort(T[] arr, SortComparator sortComparator) {
        log.info("执行了直接插入排序算法!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //数组的长度
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                int result = sortComparator.compareTo(arr[j - 1], arr[j]);
                if (result == 1) {
                    sortComparator.swap(arr, j - 1, j);
                }
            }
        }

        return arr;
    }

}
