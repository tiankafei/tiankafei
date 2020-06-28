package org.tiankafei.base.base.juc.sync;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TestSynchronized01 {

    private static volatile int num = 0;

    public static void main(String[] args) {


    }

    private synchronized static void exe21() {

    }

    private static void exe22() {
        synchronized (TestSynchronized01.class) {

        }
    }

    private synchronized void exe11() {

    }

    private void exe12() {
        synchronized (this) {

        }
    }

}
