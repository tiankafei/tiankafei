package com.googlecode.aviator.runtime.function.string;

import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StringStartsWithFunctionUnitTest {
    private StringStartsWithFunction function;


    @Before
    public void setUp() {
        this.function = new StringStartsWithFunction();
    }


    @Test
    public void testCall() {
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("s1", "hello");
        env.put("s2", "he");
        env.put("ch", 'h');
        env.put("temp", "temp");

        assertTrue((Boolean) this.function
                .call(null, new AviatorString("hello"), new AviatorString("hel")).getValue(null));
        assertFalse((Boolean) this.function
                .call(null, new AviatorString("hello"), new AviatorString("world")).getValue(null));
        assertTrue((Boolean) this.function
                .call(env, new AviatorString("hello"), new AviatorJavaType("s2")).getValue(env));
        assertTrue((Boolean) this.function
                .call(env, new AviatorString("hello"), new AviatorJavaType("ch")).getValue(env));
        assertTrue((Boolean) this.function
                .call(env, new AviatorJavaType("s1"), new AviatorJavaType("s2")).getValue(env));
        assertFalse((Boolean) this.function
                .call(env, new AviatorJavaType("s1"), new AviatorJavaType("temp")).getValue(env));
        assertTrue((Boolean) this.function
                .call(env, new AviatorJavaType("s1"), new AviatorJavaType("ch")).getValue(env));
        assertTrue((Boolean) this.function
                .call(env, new AviatorJavaType("s1"), new AviatorString("hel")).getValue(env));
    }
}
