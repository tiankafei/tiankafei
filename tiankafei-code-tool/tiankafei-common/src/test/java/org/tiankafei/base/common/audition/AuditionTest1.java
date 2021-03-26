package org.tiankafei.base.common.audition;

/**
 * @Author tiankafei
 * @Date 2020/3/19
 * @Version V1.0
 **/
public class AuditionTest1 {

    public static void main(String[] args) throws Exception {
        Class clazz = AuditionTest1.class;
        Object o1 = clazz.getConstructor().newInstance();
        System.out.println(o1);
    }

}
