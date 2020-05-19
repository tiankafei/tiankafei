package cn.tiankafei.base.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class Phaser2 {

    private Random r = new Random();
    private MarriagePhaser marriagePhaser = new MarriagePhaser();

    public static void main(String[] args) {
        Phaser2 phaser1 = new Phaser2();
        phaser1.execute();
    }

    private void execute() {
        int length = 10 + 2;
        marriagePhaser.bulkRegister(length);
        for (int i = 0; i < length; i++) {

            new Thread(new Person("p" + i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }

    class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {

            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
            marriagePhaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
            marriagePhaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);


            marriagePhaser.arriveAndAwaitAdvance();
        }

        private void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                milliSleep(r.nextInt(1000));
                System.out.printf("%s 洞房！\n", name);
                marriagePhaser.arriveAndAwaitAdvance();
            } else {
                marriagePhaser.arriveAndDeregister();
                //phaser.register()
            }
        }

        @Override
        public void run() {
            arrive();


            eat();


            leave();


            hug();

        }
    }

    void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
