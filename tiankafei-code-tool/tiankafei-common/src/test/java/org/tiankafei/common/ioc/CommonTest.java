package org.tiankafei.common.ioc;

import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.common.util.SystemTimeUtil;
import org.tiankafei.common.util.UuidUtil;

@Slf4j
public class CommonTest {

    @Before
    public void steup() {

    }

    @Test
    public void test1() {
        System.out.println(JSONObject.class.getClassLoader());
        System.out.println("=======================================");
        System.out.println(System.lineSeparator());
        System.out.println("=======================================");
        System.out.println(System.getProperty("sun.boot.class.path").replaceAll(";", System.lineSeparator()));
        System.out.println("=======================================");
        System.out.println(System.getProperty("java.ext.dirs").replaceAll(";", System.lineSeparator()));
        System.out.println("=======================================");
        System.out.println(System.getProperty("java.class.path").replaceAll(";", System.lineSeparator()));
        System.out.println("=======================================");
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test2() {
        System.out.println(Byte.MAX_VALUE);//1个字节，8位
        System.out.println(Short.MAX_VALUE);//2个字节，16位
        System.out.println(Integer.MAX_VALUE);//4个字节，32位
        System.out.println(Long.MAX_VALUE);//8个字节,64位
        System.out.println("============================");
        System.out.println(count(0));//1
        System.out.println(count(1));//2
        System.out.println(count(2));//4
        System.out.println(count(3));//8
        System.out.println(count(4));//16
        System.out.println("============================");
        //第一位是标志位，0负数，1整数，所以是2的（位数-1）次幂
        System.out.println(count(7) - 1);
        System.out.println(count(15) - 1);
        System.out.println(count(31) - 1);
        System.out.println(count(63) - 1);
    }

    @Test
    public void test3() {
        Long l1 = 127l;
        Long l2 = 127l;
        System.out.println(l1 == l2);//（-128-127之间的值都使用固定的缓存对象，不在这个范围的会重新new一个新的对象，故内存地址不同返回false）

        Integer a = new Integer(127);
        Integer b = new Integer(127);
        Integer c = 127;
        Integer d = 127;
        int e = 127;

        System.out.println(a == b);//比较的内存地址：false（两个都在堆空间，指向不同引用）
        System.out.println(a == c);//比较的内存地址：false(一个在常量池，一个在堆空间)
        System.out.println(c == d);//比较的内存地址：true（-128-127之间的值都使用固定的缓存对象，不在这个范围的会重新new一个新的对象，故内存地址不同返回false）
        System.out.println(c == e);//比较的内存地址：true（都在常量池）
        System.out.println(a.equals(b));//比较值相等：true

        CodeNameDTO CodeNameDTO1 = new CodeNameDTO();
        CodeNameDTO CodeNameDTO2 = new CodeNameDTO();
        System.out.println(CodeNameDTO1 == CodeNameDTO2);//比较的内存地址：false（两个都在堆空间，指向不同引用）
        System.out.println(CodeNameDTO1.equals(CodeNameDTO2));//比较值属性是否完全一样：true
    }

    @Test
    public void test4() {
        String a1 = "abc";
        String a2 = new String("abc");
        System.out.println(a1 == a2);//比较引用是否相等
        System.out.println(a1.equals(a2));//判断值是否相等，true
        System.out.println("==================================");

        String b2 = "456";
        String b1 = "123";
        String b3 = b1 + b2;
        //a，b是变量所以在编译期间是不能确定其值的，所以c的值"123456"并没有加载进常量池
        System.out.println(b3 == "123456");
        System.out.println(b3.equals("123456"));
        System.out.println("==================================");

//        1、被final修饰的常量，在编译阶段会存入调用类的常量池中。
//        2、被final修饰的方法，JVM会尝试为之寻求内联，这对于提升Java的效率是非常重要的。因此，假如能确定方法不会被继承，那么尽量将方法定义为final的。
//        3、final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销
        final String c2 = "456";
        final String c1 = "123";
        String c3 = c1 + c2;
        //因为a、b是常量，所以在编译期间就计算出了字面量"123456"，并加载进常量池
        System.out.println(c3 == "123456");
        System.out.println(c3.equals("123456"));
        System.out.println("==================================");

        String d1 = "123";
        String d2 = "456";
        String d3 = d1 + d2;
        //a，b是变量所以在编译期间是不能确定其值的，此运行时动态加载到常量池，所以c的值"123456"并没有加载进常量池
        String d4 = d3.intern();
        System.out.println(d3 == "123456");
        System.out.println(d4 == "123456");
        System.out.println(d3.equals("123456"));
        System.out.println(d4.equals("123456"));
        System.out.println("==================================");

//        String a= new String("123")+new String("456");
//        //String b= new String("123456");
//        System.out.println(a.intern()==a);
//        System.out.println("==================================");
//
//        a= new String("123")+new String("456");
//        String b= new String("123456");
//        System.out.println(a.intern()==a);
//        System.out.println("==================================");
    }

    @Test
    public void test5() {
        List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> deleteList = Arrays.asList(1, 3, 5);
        //向后遍历
        ListIterator iterator = dataList.listIterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            if (deleteList.contains(value)) {
                iterator.remove();
            }
        }
        dataList.forEach(System.out::println);
        System.out.println("==============");
        //向前遍历
        iterator = dataList.listIterator(dataList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println("==============");
    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }

    @Test
    public void test8() {
        System.out.println(UuidUtil.getStandardUuid());
    }

    @Test
    public void test9() {
        try {
            exec();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void exec() {
        try {
            System.out.println("-------1");
            int a = 2 / 0;
        } finally {
            System.out.println("-------2");
        }
    }

    private long count(int length) {
        long result = 0l;
        if (length == 0) {
            result = 1;
        } else {
            result = 2;
            for (int i = 1; i < length; i++) {
                result = result * 2;
            }
        }
        return result;
    }

    @Test
    public void testSystemTime() {
        log.info("SystemTimeUtil.now()：{}", SystemTimeUtil.now());
        log.info("SystemTimeUtil.nowDate()：{}", SystemTimeUtil.nowDate());

        log.info("Long的最大值：{}", Long.MAX_VALUE);
        log.info("Long的最小值：{}", Long.MIN_VALUE);

        log.info("Integer的最大值：{}", Integer.MAX_VALUE);
        log.info("Integer的最小值：{}", Integer.MIN_VALUE);
    }

    @Test
    public void getDockerImagesText() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hub.c.163.com/library/php               7.2.0RC1-cli        8723dd68a512        16 months ago       354MB\n" +
                "hub.c.163.com/library/python            3.6.2-stretch       1e7990c400bb        17 months ago       907MB\n" +
                "hub.c.163.com/library/logstash          5.5.2               a58603c36465        17 months ago       459MB\n" +
                "hub.c.163.com/library/elasticsearch     5.5.2-alpine        e5a0a6044f71        17 months ago       123MB\n" +
                "hub.c.163.com/library/elasticsearch     5.5.2               7516701e4922        17 months ago       316MB\n" +
                "hub.c.163.com/library/wordpress         4.8.1-apache        dccaeccfba36        17 months ago       406MB\n" +
                "hub.c.163.com/library/rabbitmq          3.6.11              88b79c465d96        17 months ago       124MB\n" +
                "hub.c.163.com/library/node              8.4.0               5e553613f1d8        17 months ago       669MB\n" +
                "hub.c.163.com/library/tomcat            9.0-alpine          08aedc36ee7f        17 months ago       113MB\n" +
                "hub.c.163.com/library/tomcat            8.5.20-alpine       07a52cc3c9e4        17 months ago       113MB\n" +
                "hub.c.163.com/library/httpd             2.4-alpine          c19f964f21e8        18 months ago       87.1MB\n" +
                "hub.c.163.com/library/redis             4.0-alpine          9d8fa9aa0e5b        18 months ago       27.5MB\n" +
                "hub.c.163.com/library/jenkins           2.60.2-alpine       c5fbb5f031fc        18 months ago       223MB\n" +
                "hub.c.163.com/library/jenkins           2.60.2              88d9d8a30b47        18 months ago       810MB\n" +
                "hub.c.163.com/library/mysql             5.5.56              157f9c7bf6c6        20 months ago       256MB\n" +
                "hub.c.163.com/library/nginx             1.13.0              46102226f2fd        21 months ago       109MB\n" +
                "hub.c.163.com/library/mysql             5.7.18              9e64176cd8a2        21 months ago       407MB\n" +
                "hub.c.163.com/library/redis             3.0-alpine          10bf10ebf5f9        2 years ago         12.6MB\n" +
                "hub.c.163.com/library/java              9-jre               b6fcf8ddf0a7        2 years ago         434MB\n" +
                "hub.c.163.com/library/java              9-jdk               1800de06a3eb        2 years ago         579MB\n" +
                "hub.c.163.com/library/java              8u111-jre           07e7184b1bb1        2 years ago         311MB\n" +
                "hub.c.163.com/library/java              6b38-jre            395e0312f5e5        2 years ago         196MB\n" +
                "hub.c.163.com/library/java              8-alpine            d991edd81416        2 years ago         145MB\n" +
                "hub.c.163.com/zhongjianfeng/zookeeper   latest              289214da218a        2 years ago         155MB\n" +
                "hub.c.163.com/lightingfire/nexus        2.13.0-01           95543f26ca31        2 years ago         455MB\n" +
                "hub.c.163.com/public/mongodb            3.2.0               ed27e79af407        2 years ago         378MB\n" +
                "hub.c.163.com/library/redis             2.8.23              a821fb963162        2 years ago         177MB");

        String array[] = stringBuffer.toString().split("\n");
        System.out.println(array.length);
        for (int index = 0, length = array.length; index < length; index++) {
            String str = array[index];
            str = str.replaceAll("              ", " ");
            str = str.replaceAll("             ", " ");
            str = str.replaceAll("            ", " ");
            str = str.replaceAll("           ", " ");
            str = str.replaceAll("          ", " ");
            str = str.replaceAll("         ", " ");
            str = str.replaceAll("        ", " ");
            str = str.replaceAll("       ", " ");
            str = str.replaceAll("      ", " ");
            str = str.replaceAll("     ", " ");
            str = str.replaceAll("    ", " ");
            str = str.replaceAll("   ", " ");
            str = str.replaceAll("  ", " ");
            String data[] = str.split(" ");

            String name = data[0].substring(data[0].lastIndexOf("/") + 1, data[0].length());
            String version = data[1];
            String id = data[2];
            String url = "127.0.0.1:5000/" + name + ":" + version;

            //根据下载的镜像，往私服中推送，且删除本地的，再从私服中下载
            StringBuffer buffer = new StringBuffer();
            buffer.append("docker tag ").append(id).append(" ").append(url).append("\n");
            buffer.append("docker push ").append(url).append("\n");
            buffer.append("docker rmi ").append(url).append("\n");
            buffer.append("docker rmi ").append(id).append("\n");
            buffer.append("docker pull ").append(url).append("\n");
//            System.out.println(buffer.toString());

            //从私服中拉取镜像
            StringBuffer pullBuffer = new StringBuffer();
            pullBuffer.append("docker pull ").append(url);
            System.out.println(pullBuffer.toString());
        }
    }

}
