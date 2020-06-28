package cn.tiankafei.java.juc.threadpool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolTest1 {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("---" + Arrays.stream(nums).sum()); //stream api
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp = new ForkJoinPool();
        AddAction task = new AddAction(0, nums.length);
        fjp.execute(task);

        System.in.read();
    }

    static class AddAction extends RecursiveAction {
        int start, end;

        AddAction(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) sum += nums[i];
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                AddAction subTask1 = new AddAction(start, middle);
                AddAction subTask2 = new AddAction(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

}
