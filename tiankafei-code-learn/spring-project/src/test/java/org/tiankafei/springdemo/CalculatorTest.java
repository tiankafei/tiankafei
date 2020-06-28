package org.tiankafei.springdemo;

import org.tiankafei.springdemo.inter.Calculator;
import org.tiankafei.springdemo.inter.impl.MyCalculator;
import org.tiankafei.springdemo.inter.impl.MyCalculator1;
import org.tiankafei.springdemo.inter.impl.MyCalculator2;
import org.tiankafei.springdemo.inter.proxy.CalculatorProxy;
import org.tiankafei.springdemo.inter.proxy.CalculatorProxy1;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class CalculatorTest {

    @Test
    public void test01(){
        MyCalculator myCalculator = new MyCalculator();
        System.out.println(myCalculator.add(1, 2));
    }

    @Test
    public void test02(){
        MyCalculator1 myCalculator = new MyCalculator1();
        System.out.println(myCalculator.add(1, 2));
    }

    @Test
    public void test03(){
        MyCalculator2 myCalculator = new MyCalculator2();
        System.out.println(myCalculator.add(1, 2));
    }

    @Test
    public void test04(){
        Calculator calculator = new MyCalculator2();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        System.out.println(proxy.add(1, 2));
    }

    @Test
    public void test05(){
        Calculator calculator = new MyCalculator2();
        Calculator proxy = CalculatorProxy1.getProxy(calculator);
        System.out.println(proxy.add(1, 2));
    }

}
