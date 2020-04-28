package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Address;
import cn.tiankafei.spring.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest11 {

    /**
     * bean对象的初始化和销毁方法
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc10.xml");
        Address address = (Address) context.getBean("address");
        System.out.println(address);

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }

}
