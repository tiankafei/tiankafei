package cn.tiankafei.spring;

import cn.tiankafei.spring.controller.PersonController;
import cn.tiankafei.spring.dao.impl.PersonDao;
import cn.tiankafei.spring.service.impl.PersonService;
import cn.tiankafei.spring.service.impl.PersonServiceExt;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringAnnotationTest3 {

    /**
     * 使用@AutoWired进行自动注入
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
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

    /**
     * 注意：当使用AutoWired注解的时候，自动装配的时候是根据类型实现的。
     * ​		1、如果只找到一个，则直接进行赋值，
     * ​		2、如果没有找到，则直接抛出异常，
     * ​		3、如果找到多个，那么会按照变量名作为id继续匹配,
     * ​				1、匹配上直接进行装配
     * ​				2、如果匹配不上则直接报异常
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        PersonController personController1 = context.getBean(PersonController.class);
        PersonController personController2 = context.getBean(PersonController.class);
        System.out.println(personController1 == personController2);
        PersonServiceExt personService1 = context.getBean(PersonServiceExt.class);
        PersonServiceExt personService2 = context.getBean(PersonServiceExt.class);
        System.out.println(personService1 == personService2);
        PersonDao personDao1 = context.getBean(PersonDao.class);
        PersonDao personDao2 = context.getBean(PersonDao.class);
        System.out.println(personDao1 == personDao2);
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        PersonController personController1 = context.getBean(PersonController.class);
        PersonController personController2 = context.getBean(PersonController.class);
        System.out.println(personController1 == personController2);
        PersonServiceExt personService1 = context.getBean(PersonServiceExt.class);
        PersonServiceExt personService2 = context.getBean(PersonServiceExt.class);
        System.out.println(personService1 == personService2);
        PersonDao personDao1 = context.getBean(PersonDao.class);
        PersonDao personDao2 = context.getBean(PersonDao.class);
        System.out.println(personDao1 == personDao2);
    }

    /**
     * @AutoWired可以进行定义在方法上
     */
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        PersonServiceExt personService1 = context.getBean(PersonServiceExt.class);
        PersonServiceExt personService2 = context.getBean(PersonServiceExt.class);
        System.out.println(personService1 == personService2);
        PersonDao personDao1 = context.getBean(PersonDao.class);
        PersonDao personDao2 = context.getBean(PersonDao.class);
        System.out.println(personDao1 == personDao2);

        PersonController personController1 = context.getBean(PersonController.class);
        PersonController personController2 = context.getBean(PersonController.class);
        System.out.println(personController1 == personController2);
        personController1.test(personDao1);
        personController1.test2(personService1);
    }

}
