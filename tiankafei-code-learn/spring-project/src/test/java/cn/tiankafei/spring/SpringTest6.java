package cn.tiankafei.spring;

import cn.tiankafei.spring.entity.Address;
import cn.tiankafei.spring.entity.Book;
import cn.tiankafei.spring.entity.Person001;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringTest6 {

    /**
     * bean对象创建的依赖关系
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc5.xml");
        Person001 person001 = (Person001) context.getBean("person");
        System.out.println(person001);

        Address address = (Address) context.getBean("address");
        System.out.println(address);

        Book book = (Book) context.getBean("book");
        System.out.println(book);
    }

}
