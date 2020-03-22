package com.googlecode.aviator.runtime.function.math;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.googlecode.aviator.runtime.type.BaseAviatorNumber;
import org.junit.Test;


public abstract class BaseMathFunctionUnitTestForOneArgument {

    AviatorFunction function;


    @Test(expected = IllegalArgumentException.class)
    public void testZeroArgument() {
        function.call(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_TwoArugments() {
        function.call(null, BaseAviatorNumber.valueOf(3.2), BaseAviatorNumber.valueOf(3.2));
    }


    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        function.call(null, AviatorNil.NIL);
    }


    @Test(expected = ClassCastException.class)
    public void testClassCastError1() {
        function.call(null, AviatorBoolean.TRUE);
    }


    @Test(expected = ClassCastException.class)
    public void testClassCastError2() {
        function.call(null, new AviatorString("hello"));
    }
}
