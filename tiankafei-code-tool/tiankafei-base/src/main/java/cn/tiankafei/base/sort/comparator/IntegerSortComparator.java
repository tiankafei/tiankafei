package cn.tiankafei.base.sort.comparator;

import java.util.Random;

/**
 * 整型排序基类
 *
 * @author tiankafei
 */
public interface IntegerSortComparator extends SortComparator<Integer> {

    /**
     * 打印数组的方法
     *
     * @param arr
     */
    default void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 生成整型数组
     *
     * @param length
     * @return
     */
    default Integer[] createArray(int length) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }
        return arr;
    }

    /**
     * 生成整型数组
     *
     * @return
     */
    default Integer[] createArray(int length, int range) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(range);
        }
        return arr;
    }

}
