package org.tiankafei.base;

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
