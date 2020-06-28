package org.tiankafei.hadoop;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author tiankafei
 * @Date 2019/12/14
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip);

    }

}
