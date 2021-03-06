package org.tiankafei.springdemo;

import org.tiankafei.springdemo.inter.Calculator;
import org.tiankafei.springdemo.inter.impl.MyCalculator3;
import org.tiankafei.springdemo.inter.impl.MyCalculator4;
import org.tiankafei.springdemo.inter.impl.MyCalculator5;
import org.tiankafei.springdemo.inter.impl.MyCalculator6;
import org.tiankafei.springdemo.inter.impl.MyCalculator7;
import org.tiankafei.springdemo.inter.impl.MyCalculator8;
import org.tiankafei.springdemo.inter.impl.MyCalculator9;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SpringAnnotationTest4 {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        Calculator calculator = context.getBean(Calculator.class);
        System.out.println(calculator.add(1, 1));
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator3 bean = context.getBean(MyCalculator3.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator4 bean = context.getBean(MyCalculator4.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator5 bean = context.getBean(MyCalculator5.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator6 bean = context.getBean(MyCalculator6.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator7 bean = context.getBean(MyCalculator7.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test07(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator7 bean = context.getBean(MyCalculator7.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test08(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        MyCalculator8 bean = context.getBean(MyCalculator8.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @Test
    public void test09(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
        MyCalculator9 bean = context.getBean(MyCalculator9.class);
        System.out.println(bean.add(1, 1));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

}
