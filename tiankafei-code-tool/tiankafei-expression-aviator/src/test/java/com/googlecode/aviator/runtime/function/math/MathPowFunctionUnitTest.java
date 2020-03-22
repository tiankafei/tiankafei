package com.googlecode.aviator.runtime.function.math;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.googlecode.aviator.runtime.type.BaseAviatorNumber;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class MathPowFunctionUnitTest {
    AviatorFunction function;


    @Before
    public void setUp() {
        this.function = new MathPowFunction();
    }


    @Test
    public void testCall() {
        assertEquals(Math.pow(3, 2), this.function
                .call(null, BaseAviatorNumber.valueOf(3), BaseAviatorNumber.valueOf(2)).getValue(null));
        assertEquals(Math.pow(10.9, 4.0), this.function
                .call(null, BaseAviatorNumber.valueOf(10.9), BaseAviatorNumber.valueOf(4.0)).getValue(null));
        assertEquals(Math.pow(20, -3), this.function
                .call(null, BaseAviatorNumber.valueOf(20), BaseAviatorNumber.valueOf(-3)).getValue(null));

        assertEquals(new BigInteger("1000000000000000000000000000000000000").pow(3),
                this.function.call(null,
                        BaseAviatorNumber.valueOf(new BigInteger("1000000000000000000000000000000000000")),
                        BaseAviatorNumber.valueOf(3)).getValue(null));

        assertEquals(new BigDecimal("1000000000000000000000000000000000000.000022222").pow(3),
                this.function.call(null,
                        BaseAviatorNumber
                                .valueOf(new BigDecimal("1000000000000000000000000000000000000.000022222")),
                        BaseAviatorNumber.valueOf(3)).getValue(null));

        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 3.0);
        env.put("b", 9.0);

        assertEquals(Math.pow(3.0, 9.0),
                this.function.call(env, new AviatorJavaType("a"), new AviatorJavaType("b")).getValue(null));
        assertEquals(Math.pow(9.0, 4),
                this.function.call(env, new AviatorJavaType("b"), BaseAviatorNumber.valueOf(4)).getValue(null));
        assertEquals(Math.pow(-2.3, 3.0), this.function
                .call(env, BaseAviatorNumber.valueOf(-2.3), new AviatorJavaType("a")).getValue(null));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testZeroArgument() {
        this.function.call(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_OneArugments() {
        this.function.call(null, BaseAviatorNumber.valueOf(3.2));
    }


    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        this.function.call(null, AviatorNil.NIL, AviatorNil.NIL);
    }


    @Test(expected = ClassCastException.class)
    public void testClassCastError1() {
        this.function.call(null, AviatorBoolean.TRUE, BaseAviatorNumber.valueOf(3.2));
    }


    @Test(expected = ClassCastException.class)
    public void testClassCastError2() {
        this.function.call(null, BaseAviatorNumber.valueOf(3.2), new AviatorString("hello"));
    }
}
