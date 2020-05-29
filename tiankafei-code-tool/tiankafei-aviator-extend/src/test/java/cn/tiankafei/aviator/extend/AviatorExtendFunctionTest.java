package cn.tiankafei.aviator.extend;

import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

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
        String expression = "and(1+2==3, 2+3==4)";
        Object result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "and(1+2==2)";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);
    }

    @Test
    public void testOr(){
        String expression = "or(1+2==3, 2+3==4)";
        Object result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "or(1+2==2)";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);
    }

}
