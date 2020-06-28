package org.tiankafei.springdemo;

import org.tiankafei.springdemo.controller.Person1Controller;
import org.tiankafei.springdemo.controller.PersonController;
import org.tiankafei.springdemo.dao.impl.PersonDao;
import org.tiankafei.springdemo.service.impl.PersonService;
import org.tiankafei.springdemo.service.impl.PersonServiceExt;
import org.tiankafei.springdemo.service.impl.StudentService;
import org.tiankafei.springdemo.service.impl.TeacherService;
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

    /**
     * 自动装配的注解@AutoWired，@Resource
     *
     * 在使用自动装配的时候，出了可以使用@AutoWired注解之外，还可以使用@Resource注解，大家需要知道这两个注解的区别。
     *
     * 1. @AutoWired:是spring中提供的注解，@Resource:是jdk中定义的注解，依靠的是java的标准
     * 2. @AutoWired默认是按照类型进行装配，默认情况下要求依赖的对象必须存在，@Resource默认是按照名字进行匹配的，同时可以指定name属性。
     * 3. @AutoWired只适合spring框架，而@Resource扩展性更好
     *
     */
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        PersonServiceExt personService1 = context.getBean(PersonServiceExt.class);
        PersonServiceExt personService2 = context.getBean(PersonServiceExt.class);
        System.out.println(personService1 == personService2);
        PersonDao personDao1 = context.getBean(PersonDao.class);
        PersonDao personDao2 = context.getBean(PersonDao.class);
        System.out.println(personDao1 == personDao2);

        Person1Controller personController1 = context.getBean(Person1Controller.class);
        Person1Controller personController2 = context.getBean(Person1Controller.class);
        System.out.println(personController1 == personController2);
        personController1.test(personDao1);
        personController1.test2(personService1);
    }

    /**
     * 泛型依赖注入
     */
    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        StudentService studentService = context.getBean("studentService",StudentService.class);
        studentService.save();

        TeacherService teacherService = context.getBean("teacherService",TeacherService.class);
        teacherService.save();
    }
}
