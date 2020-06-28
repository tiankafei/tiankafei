package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest7 {

    /**
     * bean的作用域控制，是否是单例，虽然hashcode相同，是因为重写了hashcode方法，指向了两块不同的内存
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc6.xml");
        Person001 person001 = (Person001) context.getBean("person");
        System.out.println(person001);
        System.out.println(person001.hashCode());

        Person001 person002 = (Person001) context.getBean("person");
        System.out.println(person002);
        System.out.println(person002.hashCode());

        System.out.println(person001 == person002);
    }

}
