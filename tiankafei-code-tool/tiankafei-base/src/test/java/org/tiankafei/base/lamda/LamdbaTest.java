package org.tiankafei.base.lamda;

import org.tiankafei.base.model.CodeNameVo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author tiankafei
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class LamdbaTest {

    //无参构造
    public LamdbaTest() {
        System.out.println("执行了无参数构造方式");
    }

    //一个字符串类型的参数构造
    public LamdbaTest(String str) {
        System.out.println("执行了一个字符串类型的参数构造");
    }

    //一个数值类型的参数构造
    public LamdbaTest(Integer str) {
        System.out.println("执行了一个数值类型的参数构造");
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
        System.out.println("======================");
        test2();
        System.out.println("======================");
        test3();
        System.out.println("======================");


        test9();
    }

    /**
     * Supplier  无参返回值
     */
    public static void test1() {
        //通过具体实现的lamdba
        Supplier<String> s1 = () -> {
            return "abc";
        };
        Supplier<Integer> s2 = () -> {
            return 123;
        };
        Supplier<String> s3 = () -> "abc";
        Supplier<Integer> s4 = () -> 123;
        //静态方法引用
        Supplier<String> s5 = LamdbaTest::getString;
        Supplier<Integer> s6 = LamdbaTest::getInteger;
        //构造方法引用
        Supplier<LamdbaTest> s7 = LamdbaTest::new;
        //实例方法引用
        LamdbaTest lamdbaTest1 = new LamdbaTest();
        Supplier<String> s8 = lamdbaTest1::getString1;
        Supplier<Integer> s9 = lamdbaTest1::getInteger1;

        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
        System.out.println(s4.get());
        System.out.println(s5.get());
        System.out.println(s6.get());
        System.out.println(s7.get());
        System.out.println(s8.get());
        System.out.println(s9.get());
    }

    private String getString1() {
        return "abc";
    }

    private Integer getInteger1() {
        return 123;
    }

    private static String getString() {
        return "abc";
    }

    private static Integer getInteger() {
        return 123;
    }

    /**
     * Consumer 一个输入。没有输入
     */
    public static void test2() {
        //通过具体实现的lamdba
        Consumer<String> c1 = (str) -> {
            System.out.println(str);
        };
        Consumer<Integer> c2 = (str) -> {
            System.out.println(str);
        };
        Consumer<String> c3 = (str) -> System.out.println(str);
        Consumer<Integer> c4 = (str) -> System.out.println(str);
        //静态方法引用
        Consumer<String> c5 = LamdbaTest::setString;
        Consumer<Integer> c6 = LamdbaTest::setInteger;
        //构造方法引用
        Consumer<String> c7 = LamdbaTest::new;
        Consumer<Integer> c8 = LamdbaTest::new;
        //实例方法引用
        LamdbaTest lamdbaTest1 = new LamdbaTest();
        Consumer<String> c9 = lamdbaTest1::setString1;
        Consumer<Integer> c10 = lamdbaTest1::setInteger1;
        //对象方法引用
        Consumer<LamdbaTest> c11 = (lamdbaTest) -> lamdbaTest.getInteger1();
        Consumer<LamdbaTest> c12 = (lamdbaTest) -> lamdbaTest.getString1();

        c1.accept("abc");
        c2.accept(123);
        c3.accept("abc");
        c4.accept(123);
        c5.accept("abc");
        c6.accept(123);
        c7.accept("abc");
        c8.accept(123);
        c9.accept("abc");
        c10.accept(123);
        c11.accept(new LamdbaTest());
        c12.accept(new LamdbaTest());
    }

    private void setString1(String str) {
        System.out.println(str);
    }

    private void setInteger1(Integer str) {
        System.out.println(str);
    }

    private static void setString(String str) {
        System.out.println(str);
    }

    private static void setInteger(Integer str) {
        System.out.println(str);
    }

    /**
     * Function 一个输入一个输出
     */
    public static void test3() {
        //通过具体实现的lamdba
        Function<String, String> f1 = (str) -> {
            return str;
        };
        Function<Integer, Integer> f2 = (str) -> {
            return str;
        };
        Function<String, String> f3 = (str) -> str;
        Function<Integer, Integer> f4 = (str) -> str;
        //静态方法引用
        Function<String, String> f5 = LamdbaTest::string;
        Function<Integer, Integer> f6 = LamdbaTest::integer;
        //构造方法引用
//        Function f7 = LamdaTest::new;
//        Function f8 = LamdaTest::new;
        //实例方法引用
        LamdbaTest lamdbaTest1 = new LamdbaTest();
        Function<String, String> f9 = lamdbaTest1::string1;
        Function<Integer, Integer> f10 = lamdbaTest1::integer1;
        //对象方法引用
        Function<LamdbaTest, String> f11 = (lamdbaTest) -> lamdbaTest.getString1();
        Function<LamdbaTest, Integer> f12 = (lamdbaTest) -> lamdbaTest.getInteger1();


        System.out.println(f1.apply("abc"));
        System.out.println(f2.apply(123));
        System.out.println(f3.apply("abc"));
        System.out.println(f4.apply(123));
        System.out.println(f5.apply("abc"));
        System.out.println(f6.apply(123));
//        f7.apply("abc");
//        f8.apply(123);
        System.out.println(f9.apply("abc"));
        System.out.println(f10.apply(123));
        System.out.println(f11.apply(new LamdbaTest()));
        System.out.println(f12.apply(new LamdbaTest()));
    }

    private String string1(String str) {
        return str;
    }

    private Integer integer1(Integer str) {
        return str;
    }

    private static String string(String str) {
        return str;
    }

    private static Integer integer(Integer str) {
        return str;
    }

    public static void test9() throws InterruptedException {
        Supplier<CodeNameVo> supplier = CodeNameVo::new;
        CodeNameVo codeNameVo = supplier.get();

        Consumer<String> consumer = CodeNameVo::new;
        consumer.accept("发送到发");

        Consumer<String> consumer1 = codeNameVo::setCode;
        Consumer<String> consumer2 = codeNameVo::setName;
        consumer1.accept("123");
        consumer2.accept("阿发放到");

        Supplier supplier1 = codeNameVo::getCode;
        Supplier supplier2 = codeNameVo::getName;
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());

        Supplier supplier10 = LamdbaTest::getString;
        Consumer<Supplier> consumer10 = LamdbaTest::set;
        consumer10.accept(supplier10);
        System.out.println(supplier10.get());

        Consumer<CodeNameVo> codeNameVoConsumer = (codeNameVo1) -> {
            String name = codeNameVo1.getName();
            System.out.println(name);
        };
        codeNameVoConsumer.accept(new CodeNameVo("十分大师傅的"));

        Thread thread = new Thread(() -> {
            System.out.println(codeNameVo.getName());
            System.out.println("123456");
        });
        thread.start();
        thread.join();
    }

    public static void set(Supplier supplier) {
        System.out.println("正在执行set方法" + supplier.get());
    }

}
