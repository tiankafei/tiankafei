package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.TestUtils;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import com.googlecode.aviator.utils.Env;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BinaryFunctionUnitTest {

    private Env env;

    @Before
    public void setup() {
        env = TestUtils.getTestEnv();
    }

    @Test
    public void testAddFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.ADD);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L), AviatorLong.valueOf(11L));
        assertEquals(21L, (Long) result.getValue(null), 0L);

    }


    @Test
    public void testSubFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.SUB);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L), AviatorLong.valueOf(11L));
        assertEquals(-1L, (Long) result.getValue(null), 0L);

    }


    @Test
    public void testMultFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.MULT);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L), AviatorLong.valueOf(11L));
        assertEquals(110L, (Long) result.getValue(null), 0L);

    }


    @Test
    public void testDivFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.DIV);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L), AviatorLong.valueOf(11L));
        assertEquals(0, (Long) result.getValue(null), 0.00);

    }


    @Test
    public void testModFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.MOD);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L), AviatorLong.valueOf(11L));
        assertEquals(10L, (Long) result.getValue(null), 0L);

    }


    @Test
    public void testNegFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.NEG);
        BaseAviatorObject result = fun.call(env, AviatorLong.valueOf(10L));
        assertEquals(-10L, (Long) result.getValue(null), 0L);

    }


    @Test
    public void testNotFunction() {
        BinaryFunction fun = new BinaryFunction(OperatorType.NOT);
        BaseAviatorObject result = fun.call(env, AviatorBoolean.FALSE);
        assertTrue((Boolean) result.getValue(null));

    }
}
