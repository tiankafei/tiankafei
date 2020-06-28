package cn.tiankafei.java.juc.demo;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo44 {
    private static Thread thread1 = null;
    private static Thread thread2 = null;

    public static void main(String[] args) {
        thread1 = new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                LockSupport.park();
                System.out.println(index);
                LockSupport.unpark(thread2);
            }
        });

        thread2 = new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                System.out.println(str1.substring(index, index + 1));
                LockSupport.unpark(thread1);
                LockSupport.park();
            }
        });

        thread1.start();
        thread2.start();
    }

}
