package org.tiankafei.base.sort.count;

/**
 * 适用于量大但是范围比较小的数据
 * 根据范围，声明一个计数数组，默认全都是0，遍历源数组，拿到数组的值，作为下标，让计数数组的值+1，以此类推
 * 最终遍历计数数组，根据计数数组的值，生成n个下标的值
 *
 * @ClassName SelectionSortUtil
 * @Description: 计数排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
public class CountSortUtil {

    public static Integer[] sortMin(Integer[] arr, int range) {
        //数组的长度
        int length = arr.length;
        Integer[] result = new Integer[length];
        //计数的数组，默认赋值为0
        int[] count = new int[range];
//        //执行计数
//        for (int index = 0; index < length; index++) {
//            Integer value = arr[index];
//            count[value]++;
//        }
//        int resultIndex = 0;
//        //转换新的数组
//        for (int index = 0; index < range; index++) {
//            Integer value = count[index];
//            for (int i = 0; i < value; i++) {
//                result[resultIndex++] = index;
//            }
//        }

        //执行计数
        for (int index = 0; index < length; index++) {
            Integer value = arr[index];
            count[value]++;
        }
        //计数数组累加
        for (int index = 1; index < range; index++) {
            count[index] = count[index] + count[index - 1];
        }
        //转换新的数组
        for (int i = length - 1; i >= 0; i--) {
            int num = count[arr[i]] = count[arr[i]] - 1;
            result[num] = arr[i];
        }
        return result;
    }

//    public static Integer[] sortMax(Integer[] arr, int range) {
//        //数组的长度
//        int length = arr.length;
//        Integer[] result = new Integer[length];
//        //计数的数组，默认赋值为0
//        Integer[] count = new Integer[range];
//        for (int index = 0; index < range; index++) {
//            count[index] = 0;
//        }
//        //执行计数
//        for (int index = 0; index < length; index++) {
//            Integer value = arr[index];
//            count[value]++;
//        }
//        int resultIndex = 0;
//        //转换新的数组
//        for (int index = range - 1; index >= 0; index--) {
//            Integer value = count[index];
//            for (int i = 0; i < value; i++) {
//                result[resultIndex++] = index;
//            }
//        }
//        return result;
//    }

}
