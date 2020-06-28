package org.tiankafei.java.juc.demo;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo47 {

    enum T {T1, T2}

    private static volatile T t = T.T2;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                while (t != T.T1) {
                }
                System.out.println(index);
                t = T.T2;
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                while (t != T.T2) {
                }
                System.out.println(str1.substring(index, index + 1));
                t = T.T1;
            }
        }).start();

    }

}
