package org.tiankafei.springbootdemo.spi.impl;

import org.tiankafei.springbootdemo.spi.IService;

/**
 * @Author 魏双双
 * @Date 2020/5/21
 * @Version V1.0
 **/
public class ServiceImpl1 implements IService<String, String> {

    @Override
    public String apply(String param) {
        String str = "执行了" + this.getClass() + "类，传入的参数为：" + param;
        System.out.println(str);
        return "ServiceImpl1 " + str;
    }
}
