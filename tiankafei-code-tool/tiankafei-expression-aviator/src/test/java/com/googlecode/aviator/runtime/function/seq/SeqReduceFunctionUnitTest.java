package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.TestUtils;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import com.googlecode.aviator.utils.Env;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SeqReduceFunctionUnitTest {

    private Env env;

    @Before
    public void setup() {
        this.env = TestUtils.getTestEnv();
    }

    @Test(expected = AssertionError.class)
    public void testReduce_Array() {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        SeqReduceFunction fun = new SeqReduceFunction();
        BaseAviatorObject result = fun.call(env, new AviatorRuntimeJavaType(a), new AviatorJavaType("+"),
                new AviatorRuntimeJavaType(0));
        assertNotNull(result);
        assertEquals(45, result.getValue(null));

    }


    @Test(expected = ExpressionRuntimeException.class)
    public void testReduce_NullArray() {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] = i;
            }
        }

        SeqReduceFunction fun = new SeqReduceFunction();
        BaseAviatorObject result = fun.call(env, new AviatorRuntimeJavaType(a), new AviatorJavaType("+"),
                new AviatorRuntimeJavaType(0));

    }


    @Test(expected = AssertionError.class)
    public void testReduce_Collection() {
        LinkedHashSet<Integer> a = new LinkedHashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }

        SeqReduceFunction fun = new SeqReduceFunction();
        BaseAviatorObject result = fun.call(env, new AviatorRuntimeJavaType(a), new AviatorJavaType("+"),
                new AviatorRuntimeJavaType(0));
        assertNotNull(result);
        assertEquals(45, result.getValue(null));

    }


    @Test(expected = IllegalArgumentException.class)
    public void testReduce_IllegalArguments() {
        LinkedHashSet<Integer> a = new LinkedHashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }

        SeqReduceFunction fun = new SeqReduceFunction();
        BaseAviatorObject result = fun.call(env, new AviatorRuntimeJavaType(a), new AviatorJavaType("+"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testReduce_String() {

        SeqReduceFunction fun = new SeqReduceFunction();
        BaseAviatorObject result = fun.call(AviatorEvaluator.newInstance().getFuncMap(), new AviatorRuntimeJavaType("hello"),
                new AviatorJavaType("+"), new AviatorRuntimeJavaType(0));
    }

}
