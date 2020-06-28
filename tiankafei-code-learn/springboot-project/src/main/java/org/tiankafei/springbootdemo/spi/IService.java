package org.tiankafei.springbootdemo.spi;

/**
 * @Author 魏双双
 * @Date 2020/5/21
 * @Version V1.0
 **/
public interface IService<R, T> {

    R apply(T t);

}
