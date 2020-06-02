package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AviatorExtendOneFunctionTest {

    static {
        AviatorFunctionManager aviatorFunctionManager = new AviatorFunctionManager();
        aviatorFunctionManager.initFun();
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

    @Test
    public void testAnd01() {
        String expression = "and(1+2==3, 2+3==5)";
        Object result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "and(1+2==3)";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "and()";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "1+2==3 && 2+3==5";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "1+2==3";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);
    }

    @Test
    public void testOr01() {
        String expression = "or(a+b==c, d+e==f)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 2);
        dataMap.put("c", 3);
        dataMap.put("d", 2);
        dataMap.put("e", 3);
        dataMap.put("f", 5);
        Object result = AviatorEvaluator.execute(expression, dataMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "or(1+2==2)";
        result = AviatorEvaluator.execute(expression, dataMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "or()";
        result = AviatorEvaluator.execute(expression, dataMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "a+b==c || d+e==f";
        dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 2);
        dataMap.put("c", 3);
        dataMap.put("d", 2);
        dataMap.put("e", 3);
        dataMap.put("f", 4);
        result = AviatorEvaluator.execute(expression, dataMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "a+b==c";
        result = AviatorEvaluator.execute(expression, dataMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);
    }

    @Test
    public void testEquals01(){
        String expression = "1.1==1.2";
        AviatorExtendUtil.execute(expression);
        expression = "1.1==1.10";
        AviatorExtendUtil.execute(expression);

        expression = "a==b";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1.1");
        dataMap.put("b", "1.2");
        AviatorExtendUtil.execute(expression, dataMap);

        dataMap.put("a", 1.1);
        dataMap.put("b", 1.10);
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testEqualsStr(){
        String expression = "equals(1.1, 1.2)";
        AviatorExtendUtil.execute(expression);
        expression = "equals(1.1, 1.10)";
        AviatorExtendUtil.execute(expression);

        expression = "equals(a, b)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1.1");
        dataMap.put("b", "1.2");
        AviatorExtendUtil.execute(expression, dataMap);

        dataMap.put("a", 1.1);
        dataMap.put("b", 1.10);
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testAbs() {
        String expression = "ABS(-1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "ABS(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "-1.1");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testNotNull() {
        String expression = "NOTNULL(1)";
        AviatorExtendUtil.execute(expression);
        expression = "NOTNULL(nil)";
        AviatorExtendUtil.execute(expression);
        expression = "NOTNULL(a)";
        Map<String, Object> dataMap = new HashMap<>();
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsNull() {
        String expression = "ISNULL(1)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNULL(nil)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNULL(a)";
        Map<String, Object> dataMap = new HashMap<>();
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsNumber() {
        String expression = "ISNUMBER(1)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUMBER(1.0)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUMBER(-1.0)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUMBER('a')";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUMBER(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "a");
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1.0);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.0");
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.0a");
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsNum() {
        String expression = "ISNUM(1)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUM(1.0)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUM(-1.0)";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUM('a')";
        AviatorExtendUtil.execute(expression);
        expression = "ISNUM(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "a");
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1.0);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.0");
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.0a");
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testCeil() {
        String expression = "ceil(1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "ceil(-1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "ceil(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", -1.1);
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testCurrentTime() {
        String expression = "currenttime(\"yyyy-MM-dd HH:mm:ss\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(\"yyyy-MM-dd HH:mm\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(\"yyyy-MM-dd HH\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(\"yyyy-MM-dd\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(\"yyyy-MM\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(\"yyyy\")";
        AviatorExtendUtil.execute(expression);
        expression = "currenttime(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "yyyy-MM-dd HH:mm:ss");
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd HH:mm");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd HH");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "yyyy-MM");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "yyyy");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testNot() {
        String expression = "not(1.1==1.2)";
        AviatorExtendUtil.execute(expression);
        expression = "not(1.1==1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "not(a==b)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.2);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.1);
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testNotOper() {
        String expression = "!(1.1==1.2)";
        AviatorExtendUtil.execute(expression);
        expression = "!(1.1==1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "!(a==b)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.2);
        
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.1);
        
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsch() {
        String expression = "isch('sdfasfd')";
        AviatorExtendUtil.execute(expression);
        expression = "isch('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "isch('晚上sfdas')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isch(a)";
        
        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsen() {
        String expression = "isen('sdfasfd')";
        AviatorExtendUtil.execute(expression);
        expression = "isen('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "isen('晚上sfdas')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isen(a)";
        
        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIslower() {
        String expression = "islower('sdfasfd')";
        AviatorExtendUtil.execute(expression);
        expression = "islower('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "islower('晚上sfdas')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "islower(a)";
        
        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testIsupper() {
        String expression = "isupper('SDFASFD')";
        AviatorExtendUtil.execute(expression);
        expression = "isupper('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "isupper('晚上SFDAS')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isupper(a)";
        
        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testLen() {
        String expression = "len('SDFASFD')";
        AviatorExtendUtil.execute(expression);
        expression = "len('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "len('晚上SFDAS')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "len(a)";
        
        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testLength() {
        String expression = "length('SDFASFD')";
        AviatorExtendUtil.execute(expression);
        expression = "length('晚上')";
        AviatorExtendUtil.execute(expression);
        expression = "length('晚上SFDAS')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "length(a)";
        
        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testRound() {
        String expression = "round('1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "round('-1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "round('asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "round(a)";
        
        dataMap.put("a", "1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testTrim() {
        String expression = "trim('   SAFD   ')";
        AviatorExtendUtil.execute(expression);
        expression = "trim('   -1.1   ')";
        AviatorExtendUtil.execute(expression);
        expression = "trim('  ASD')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "trim(a)";
        
        dataMap.put("a", "   1.1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "     A      ");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testLower() {
        String expression = "lower('   SAFD   ')";
        AviatorExtendUtil.execute(expression);
        expression = "lower('   -1.1   ')";
        AviatorExtendUtil.execute(expression);
        expression = "lower('  ASD')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "lower(a)";
        
        dataMap.put("a", "   1.1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "     A      ");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testUpper() {
        String expression = "upper('   safd   ')";
        AviatorExtendUtil.execute(expression);
        expression = "upper('   -1.1   ')";
        AviatorExtendUtil.execute(expression);
        expression = "upper('  asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "upper(a)";
        
        dataMap.put("a", "   1.1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "     a      ");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testTrunc() {
        String expression = "trunc('1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "trunc('-1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "trunc('asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "trunc(a)";
        
        dataMap.put("a", "1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testVerifycode() {
        String expression = "verifycode('134766570')";
        AviatorExtendUtil.execute(expression);
        expression = "verifycode('-1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "verifycode('asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifycode(a)";
        
        dataMap.put("a", "134766570");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testVerifyIdCard() {
        String expression = "verifyidcard('134766570')";
        AviatorExtendUtil.execute(expression);
        expression = "verifyidcard('-1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "verifyidcard('asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifyidcard(a)";
        
        dataMap.put("a", "134766570");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testVerifyCreditCode() {
        String expression = "verifycreditcode('91110000100026793Y')";
        AviatorExtendUtil.execute(expression);
        expression = "verifycreditcode('-1.5')";
        AviatorExtendUtil.execute(expression);
        expression = "verifycreditcode('asd')";
        AviatorExtendUtil.execute(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifycreditcode(a)";
        
        dataMap.put("a", "91110000100026793Y");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

}
