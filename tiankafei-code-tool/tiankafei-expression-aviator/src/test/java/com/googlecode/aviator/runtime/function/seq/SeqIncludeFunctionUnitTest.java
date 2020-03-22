package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SeqIncludeFunctionUnitTest {

    @Test
    public void testInclude_Array() {
        Integer[] a = new Integer[3];
        a[0] = 1;
        a[1] = -100;

        SeqIncludeFunction fun = new SeqIncludeFunction();
        final AviatorRuntimeJavaType arg1 = new AviatorRuntimeJavaType(a);
        BaseAviatorObject result = fun.call(null, arg1, new AviatorRuntimeJavaType(-100));
        assertTrue(result.booleanValue(null));

        // contains null Object
        result = fun.call(null, arg1, AviatorNil.NIL);
        assertTrue(result.booleanValue(null));

        // not match
        result = fun.call(null, arg1, new AviatorRuntimeJavaType(1000));
        assertFalse(result.booleanValue(null));
    }


    @Test
    public void testInclude_HashSet() {
        Set<Integer> a = new HashSet<Integer>();
        a.add(1);
        a.add(-100);
        a.add(null);

        BaseAviatorObject arg1 = new AviatorRuntimeJavaType(a);

        SeqIncludeFunction fun = new SeqIncludeFunction();
        BaseAviatorObject result = fun.call(null, arg1, new AviatorRuntimeJavaType(-100));
        assertTrue(result.booleanValue(null));

        // contains null Object
        result = fun.call(null, arg1, new AviatorRuntimeJavaType(null));
        assertTrue(result.booleanValue(null));
        result = fun.call(null, arg1, AviatorNil.NIL);
        assertTrue(result.booleanValue(null));

        // not match
        result = fun.call(null, arg1, new AviatorRuntimeJavaType(1000));
        assertFalse(result.booleanValue(null));

    }


    @Test(expected = IllegalArgumentException.class)
    public void testInclude_String() {
        SeqIncludeFunction fun = new SeqIncludeFunction();
        BaseAviatorObject result =
                fun.call(null, new AviatorRuntimeJavaType("hello"), new AviatorRuntimeJavaType("h"));
    }

}
