package org.tiankafei.aviator;

import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.aviator.util.AviatorUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestAviatorScript {

    @Before
    public void before() {
        AviatorUtil.initFun();
    }

    private void test() {
//        int b = 2;
//        if (a > 1) {
//            a + b
//        } elsif(a > 10) {
//            return a + c;
//        } else{
//            return 10;
//        }
    }

    @Test
    public void test1() {
        Expression exp = AviatorEvaluator
                .compile("b=2; if(a > 1) { a + b } elsif( a > 10) { return a + c; } else { return 10; }");
        List<String> vars = exp.getVariableNames();
        System.out.println(vars);
        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 10);
        dataMap.put("c", 10);
        System.out.println(exp.execute(dataMap));
    }

    @Test
    public void test2() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("test.av");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 11);
        dataMap.put("c", 11);
        System.out.println(exp.execute(dataMap));
    }

    @Test
    public void test3() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("list.av");
        System.out.println(exp.getVariableNames());

        TestDto testDto1 = new TestDto();
        testDto1.setCode("1");
        testDto1.setName("anme:111");

        TestDto testDto2 = new TestDto();
        testDto2.setCode("2");
        testDto2.setName("anme:222");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("list", Arrays.asList(testDto1, testDto2));
        dataMap.put("set", Arrays.asList(testDto1, testDto2));
        dataMap.put("map", Collections.singletonMap("1", testDto1));
        System.out.println(exp.execute(dataMap));
    }

    @Data
    public class TestDto {

        private String code;

        private String name;

    }

    @Test
    public void test4() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("mixing.av");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 4);
        dataMap.put("c", 11);
        System.out.println(exp.execute(dataMap));
    }

    @Test
    public void test5() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("method.av");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 4);
        dataMap.put("c", 11);
        System.out.println(exp.execute(dataMap));
    }

    @Test
    public void test6() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("business.av");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 4);
        dataMap.put("c", 11);
        System.out.println(exp.execute(dataMap));
    }

    @Test
    public void test7() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("collection.av");

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 4);
        dataMap.put("c", 11);
        System.out.println(exp.execute(dataMap));
    }

}
