package cn.tiankafei.base.juc.phaser;

import java.util.concurrent.Phaser;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class Phaser1 {

    private MarriagePhaser marriagePhaser = new MarriagePhaser();

    public static void main(String[] args) {
        Phaser1 phaser1 = new Phaser1();
        phaser1.execute();
    }

    private void execute() {
        int length = 10;
        marriagePhaser.bulkRegister(length);
        for (int i = 0; i < length; i++) {
            new Thread(() -> {
                System.out.println("第一步");
                marriagePhaser.arriveAndAwaitAdvance();

                System.out.println("第二步");
                marriagePhaser.arriveAndAwaitAdvance();

                System.out.println("第三步");
                marriagePhaser.arriveAndAwaitAdvance();

                System.out.println("第四步");
                marriagePhaser.arriveAndAwaitAdvance();
            }).start();
        }
    }

    class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("第一步完成了");
                    return false;
                case 1:
                    System.out.println("第二步完成了");
                    return false;
                case 2:
                    System.out.println("第三步完成了");
                    return false;
                case 3:
                    System.out.println("第四步完成了");
                    return true;
                default:
                    return true;
            }
        }
    }

}
