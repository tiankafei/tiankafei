package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person003;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest15 {

    /**
     * SpEL的使用
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc14.xml");
        Person003 person4 = (Person003) context.getBean("person4");
        System.out.println(person4);

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }


}
