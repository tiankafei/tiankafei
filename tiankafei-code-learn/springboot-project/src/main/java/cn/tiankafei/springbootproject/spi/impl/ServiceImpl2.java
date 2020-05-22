package cn.tiankafei.springbootproject.spi.impl;

import cn.tiankafei.springbootproject.spi.IService;

/**
 * @Author 魏双双
 * @Date 2020/5/21
 * @Version V1.0
 **/
public class ServiceImpl2 implements IService<String, String> {

    @Override
    public String apply(String param) {
        System.out.println("执行了" + this.getClass() + "类，传入的参数为：" + param);
        return "ServiceImpl2";
    }
}