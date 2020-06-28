package org.tiankafei.base.base.lamda;

/**
 * @Author 魏双双
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class LamdaInterfaceImpl implements ILamdaInterface<Person006> {

    @Override
    public Person006 get() {
        Person006 person006 = new Person006();
        person006.setName("zhangsan");
        return person006;
    }
}
