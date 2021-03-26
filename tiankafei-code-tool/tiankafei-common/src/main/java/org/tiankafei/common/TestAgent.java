package org.tiankafei.common;

import org.tiankafei.agent.TiankafeiAgent;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TestAgent {

    public static void main(String[] args) {
        System.out.println(TiankafeiAgent.sizeOf(new Object()));
        System.out.println(TiankafeiAgent.sizeOf(new int[] {}));
        System.out.println(TiankafeiAgent.sizeOf(new P()));
    }

    ///
    // 一个 Object 占多少个字节
    // -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
    // Oops = ordinary object pointers

    private static class P {
                        //8 _markword
                        //4 _oop指针
        int id;         //4
        String name;    //4
        int age;        //4

        byte b1;        //1
        byte b2;        //1

        Object o;       //4
        byte b3;        //1

    }

}
