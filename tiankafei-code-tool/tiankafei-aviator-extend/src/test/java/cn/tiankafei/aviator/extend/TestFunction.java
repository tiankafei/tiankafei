package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestFunction {

    static {
        AviatorExtendUtil.initFun();
    }

    @Test
    public void testAdd() {
        String expression = "1+1";
        AviatorExtendUtil.execute(expression);
        expression = "'1'+1";
        AviatorExtendUtil.execute(expression);
        expression = "1+'1'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'+'1'";
        AviatorExtendUtil.execute(expression);

        expression = "1.1+1.2";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'+1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1+'1.2'";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'+'1.2'";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a+1";
        AviatorExtendUtil.execute(expression, dataMap);
        expression = "'a'+1";
        AviatorExtendUtil.execute(expression);
        expression = "a+'1'";
        AviatorExtendUtil.execute(expression, dataMap);
        expression = "'a'+'1'";
        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testSub() {
        String expression = "1-1";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testMul() {
        String expression = "1*1";
        AviatorExtendUtil.execute(expression);
        expression = "'1'*1";
        AviatorExtendUtil.execute(expression);
        expression = "1*'1'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'*'1'";
        AviatorExtendUtil.execute(expression);

        expression = "1.1*1.2";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'*1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1*'1.2'";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'*'1.2'";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a*1";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'*1";
//        AviatorExtendUtil.execute(expression);
        expression = "a*'1'";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'*'1'";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testDiv() {
        String expression = "1/1";
        AviatorExtendUtil.execute(expression);
        expression = "'1'/1";
        AviatorExtendUtil.execute(expression);
        expression = "1/'1'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'/'1'";
        AviatorExtendUtil.execute(expression);

        expression = "1.1/1.2";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'/1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1/'1.2'";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'/'1.2'";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a/1";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'/1";
//        AviatorExtendUtil.execute(expression);
        expression = "a/'1'";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'/'1'";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testMod() {
        String expression = "1%1";
        AviatorExtendUtil.execute(expression);
        expression = "'1'%1";
        AviatorExtendUtil.execute(expression);
        expression = "1%'1'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'%'1'";
        AviatorExtendUtil.execute(expression);

        expression = "1.1%1.2";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'%1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1%'1.2'";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'%'1.2'";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a%1";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'%1";
//        AviatorExtendUtil.execute(expression);
        expression = "a%'1'";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'%'1'";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testEquals() {
        String expression = "1-1==0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1==0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'==0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'==0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2==0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2==0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'==0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'==0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1==0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1==0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'==0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'==0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testNoEquals() {
        String expression = "1-1!=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1!=0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'!=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'!=0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2!=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2!=0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'!=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'!=0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1!=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1!=0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'!=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'!=0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testLessThen() {
        String expression = "1-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'<0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'<0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1<0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'<0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testLessThenEquals() {
        String expression = "1-1<=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1<=0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'<=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'<=0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2<=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2<=0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'<=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'<=0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1<=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1<=0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'<=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'<=0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testGreaterThen() {
        String expression = "1-1>0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1>0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'>0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'>0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2>0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2>0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'>0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'>0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1>0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'>0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'>0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testGreaterThenEquals() {
        String expression = "1-1>=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1>=0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'>=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'>=0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2>=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2>=0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'>=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'>=0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1>=0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'>=0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'>=0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testAnd() {
        String expression = "1-1>=0 && 1-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1>=0 && '1'-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'>=0 && 1-'1'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'>=0 && '1'-'1'<0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2>=0 && 1.1-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2>=0 && '1.1'-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'>=0 && 1.1-'1.2'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'>=0 && '1.1'-'1.2'<0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0 && a-1<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1>=0 && 'a'-1<0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'>=0 && a-'1'<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'>=0 && 'a'-'1'<0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

    @Test
    public void testOr() {
        String expression = "1-1>=0 || 1-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-1>=0 || '1'-1<0";
        AviatorExtendUtil.execute(expression);
        expression = "1-'1'>=0 || 1-'1'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'-'1'>=0 || '1'-'1'<0";
        AviatorExtendUtil.execute(expression);

        expression = "1.1-1.2>=0 || 1.1-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-1.2>=0 || '1.1'-1.2<0";
        AviatorExtendUtil.execute(expression);
        expression = "1.1-'1.2'>=0 || 1.1-'1.2'<0";
        AviatorExtendUtil.execute(expression);
        expression = "'1.1'-'1.2'>=0 || '1.1'-'1.2'<0";
        AviatorExtendUtil.execute(expression);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0 || a-1<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-1>=0 || 'a'-1<0";
//        AviatorExtendUtil.execute(expression);
        expression = "a-'1'>=0 || a-'1'<0";
        AviatorExtendUtil.execute(expression, dataMap);
//        expression = "'a'-'1'>=0 || 'a'-'1'<0";
//        AviatorExtendUtil.execute(expression);
        System.out.println("=====================================================");
    }

}
