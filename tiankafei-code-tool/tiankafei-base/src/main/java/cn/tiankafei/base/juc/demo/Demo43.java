package cn.tiankafei.base.juc.demo;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo43 {

    private static Object lock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println(index);
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                synchronized (lock) {
                    try {
                        System.out.println(str1.substring(index, index + 1));
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
