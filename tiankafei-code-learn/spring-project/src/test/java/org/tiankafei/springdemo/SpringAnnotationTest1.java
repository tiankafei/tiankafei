package org.tiankafei.springdemo;

import org.tiankafei.springdemo.controller.PersonController;
import org.tiankafei.springdemo.dao.impl.PersonDao;
import org.tiankafei.springdemo.service.impl.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringAnnotationTest1 {

    /**
     * 使用注解的方式注册bean到IOC容器中
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        PersonController personController1 = context.getBean(PersonController.class);
        PersonController personController2 = context.getBean(PersonController.class);
        System.out.println(personController1 == personController2);
        PersonService personService1 = context.getBean(PersonService.class);
        PersonService personService2 = context.getBean(PersonService.class);
        System.out.println(personService1 == personService2);
        PersonDao personDao1 = context.getBean(PersonDao.class);
        PersonDao personDao2 = context.getBean(PersonDao.class);
        System.out.println(personDao1 == personDao2);
    }

}
