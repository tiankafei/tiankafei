package org.tiankafei.base.util;

import java.util.concurrent.TimeUnit;

/**
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class ThreadSleepUtil {

    public static void sleepMilliSeconds(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSeconds(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMinutes(int time) {
        try {
            TimeUnit.MINUTES.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepHours(int time) {
        try {
            TimeUnit.HOURS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
