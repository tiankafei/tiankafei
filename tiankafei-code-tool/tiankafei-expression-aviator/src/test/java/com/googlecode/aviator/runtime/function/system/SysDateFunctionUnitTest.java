package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SysDateFunctionUnitTest {
    @Test
    public void testCall() {
        SysDateFunction fun = new SysDateFunction();

        BaseAviatorObject result = fun.call(null);
        assertNotNull(result);
        assertTrue(result.getValue(null) instanceof Date);
    }


    @Test(expected = IllegalArgumentException.class)
    public void hasArugment() {
        SysDateFunction fun = new SysDateFunction();
        fun.call(null, AviatorBoolean.TRUE);

    }
}
