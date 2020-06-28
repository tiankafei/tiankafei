package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest10 {

    /**
     * 继承FactoryBean来创建对象
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc9.xml");
        Person001 person001 = (Person001) context.getBean("myfactorybean");
        System.out.println(person001);
    }

}
