package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest2 {

    /**
     * 给person类添加构造方法
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person001 person001 = (Person001) context.getBean("person1");
        System.out.println(person001);
    }

    /**
     * 在使用构造器赋值的时候可以省略name属性，但是此时就要求必须严格按照构造器参数的顺序来填写了
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person001 person001 = (Person001) context.getBean("person2");
        System.out.println(person001);
    }

}
