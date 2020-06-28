package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest4 {

    /**
     * 继承关系bean的配置
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc3.xml");
        Person001 person001 = (Person001) context.getBean("person");
        System.out.println(person001);
        Person001 person002 = (Person001) context.getBean("person2");
        System.out.println(person002);
    }

}
