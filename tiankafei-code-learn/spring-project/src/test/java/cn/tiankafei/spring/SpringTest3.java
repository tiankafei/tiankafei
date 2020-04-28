package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person003;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest3 {

    /**
     * 给复杂类型的赋值都在property标签内进行
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc2.xml");
        Person003 person003 = (Person003) context.getBean("person");
        System.out.println(person003);
    }

}
