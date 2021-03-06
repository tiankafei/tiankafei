package org.tiankafei.springdemo;

import org.tiankafei.springdemo.entity.Person001;
import org.tiankafei.springdemo.entity.Person002;
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

    /**
     * 如果想不按照顺序来添加参数值，那么可以搭配index属性来使用
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person001 person001 = (Person001) context.getBean("person3");
        System.out.println(person001);
    }

    /**
     * 当有多个参数个数相同，不同类型的构造器的时候，可以通过type来强制类型
     */
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person001 person001 = (Person001) context.getBean("person4");
        System.out.println(person001);
    }

    /**
     * 如果不修改为integer类型，那么需要type跟index组合使用
     */
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person002 person002 = (Person002) context.getBean("person5");
        System.out.println(person002);
    }

    /**
     * 通过命名空间为bean赋值，简化配置文件中属性声明的写法
     */
    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        Person001 person001 = (Person001) context.getBean("person6");
        System.out.println(person001);
    }

}
