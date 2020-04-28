package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Address;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest12 {

    /**
     * b配置bean对象初始化方法的前后处理方法
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc11.xml");
        Address address = (Address) context.getBean("address");
        System.out.println(address);

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }

}
