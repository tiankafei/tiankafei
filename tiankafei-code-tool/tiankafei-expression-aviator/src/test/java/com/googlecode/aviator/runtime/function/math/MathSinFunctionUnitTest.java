package com.googlecode.aviator.runtime.function.math;

import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class MathSinFunctionUnitTest extends BaseMathFunctionUnitTestForOneArgument {
    @Before
    public void setUp() {
        this.function = new MathSinFunction();
    }


    @Test
    public void testCall() {
        assertEquals(Math.sin(30), this.function.call(null, BaseAviatorNumber.valueOf(30)).getValue(null));
        assertEquals(Math.sin(1020.999),
                this.function.call(null, BaseAviatorNumber.valueOf(1020.999)).getValue(null));
        assertEquals(Math.sin(400),
                this.function.call(null, BaseAviatorNumber.valueOf(400)).getValue(null));

        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 10000);
        env.put("b", 9.0);

        assertEquals(Math.sin(10000), this.function.call(env, new AviatorJavaType("a")).getValue(null));
        assertEquals(Math.sin(9.0), this.function.call(env, new AviatorJavaType("b")).getValue(null));
    }

}
