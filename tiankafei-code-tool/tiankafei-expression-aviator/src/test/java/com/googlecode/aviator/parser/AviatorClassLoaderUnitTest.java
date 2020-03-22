package com.googlecode.aviator.parser;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.HashMap;


public class AviatorClassLoaderUnitTest {

    @Test
    public void testManyManyExpressions() {
        for (int i = 0; i < 10000; i++) {
            HashMap<String, Object> env = new HashMap<String, Object>();
            env.put("a" + i, i);
            env.put("b" + i, i - 1);
            AviatorEvaluator.execute("a" + i + ">b" + i, env);
        }
    }
}
