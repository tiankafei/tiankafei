package cn.tiankafei.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class BaseTest {

    @Test
    public void testForIterator(){
        List dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(3);
        dataList.add(2);
        for (Iterator iterator = dataList.listIterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void testTreeSet(){
        Set dataSet = new TreeSet();
        dataSet.add(1);
        dataSet.add(11);
        dataSet.add(3);
        System.out.println(dataSet);
        System.out.println("===============");
        Set strSet = new TreeSet();
        strSet.add("1");
        strSet.add("11");
        strSet.add("3");
        System.out.println(strSet);
    }

    @Test
    public void testHashMap(){
        Map map = new HashMap();
        map.put(1, 1);
        map.put(1, 2);
        System.out.println(map);
    }

    @Test
    public void testLinkedHashMap(){
        // 第三个参数默认为fasle，按照插入的顺序排序；为true表示不需要排序
        Map map = new LinkedHashMap(16, 0.75f, true);
        List dataList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            int number = new Random().nextInt(100);
            dataList.add(number);
            map.put(number, number);
        }
        System.out.println(dataList);
        System.out.println(map);
    }

    @Test
    public void testEntrySet(){
        Map<Integer, Integer> dataMap = new HashMap();
        for (int i = 0; i < 100; i++) {
            int number = new Random().nextInt(100);
            dataMap.put(number, number);
        }

        // 遍历方法1：
        Set<Map.Entry<Integer, Integer>> entries = dataMap.entrySet();
        entries.forEach(map -> {
            Integer key = map.getKey();
            Integer value = map.getValue();
            System.out.println(key + ",,," + value);
        });
        System.out.println("==================");

        // 遍历方法2：
        dataMap.keySet().forEach(key -> {
            Integer value = dataMap.get(key);
            System.out.println(key + ",,," + value);
        });

        System.out.println("==================");

        // 遍历方法3：
        for (Iterator<Integer> iterator = dataMap.keySet().iterator(); iterator.hasNext(); ){
            Integer key = iterator.next();
            Integer value = dataMap.get(key);
            System.out.println(key + ",,," + value);
        }
        System.out.println("==================");
    }

    @Test(expected = Exception.class)
    public void testHashTableValue(){
        // key 和 value 都不允许为空
        Map hashtable = new Hashtable();
        hashtable.put(1, null);
        hashtable.put(null, 1);
        System.out.println(hashtable);
    }

}
