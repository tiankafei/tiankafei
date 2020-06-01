package cn.tiankafei.aviator.extend;

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
public class AviatorExtendTest {

    @Test
    public void test01() {
        String expression = "1+2";
        Object result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);
        expression = "1+2==3";
        result = AviatorEvaluator.execute(expression);
        log.info("表达式：{}的执行结果为：{}", expression, result);

        expression = "a+b";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a", 1);
        paramMap.put("b", 2);
        paramMap.put("c", 3);
        result = AviatorEvaluator.execute(expression, paramMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);
        expression = "a+b==c";
        result = AviatorEvaluator.execute(expression, paramMap);
        log.info("表达式：{}的执行结果为：{}", expression, result);
    }

}
