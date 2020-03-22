package com.googlecode.aviator.runtime.function.math;

import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MathLog10FunctionUnitTest extends BaseMathFunctionUnitTestForOneArgument {
    @Before
    public void setUp() {
        this.function = new MathLog10Function();
    }


    @Test(expected = AssertionError.class)
    public void testCall() {
        assertEquals(2.0, this.function.call(null, BaseAviatorNumber.valueOf(100)).getValue(null));
        assertEquals(3.0, this.function.call(null, BaseAviatorNumber.valueOf(1000)).getValue(null));
        assertEquals(2.60, this.function.call(null, BaseAviatorNumber.valueOf(400)).getValue(null));

        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 10000);
        env.put("b", 9.0);

        assertEquals(4.0, this.function.call(env, new AviatorJavaType("a")).getValue(null));
        assertEquals(0.9542, this.function.call(env, new AviatorJavaType("b")).getValue(null));
    }

}

