package cn.tiankafei.base.juc.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo48 {

    private static AtomicInteger atomicInteger = new AtomicInteger(2);

    public static void main(String[] args) {

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                while (atomicInteger.get() != 1) {
                }
                System.out.println(index);
                atomicInteger.set(2);
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                while (atomicInteger.get() != 2) {
                }
                System.out.println(str1.substring(index, index + 1));
                atomicInteger.set(1);
            }
        }).start();

    }

}
