package org.tiankafei.common.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        new ThreadLocalTest().testThreadLocal();
    }

    private void testThreadLocal() {
        ThreadLocal<Person> tl = new ThreadLocal<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    class Person {
        String name = "zhangsan";
    }

}
