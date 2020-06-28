package org.tiankafei.java.juc.demo;

import java.util.concurrent.Exchanger;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo50 {

    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                try {
                    System.out.println(exchanger.exchange(index));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                try {
                    System.out.println(exchanger.exchange(str1.substring(index, index + 1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
