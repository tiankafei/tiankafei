package org.tiankafei.common.ioc.proxy;

/**
 * @Author tiankafei
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class BusinessService implements BusinessInterface {

    @Override
    public void exec() {
        System.out.println("业务逻辑处理代码");
    }

    @Override
    public void process() {
        System.out.println("执行业务处理");
    }

}
