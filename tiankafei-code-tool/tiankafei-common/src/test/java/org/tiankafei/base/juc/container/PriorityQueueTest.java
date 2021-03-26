package org.tiankafei.base.juc.container;

import java.util.PriorityQueue;

/**
 * @Author 魏双双
 * @Date 2020/5/7
 * @Version V1.0
 **/
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        //入列
        q.offer("1");
        q.offer("2");
        q.offer("5");
        q.offer("3");
        q.offer("4");

        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5
    }

}
