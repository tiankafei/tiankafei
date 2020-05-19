package cn.tiankafei.base.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author 魏双双
 * @Date 2020/4/26
 * @Version V1.0
 **/
public class Test {

    @org.junit.Test
    public void test01() {
        Stream.iterate(1, x -> x + 1).skip(20).limit(10).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        String str = "11,22,33,44,55";
        Arrays.stream(str.split(",")).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        int sum = Arrays.stream(str.split(",")).mapToInt(x -> Integer.valueOf(x.toString())).sum();
        System.out.println(sum);
        System.out.println("-------------------------------------------------------------");
        Stream.of(str).flatMap(x -> Stream.of(x.split(","))).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        int sum1 = Stream.of(str).flatMap(x -> Stream.of(x.split(","))).mapToInt(x -> Integer.valueOf(x.toString())).sum();
        System.out.println(sum1);
        System.out.println("-------------------------------------------------------------");
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println("-------------------------------------------------------------");
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).peek(System.out::println).sum());
        System.out.println("-------------------------------------------------------------");
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce((a, b) -> a + b).get();
        System.out.println(result);
        System.out.println("-------------------------------------------------------------");
        List<String> strList = Arrays.asList("11", "22", "33", "44");
        System.out.println(strList.stream().reduce((a, b) -> a + b).get());
        System.out.println("-------------------------------------------------------------");
        numList = Arrays.asList(1, 2);
        System.out.println(numList.stream().reduce(0, (a, b) -> a + b, (a, b) -> 0));
        System.out.println("-------------------------------------------------------------");
        numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result1 = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + Integer.toString(b));
            return a;
        }, (a, b) -> null);
        System.out.println(result1);
        System.out.println("-------------------------------------------------------------");
        System.out.println(Integer.sum(1, 2));
        System.out.println("-------------------------------------------------------------");

    }

}
