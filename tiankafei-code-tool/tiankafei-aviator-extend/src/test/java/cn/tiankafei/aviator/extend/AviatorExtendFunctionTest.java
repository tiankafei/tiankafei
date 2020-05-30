package cn.tiankafei.aviator.extend;

import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AviatorExtendFunctionTest {

    @Before
    public void before(){
        AviatorFunctionManager aviatorFunctionManager = new AviatorFunctionManager();
    }

    @Test
    public void testAnd(){
        String expression = "and(1+2==3, 2+3==5)";
        Object result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "and(1+2==3)";
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
    public void testOr(){
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

}
