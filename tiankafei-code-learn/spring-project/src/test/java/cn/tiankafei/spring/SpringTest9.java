package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest9 {

    /**
     * 利用实例工厂模式创建bean对象
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc8.xml");
        Person001 person001 = (Person001) context.getBean("person6");
        System.out.println(person001);
    }

}
