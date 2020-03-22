package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;


public class SeqCountFunctionUnitTest {

    @Test(expected = AssertionError.class)
    public void testCount_Array() {
        BaseAviatorObject[] args = new BaseAviatorObject[1];
        args[0] = new AviatorRuntimeJavaType(new String[10]);
        SeqCountFunction fun = new SeqCountFunction();
        BaseAviatorObject result = fun.call(null, new AviatorRuntimeJavaType(new String[10]));
        assertEquals(10, result.getValue(null));
    }


    @Test(expected = AssertionError.class)
    public void testCount_EmptyArray() {

        SeqCountFunction fun = new SeqCountFunction();
        BaseAviatorObject result = fun.call(null, new AviatorRuntimeJavaType(new String[0]));
        assertEquals(0, result.getValue(null));
    }


    @Test(expected = AssertionError.class)
    public void testCount_Collection() {
        final HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);

        SeqCountFunction fun = new SeqCountFunction();
        BaseAviatorObject result = fun.call(null, new AviatorRuntimeJavaType(set));
        assertEquals(2, result.getValue(null));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCount_String() {
        SeqCountFunction fun = new SeqCountFunction();
        BaseAviatorObject result = fun.call(null, new AviatorRuntimeJavaType("hello"));
    }

}
