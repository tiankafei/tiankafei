package org.tiankafei.base.juc.lock;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class PhaserTest {
    MarriagePhaser phaser = new MarriagePhaser();

    public static void main(String[] args) {
        new PhaserTest().testPhaser();
    }

    private void testPhaser() {
        phaser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {
            final int nameIndex = i;
            new Thread(() -> {

                Person p = new Person("person " + nameIndex);
                p.arrive();
                phaser.arriveAndAwaitAdvance();

                p.eat();
                phaser.arriveAndAwaitAdvance();

                p.leave();
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
    }


    class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！");
                    return false;
                case 1:
                    System.out.println("所有人吃完了！");
                    return false;
                case 2:
                    System.out.println("所有人离开了！");
                    System.out.println("婚礼结束！");
                    return true;
                default:
                    return true;
            }
        }
    }

    class Person {
        String name;
        Random r = new Random();

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
        }

        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
        }

        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
        }

        void milliSleep(int milli) {
            try {
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
