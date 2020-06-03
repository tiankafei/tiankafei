package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestCompileFunction {

    static {
        AviatorFunctionManager aviatorFunctionManager = new AviatorFunctionManager();
        aviatorFunctionManager.initFun();
    }

    @Test
    public void testAdd() {
        String expression = "1+1";
        AviatorExtendUtil.compile(expression);

        expression = "'1'+1";
        AviatorExtendUtil.compile(expression);

        expression = "1+'1'";
        AviatorExtendUtil.compile(expression);

        expression = "'1'+'1'";
        AviatorExtendUtil.compile(expression);


        expression = "1.1+1.2";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'+1.2";
        AviatorExtendUtil.compile(expression);

        expression = "1.1+'1.2'";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'+'1.2'";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a+1";
        AviatorExtendUtil.compile(expression, dataMap);
        expression = "'a'+1";
        AviatorExtendUtil.compile(expression, dataMap);
        expression = "a+'1'";
        AviatorExtendUtil.compile(expression, dataMap);
        expression = "'a'+'1'";
        AviatorExtendUtil.compile(expression, dataMap);
        
    }

    @Test
    public void testSub() {
        String expression = "1-1";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testMul() {
        String expression = "1*1";
        AviatorExtendUtil.compile(expression);
        expression = "'1'*1";
        AviatorExtendUtil.compile(expression);

        expression = "1*'1'";
        AviatorExtendUtil.compile(expression);

        expression = "'1'*'1'";
        AviatorExtendUtil.compile(expression);


        expression = "1.1*1.2";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'*1.2";
        AviatorExtendUtil.compile(expression);

        expression = "1.1*'1.2'";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'*'1.2'";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a*1";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'*1";
//        AviatorExtendUtil.compile(expression);
        expression = "a*'1'";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'*'1'";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testDiv() {
        String expression = "1/1";
        AviatorExtendUtil.compile(expression);
        expression = "'1'/1";
        AviatorExtendUtil.compile(expression);

        expression = "1/'1'";
        AviatorExtendUtil.compile(expression);

        expression = "'1'/'1'";
        AviatorExtendUtil.compile(expression);


        expression = "1.1/1.2";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'/1.2";
        AviatorExtendUtil.compile(expression);

        expression = "1.1/'1.2'";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'/'1.2'";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a/1";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'/1";
//        AviatorExtendUtil.compile(expression);
        expression = "a/'1'";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'/'1'";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testMod() {
        String expression = "1%1";
        AviatorExtendUtil.compile(expression);
        expression = "'1'%1";
        AviatorExtendUtil.compile(expression);

        expression = "1%'1'";
        AviatorExtendUtil.compile(expression);

        expression = "'1'%'1'";
        AviatorExtendUtil.compile(expression);


        expression = "1.1%1.2";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'%1.2";
        AviatorExtendUtil.compile(expression);

        expression = "1.1%'1.2'";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'%'1.2'";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a%1";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'%1";
//        AviatorExtendUtil.compile(expression);
        expression = "a%'1'";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'%'1'";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testEquals() {
        String expression = "1-1==0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1==0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'==0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'==0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2==0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2==0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'==0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'==0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1==0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1==0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'==0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'==0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testNoEquals() {
        String expression = "1-1!=0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1!=0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'!=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'!=0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2!=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2!=0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'!=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'!=0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1!=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1!=0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'!=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'!=0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testLessThen() {
        String expression = "1-1<0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1<0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'<0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'<0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1<0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'<0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testLessThenEquals() {
        String expression = "1-1<=0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1<=0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'<=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'<=0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2<=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2<=0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'<=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'<=0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1<=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1<=0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'<=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'<=0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testGreaterThen() {
        String expression = "1-1>0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1>0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'>0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'>0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2>0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2>0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'>0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'>0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1>0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'>0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'>0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testGreaterThenEquals() {
        String expression = "1-1>=0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1>=0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'>=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'>=0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2>=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2>=0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'>=0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'>=0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1>=0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'>=0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'>=0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testAnd() {
        String expression = "1-1>=0 && 1-1<0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1>=0 && '1'-1<0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'>=0 && 1-'1'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'>=0 && '1'-'1'<0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2>=0 && 1.1-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2>=0 && '1.1'-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'>=0 && 1.1-'1.2'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'>=0 && '1.1'-'1.2'<0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0 && a-1<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1>=0 && 'a'-1<0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'>=0 && a-'1'<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'>=0 && 'a'-'1'<0";
//        AviatorExtendUtil.compile(expression);
        
    }

    @Test
    public void testOr() {
        String expression = "1-1>=0 || 1-1<0";
        AviatorExtendUtil.compile(expression);
        expression = "'1'-1>=0 || '1'-1<0";
        AviatorExtendUtil.compile(expression);

        expression = "1-'1'>=0 || 1-'1'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1'-'1'>=0 || '1'-'1'<0";
        AviatorExtendUtil.compile(expression);


        expression = "1.1-1.2>=0 || 1.1-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-1.2>=0 || '1.1'-1.2<0";
        AviatorExtendUtil.compile(expression);

        expression = "1.1-'1.2'>=0 || 1.1-'1.2'<0";
        AviatorExtendUtil.compile(expression);

        expression = "'1.1'-'1.2'>=0 || '1.1'-'1.2'<0";
        AviatorExtendUtil.compile(expression);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        expression = "a-1>=0 || a-1<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-1>=0 || 'a'-1<0";
//        AviatorExtendUtil.compile(expression);
        expression = "a-'1'>=0 || a-'1'<0";
        AviatorExtendUtil.compile(expression, dataMap);
//        expression = "'a'-'1'>=0 || 'a'-'1'<0";
//        AviatorExtendUtil.compile(expression);
        
    }

}
