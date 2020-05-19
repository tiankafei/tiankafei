package cn.tiankafei.base.juc.vola;

import cn.tiankafei.base.util.ThreadSleepUtil;

/**
 * volatile可以技术数据类型在线程之间可见
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class Volatile1 {

    private volatile boolean flag = true;

    public static void main(String[] args) {
        Volatile1 vola = new Volatile1();
//        new Thread(vola::changeValue, "t1").start();

        new Thread(() -> {
            vola.changeValue();
        }).start();
        vola.execute();
    }

    public void execute() {
        ThreadSleepUtil.sleepSeconds(1);
        this.flag = false;
    }

    public void changeValue() {
        System.out.println("修改值之前输出..................");
        while (flag) {

        }
    }

}
