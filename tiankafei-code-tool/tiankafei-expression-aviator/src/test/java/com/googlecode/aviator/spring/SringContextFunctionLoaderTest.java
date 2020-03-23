package com.googlecode.aviator.spring;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SringContextFunctionLoaderTest {

    private SpringContextFunctionLoader loader;

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        loader = new SpringContextFunctionLoader(ctx);
        AviatorEvaluator.addFunctionLoader(loader);
    }

//    @Test(expected = Exception.class)
//    public void testAdd() {
//        assertEquals(100, AviatorEvaluator.getInstance().exec("springAdd(x,y)", 1, 99));
//    }

    @AfterClass
    public static void tearDown() {
        AviatorEvaluator.addFunctionLoader(null);
    }

}
