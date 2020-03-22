package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;
import cn.tiankafei.base.datetime.DateTimeUtil;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class String2DateFunctionUnitTest {

    private String2DateFunction function = new String2DateFunction();


    @Test(expected = AssertionError.class)
    public void testCall() {
        assertEquals("string_to_date", function.getName());
        String source = "2011-09-17";
        Date date = (Date) function
                .call(null, new AviatorRuntimeJavaType(source), new AviatorString("yyyy-MM-dd"))
                .getValue(null);

        assertNotNull(date);
        assertEquals(111, DateTimeUtil.getCurrentYear(date));
        assertEquals(8, DateTimeUtil.getCurrentMonth(date));
        assertEquals(17, DateTimeUtil.getCurrentDayOfMonth(date));

    }


    @Test(expected = ClassCastException.class)
    public void testCall_NotDate() {
        assertEquals("string_to_date", function.getName());
        function.call(null, new AviatorRuntimeJavaType(1), new AviatorString("yyyyMMdd"));
    }
}
