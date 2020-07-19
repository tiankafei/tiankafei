package org.tiankafei.base.lamda;

/**
 * @Author 魏双双
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class LamdaInterfaceTest<T> {

    private ILamdaInterface<T> lamdaInterface;

    public LamdaInterfaceTest(ILamdaInterface<T> lamdaInterface) {
        this.lamdaInterface = lamdaInterface;
    }

    public T get() {
        return lamdaInterface.get();
    }

    public static void main(String[] args) {
        ILamdaInterface lamdaInterface = new LamdaInterfaceImpl();
        LamdaInterfaceTest<Person006> lamdaInterfaceTest = new LamdaInterfaceTest<>(lamdaInterface);
        System.out.println(lamdaInterfaceTest.get());

        LamdaInterfaceTest<Person006> lamdaInterfaceTest1 = new LamdaInterfaceTest<>(Person006::new);
        System.out.println(lamdaInterfaceTest1.get());
    }

}
