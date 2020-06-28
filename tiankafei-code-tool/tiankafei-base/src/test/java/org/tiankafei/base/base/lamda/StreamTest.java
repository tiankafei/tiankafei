package org.tiankafei.base.base.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author tiankafei
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class StreamTest {

    public static void main(String[] args) {
        arryToStream();
        System.out.println("=======================");
        listToStream();
        System.out.println("=======================");
        customOutFixValue();
        System.out.println("=======================");
        customOutChangeValue();
        System.out.println("=======================");
        transform();
        System.out.println("=======================");
        filter1();
        System.out.println("=======================");
        filterAndSum();
        System.out.println("=======================");
        filterAndFindMax();
        System.out.println("=======================");
        filterAndFindMax1();
        System.out.println("=======================");
        filterAndFindMax2();
        System.out.println("=======================");
        filterAndFindMax3();
        System.out.println("=======================");
        filterAndFindMin();
        System.out.println("=======================");
        filterAndFindMin1();
        System.out.println("=======================");
        filter2();
        System.out.println("=======================");
        filter3();
        System.out.println("=======================");
        filter4();
        System.out.println("=======================");
        distinct();
        System.out.println("=======================");
        customDistinct();
        System.out.println("=======================");
        printSkipArray();
        System.out.println("=======================");
        strToIntToSum();
        System.out.println("=======================");
        allMatch();
        System.out.println("=======================");
    }

    private static void arryToStream() {
        String[] strs = {"b", "a", "c", "d", "e"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    private static void listToStream() {
        List<String> list = Arrays.asList("2", "4", "3", "5", "1");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    private static void customOutFixValue() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    private static void customOutChangeValue() {
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    private static void transform() {
        String str = "abcdefg";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);
    }

    private static void filter1() {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).forEach(System.out::println);
    }

    private static void filterAndSum() {
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("偶数求和：" + sum);
    }

    private static void filterAndFindMax() {
        Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).max((a, b) -> a - b);
        if (max.isPresent()) {
            System.out.println("偶数求最大值：" + max.get());
        } else {
            System.out.println("偶数求最大值：无值");
        }
    }

    private static void filterAndFindMax1() {
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().sorted((a, b) -> b - a).findFirst();
        if (first.isPresent()) {
            if (first.isPresent()) {
                System.out.println("自定义求最大值：" + first.get());
            } else {
                System.out.println("自定义求最大值：无值");
            }
        }
    }

    private static void filterAndFindMax2() {
        Optional<String> first = Arrays.asList("java", "python", "scala", "c#").stream().sorted((a, b) -> b.length() - a.length()).findFirst();
        if (first.isPresent()) {
            if (first.isPresent()) {
                System.out.println("自定义字符串长度求最大值：" + first.get());
            } else {
                System.out.println("自定义字符串长度求最大值：无值");
            }
        }
    }

    private static void filterAndFindMax3() {
        List<Integer> collect = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void filterAndFindMin() {
        Optional<Integer> min = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).min((a, b) -> a - b);
        if (min.isPresent()) {
            System.out.println("偶数求最小值：" + min.get());
        } else {
            System.out.println("偶数求最小值：无值");
        }
    }

    private static void filterAndFindMin1() {
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().sorted((a, b) -> a - b).findFirst();
        if (first.isPresent()) {
            System.out.println("自定义求最小值：" + first.get());
        } else {
            System.out.println("自定义求最小值：无值");
        }
    }

    private static void filter2() {
        Optional<Integer> any = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).findAny();
        if (any.isPresent()) {
            System.out.println("偶数求findAny：" + any.get());
        } else {
            System.out.println("偶数求findAny：无值");
        }
    }

    private static void filter3() {
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).findFirst();
        if (first.isPresent()) {
            System.out.println("偶数求findFirst：" + first.get());
        } else {
            System.out.println("偶数求findFirst：无值");
        }
    }

    private static void filter4() {
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 10 == 0).findFirst();
        if (first.isPresent()) {
            System.out.println("偶数求findFirst：" + first.get());
        } else {
            System.out.println("偶数求findFirst：无值");
        }
    }

    private static void distinct() {
        Arrays.asList(1, 2, 3, 4, 5, 6, 1, 3, 5).stream().distinct().forEach(System.out::println);
    }

    private static void customDistinct() {
        Set<Integer> collect = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 3, 5).stream().collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

    private static void printSkipArray() {
        Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);
    }

    private static void strToIntToSum() {
        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        System.out.println("先打印，再求和");
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());
    }

    private static void allMatch() {
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().allMatch(x -> x % 2 == 0));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().allMatch(x -> x >= 0));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().anyMatch(x -> x % 2 == 0));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().anyMatch(x -> x >= 7));

        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().noneMatch(x -> x >= 7));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().noneMatch(x -> x >= 3));

        Stream<Integer> stream1 = Arrays.asList(1, 2, 3).stream();
        Stream<Integer> stream2 = Arrays.asList(4, 5, 6).stream();
        Stream.concat(stream1, stream2).forEach(System.out::println);

        String[] words = new String[]{"Hello", "World"};
        Arrays.stream(words).map(word -> word.split("")).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(words).map(word -> word.split("")).flatMap(x -> Arrays.stream(x)).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");

        List<String> strings = Arrays.asList("hello world", "hello mashibing", "good idea");
        strings.stream().map(word -> word.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);

    }

}
