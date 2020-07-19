package org.tiankafei.base.sort.radix;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照位数进行排序，每一位内部按照计数排序的实现逻辑
 *
 * @ClassName RadixSortUtil
 * @Description: 基数排序工具类
 * @Author tiankafei
 * @Date 2019/11/29
 * @Version V1.0
 **/
public class RadixSortUtil {

    public static Integer[] sortMin(Integer[] array) {
        int max = array[0];
        //找到数组中的最大值
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //关键字的个数，我们使用个位、十位、百位...当做关键字，所以关键字的个数就是最大值的位数
        int keysNum = 0;
        while (max > 0) {
            max /= 10;
            keysNum++;
        }

        List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        //每位可能的数字为0~9，所以设置10个桶
        for (int i = 0; i < 10; i++) {
            //桶由ArrayList<Integer>构成
            buckets.add(new ArrayList<Integer>());
        }

        //由最次关键字开始，依次按照关键字进行分配
        for (int i = 0; i < keysNum; i++) {
            //扫描所有数组元素，将元素分配到对应的桶中
            for (int j = 0; j < array.length; j++) {
                //取出该元素对应第i+1位上的数字，比如258，现在要取出十位上的数字，258%100=58,58/10=5
                int key = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                //将该元素放入关键字为key的桶中
                buckets.get(key).add(array[j]);
            }

            //分配完之后，将桶中的元素依次复制回数组
            //元素计数器
            int counter = 0;
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> bucket = buckets.get(j);
                while (bucket.size() > 0) {
                    //将桶中的第一个元素复制到数组，并移除
                    array[counter++] = bucket.remove(0);
                }
            }
            System.out.print("第" + (i + 1) + "轮排序：");
        }
        return array;
    }

}
