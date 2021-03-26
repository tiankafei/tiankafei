package org.tiankafei.base.common.proxy;

/**
 * @Author tiankafei
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class BusinessStaticProxy {

    private BusinessInterface businessInterface;

    public BusinessStaticProxy() {
        this.businessInterface = new BusinessService();
    }

    public void exec() {
        System.out.println("静态代理前的处理");
        businessInterface.exec();
        System.out.println("静态代理后的处理");
    }

    public void process() {
        System.out.println("静态代理前的处理");
        businessInterface.process();
        System.out.println("静态代理后的处理");
    }

}
