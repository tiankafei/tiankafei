package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest5 {

    /**
     * 如果想实现Java文件的抽象类，不需要将当前bean实例化的话，可以使用abstract属性
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc4.xml");
        Person001 person001 = (Person001) context.getBean("person2");
        System.out.println(person001);
    }

}
