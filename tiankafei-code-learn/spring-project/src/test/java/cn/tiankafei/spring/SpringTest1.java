package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest1 {

    @Test
    public void test01(){
        //ApplicationContext:表示ioc容器
        //ClassPathXmlApplicationContext:表示从当前classpath路径中获取xml文件的配置
        //根据spring的配置文件来获取ioc容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test02(){
        //ApplicationContext:表示ioc容器
        //ClassPathXmlApplicationContext:表示从当前classpath路径中获取xml文件的配置
        //根据spring的配置文件来获取ioc容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

}
