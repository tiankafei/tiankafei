package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest1 {

    /**
     * 通过bean的id获取IOC容器中的对象
     */
    @Test
    public void test01(){
        //ApplicationContext:表示ioc容器
        //ClassPathXmlApplicationContext:表示从当前classpath路径中获取xml文件的配置
        //根据spring的配置文件来获取ioc容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person001 person001 = (Person001) context.getBean("person001");
        System.out.println(person001);
    }

    /**
     * 通过bean的类型获取对象
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person001 bean = context.getBean(Person001.class);
        System.out.println(bean);
    }

    /**
     * 通过bean的id和bean的类型获取IOC容器中的对象
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person001 person001 = context.getBean("person001", Person001.class);
        System.out.println(person001);
    }

}
