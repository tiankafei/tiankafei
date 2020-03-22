package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RandomFunctionUnitTest {

    @Test
    public void testCall() {
        RandomFunction rand = new RandomFunction();
        BaseAviatorObject result = rand.call(null);
        assertTrue(result instanceof AviatorDouble);
        assertFalse(result.getValue(null).equals(rand.call(null)));
    }


    public void testCallWithOneArg() {
        RandomFunction rand = new RandomFunction();
        BaseAviatorObject result = rand.call(null, new AviatorRuntimeJavaType(1));
        assertTrue(((Integer) result.getValue(null)) < 1);
        assertTrue(((Integer) result.getValue(null)) >= 0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCallIllegalArgument() {
        RandomFunction rand = new RandomFunction();
        BaseAviatorObject result =
                rand.call(null, new AviatorRuntimeJavaType(1), new AviatorRuntimeJavaType(2));
    }
}
