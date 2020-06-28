package org.tiankafei.base.base.sort.comparator;

import java.util.Random;

/**
 * 整型排序基类
 *
 * @author tiankafei
 */
public interface DoubleSortComparator extends SortComparator<Double> {

    /**
     * 打印数组的方法
     *
     * @param arr
     */
    default void print(double[] arr) {
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
    default Double[] createArray(int length) {
        Double[] arr = new Double[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length) * 0.1;
        }
        return arr;
    }

    /**
     * 生成整型数组
     *
     * @return
     */
    default Double[] createArray(int length, int range) {
        Double[] arr = new Double[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(range) * 0.1;
        }
        return arr;
    }

}
