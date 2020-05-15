package cn.tiankafei.base;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
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

    @Test
    public void test(){
        int index = 0;
        int a = index++;
        System.out.println(index);
        System.out.println(a);
        System.out.println("=================");
        index = 0;
        a = ++index;
        System.out.println(index);
        System.out.println(a);
    }

    @Test
    public void testCollections(){
        List<String> dataList = new ArrayList<>();
        dataList.add("3");
        dataList.add("2");
        dataList.add("1");
        dataList.add("4");
        Collections.addAll(dataList, "0");
        dataList.forEach(System.out::println);

        Collections.sort(dataList);
        dataList.forEach(System.out::println);

        Collections.sort(dataList, (a, b) -> {
            return b.length() - a.length();
        });
        dataList.forEach(System.out::println);

        File[] x = File.listRoots();
        for (File file : x) {
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
        }
    }

    @Test
    public void testInteger(){
        int index = 1;
        deal(index);
        System.out.println(index);

        Integer index1 = new Integer(1);
        deal(index1);
        System.out.println(index1);

        String str = "111111";
        deal(str);
        System.out.println(str);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        deal(stringBuffer);
        System.out.println(stringBuffer.toString());
    }

    private int deal(int index){
        index = index + 4;
        return 0;
    }

    private int deal(Integer index){
        index = index + 4;
        return 0;
    }

    private int deal(String str){
        str = str + "123465";
        return 0;
    }

    private int deal(StringBuffer str){
        str.append(str).append("123456");
        return 0;
    }

    @Test
    public void test1(){
        System.out.println(get(10001));
        System.out.println(get(10002));
        System.out.println(get(20001));
        System.out.println(get(20002));
        System.out.println(get(20003));
        System.out.println(get(20004));
        System.out.println(get(20005));
        System.out.println(get(30001));
        System.out.println(get(30002));
        System.out.println(get(30003));
        System.out.println(get(30004));
        System.out.println(get(30005));
        System.out.println(get(40001));
        System.out.println(get(50001));
        System.out.println(get(50002));
        System.out.println(get(50003));
        System.out.println(get(50004));
        System.out.println(get(60001));
        System.out.println(get(60002));
        System.out.println(get(60003));
        System.out.println(get(60004));



    }

    @Test
    public void test2() throws InterruptedException {
        StopWatch stopWatch =  StopWatch.createStarted();
        stopWatch.split();
        Thread.sleep(1000);
        System.out.println("切片执行时间：" + stopWatch.getSplitTime());
        System.out.println("总的执行时间：" + stopWatch.getTime(TimeUnit.MILLISECONDS));
        stopWatch.split();
        Thread.sleep(1000);
        System.out.println("切片执行时间：" + stopWatch.getSplitTime());
        System.out.println("总的执行时间：" + stopWatch.getTime(TimeUnit.MILLISECONDS));
        stopWatch.split();
        Thread.sleep(1000);
        System.out.println("切片执行时间：" + stopWatch.getSplitTime());
        System.out.println("总的执行时间：" + stopWatch.getTime(TimeUnit.MILLISECONDS));
        stopWatch.split();
        Thread.sleep(1000);
        System.out.println("切片执行时间：" + stopWatch.getSplitTime());
        System.out.println("总的执行时间：" + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    private int get(int value){
        return value - value % 10000;
    }

}
