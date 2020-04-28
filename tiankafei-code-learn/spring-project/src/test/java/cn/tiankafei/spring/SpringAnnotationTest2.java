package cn.tiankafei.spring;

import cn.tiankafei.spring.service.impl.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringAnnotationTest2 {

    /**
     * 定义扫描包时要包含的类和不要包含的类
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
//        PersonController personController1 = context.getBean(PersonController.class);
//        PersonController personController2 = context.getBean(PersonController.class);
//        System.out.println(personController1 == personController2);
        PersonService personService1 = context.getBean(PersonService.class);
        PersonService personService2 = context.getBean(PersonService.class);
        System.out.println(personService1 == personService2);
//        PersonDao personDao1 = context.getBean(PersonDao.class);
//        PersonDao personDao2 = context.getBean(PersonDao.class);
//        System.out.println(personDao1 == personDao2);
    }

}
