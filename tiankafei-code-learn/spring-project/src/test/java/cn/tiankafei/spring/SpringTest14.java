package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person003;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest14 {

    /**
     * spring基于xml文件的自动装配
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc13.xml");
        Person003 person1 = (Person003) context.getBean("person");
        System.out.println(person1);

        Person003 person2 = (Person003) context.getBean("person2");
        System.out.println(person2);

        Person003 person3 = (Person003) context.getBean("person3");
        System.out.println(person3);

        //applicationContext没有close方法，需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }


}
