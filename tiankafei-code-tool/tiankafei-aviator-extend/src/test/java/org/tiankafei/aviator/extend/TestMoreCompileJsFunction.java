package org.tiankafei.aviator.extend;

import org.tiankafei.aviator.extend.util.AviatorExtendUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestMoreCompileJsFunction {

    static {
        AviatorExtendUtil.initFun();
    }

    @Test
    public void testAndMore() {
        String expression = "AND(1+1==2, 1+1==1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "AND(a+b==2, a+b==1)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        dataMap.put("b", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testOrMore() {
        String expression = "OR(1+1==2, 1+1==1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "OR(a+b==2, a+b==1)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testLeft() {
        String expression = "LEFT('weishuangshuang', 6)";
        AviatorExtendUtil.compileJs(expression);
        expression = "LEFT(a, 6)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "weishuangshuang");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testRight() {
        String expression = "RIGHT('weishuangshuang', 6)";
        AviatorExtendUtil.compileJs(expression);
        expression = "RIGHT(a, 6)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "weishuangshuang");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testMid() {
        String expression = "mid('weishuangshuang', 3, 6)";
        AviatorExtendUtil.compileJs(expression);
        expression = "mid(a, 3, 6)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "weishuangshuang");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testSum() {
        String expression = "SUM(1, 1.1, 2.2, -1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "SUM(a, b, c, d)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 1.1);
        dataMap.put("c", 2.2);
        dataMap.put("d", -1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIf() {
        String expression = "IF(1==2, 1.1+2.2, 2.2+1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "IF(a==b, c+d, e+f)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 2);
        dataMap.put("c", 2.2);
        dataMap.put("d", -1);
        dataMap.put("e", -1);
        dataMap.put("f", -1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIfAbs() {
        String expression = "IF(ABS(-2)==2, 1.1+2.2, 2.2+1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "IF(ABS(a)==b, c+d, e+f)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", -2);
        dataMap.put("b", 2);
        dataMap.put("c", 2.2);
        dataMap.put("d", -1);
        dataMap.put("e", -1);
        dataMap.put("f", -1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testInList() {
        String expression = "INLIST('2', 1,2,3,4,5,6,7)";
        AviatorExtendUtil.compileJs(expression);
        expression = "INLIST(a, 1,2,3,4,5,6,7)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", '1');
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testAge() {
        String expression = "age(1989,09)";
        AviatorExtendUtil.compileJs(expression);
        expression = "age(1989,09,1999,09)";
        AviatorExtendUtil.compileJs(expression);
        expression = "age(a,b)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "1989");
        dataMap.put("b", "09");
        AviatorExtendUtil.compileJs(expression, dataMap);
        expression = "age(a,b,c,d)";

        dataMap.put("a", "1989");
        dataMap.put("b", "09");
        dataMap.put("c", "1999");
        dataMap.put("d", "09");

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testFind() {
        String expression = "FIND(\"\\\\?\",\"123465\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "FIND(\"\\\\?\",\"123465\",9)";
        AviatorExtendUtil.compileJs(expression);
        expression = "FIND(\"工商\",\"工商工商工商工商\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "FIND(a,b,c)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        dataMap.put("c", "9");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "工商");
        dataMap.put("b", "工商行政管理部门工商");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testLookat() {
        String expression = "lookat(\"\\\\?\",\"123465\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "lookat(\"\\\\?\",\"123465\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "lookat(\"工商\",\"工\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "lookat(a,b)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "工商");
        dataMap.put("b", "工");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testMatch() {
        String expression = "match(\"\\\\?\",\"123465\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "match(\"\\\\?\",\"123465\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "match(\"工商行政管理部门工商\",\"工商行政管理部门工商\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "match(a,b)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "\\\\?");
        dataMap.put("b", "1989");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "工商行政管理部门工商");
        dataMap.put("b", "工商行政管理部门工商");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testVerifych() {
        String expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"1\",\"公司\",\"0\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"2\",\"公司\",\"0\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"3\",\"公司\",\"1\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "VERIFYCH(a,b,c,d)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "工商行政管理部门工商公司aaaaa");
        dataMap.put("b", "1");
        dataMap.put("c", "公司");
        dataMap.put("d", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "工商行政管理部门工商公司aaaaa");
        dataMap.put("b", "2");
        dataMap.put("c", "公司");
        dataMap.put("d", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "工商行政管理部门工商公司aaaaa");
        dataMap.put("b", "3");
        dataMap.put("c", "公司");
        dataMap.put("d", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testMonth() {
        String expression = "month(\"01\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"02\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"12\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"01\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"02\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"12\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"01\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"02\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(\"12\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "month(a,b,c)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "01");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "02");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "12");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "01");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "02");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "12");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "01");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "02");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "12");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testYear() {
        String expression = "year(\"1799\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"1801\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"2020\",\"201808MM\",0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"1799\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"1801\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"2020\",\"201808MM\",1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"1799\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"1801\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(\"2020\",\"201808MM\",2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "year(a,b,c)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", "1799");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "1801");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "2020");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "0");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "1799");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "1801");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "2020");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "1799");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "1801");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "2020");
        dataMap.put("b", "201808MM");
        dataMap.put("c", "2");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testTimeCompare() {
        String expression = "timecompare(04,50,01,20)";
        AviatorExtendUtil.compileJs(expression);
        expression = "timecompare(01,50,19,20)";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "timecompare(a,b,c,d)";

        dataMap.put("a", "04");
        dataMap.put("b", "50");
        dataMap.put("c", "01");
        dataMap.put("d", "20");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "01");
        dataMap.put("b", "50");
        dataMap.put("c", "19");
        dataMap.put("d", "20");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testInRange() {
        String expression = "inrange(01,00,02)";
        AviatorExtendUtil.compileJs(expression);
        expression = "inrange(01,02,03)";
        AviatorExtendUtil.compileJs(expression);
        expression = "inrange(\"a\",\"ab\",\"bc\")";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "inrange(a,b,c)";
        dataMap.put("a", "01");
        dataMap.put("b", "00");
        dataMap.put("c", "02");
        AviatorExtendUtil.compileJs(expression, dataMap);

        dataMap.put("a", "01");
        dataMap.put("b", "02");
        dataMap.put("c", "03");

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "a");
        dataMap.put("b", "ab");
        dataMap.put("c", "bc");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testMax() {
        String expression = "max(9,1,2,3,4,5,6,7)";
        AviatorExtendUtil.compileJs(expression);
        expression = "max(9,1,2,3,4,5,6,7)";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "max(a,1,2,3,4,5,6,7)";
        dataMap.put("a", 8);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testMin() {
        String expression = "min(9,1,2,3,4,5,6,7)";
        AviatorExtendUtil.compileJs(expression);
        expression = "min(9,1,2,3,4,5,6,7)";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "min(a,1,2,3,4,5,6,7)";
        dataMap.put("a", 8);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testReplaceall() {
        String expression = "replaceall('12346579', 1, 0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "replaceall('12346579', 1, 999)";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "replaceall(a, b, c)";

        dataMap.put("a", "12346579");
        dataMap.put("b", 1);
        dataMap.put("c", 0);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "12346579");
        dataMap.put("b", 1);
        dataMap.put("c", 999);
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

}
