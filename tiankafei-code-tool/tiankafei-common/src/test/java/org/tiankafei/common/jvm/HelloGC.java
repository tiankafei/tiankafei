package org.tiankafei.common.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * -Xmn10M
 * -Xms40M
 * -Xmx60M
 * -XX:+PrintCommandLineFlags
 * -XX:+PrintGC
 * -verbose:class
 * -XX:+DisableExplictGC
 *
 * @Author tiankafei
 * @Date 2020/3/15
 * @Version V1.0
 **/
public class HelloGC {

    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }

}
