package org.tiankafei.aviator;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestSysfunAviator {

    @Test
    public void test1(){
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "double(a) == double(b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
//        dataMap.put("a", "12");
//        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
