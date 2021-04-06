package org.tiankafei.common.sort.comparator;

/**
 * 策略模式
 *
 * @author tiankafei
 **/
public interface SortComparator<T> {

    /**
     * 选择排序比较方法
     *
     * @param t1
     * @param t2
     * @return 1，-1，0
     */
    int compareTo(T t1, T t2);

    /**
     * 打印数组的方法
     *
     * @param arr
     */
    default String print(T[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i] + " ");
        }
        return stringBuffer.toString();
    }

    /**
     * 交换位置
     *
     * @param arr
     * @param bigIndex
     * @param index
     */
    default void swap(T[] arr, int bigIndex, int index) {
        T temp = arr[bigIndex];
        arr[bigIndex] = arr[index];
        arr[index] = temp;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    default Boolean equalsArray(T[] arr1, T[] arr2) {
        Boolean flag = Boolean.FALSE;

        int length1 = arr1.length;
        int length2 = arr2.length;
        if (length1 == length2) {
            int count = 0;
            for (int i = 0; i < length1; i++) {
                if (arr1[i].equals(arr2[i])) {
                    count++;
                }
            }
            if (count == length1) {
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }

}
