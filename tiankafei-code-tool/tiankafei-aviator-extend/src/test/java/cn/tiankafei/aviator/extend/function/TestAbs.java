package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author 魏双双
 * @Date 2019/12/10
 * @Version V1.0
 **/
@Slf4j
public class TestAbs {

    @Test
    public void test() {

        String expression = "abs(1)";
        AviatorExtendUtil.execute(expression);
        expression = "abs(-1)";
        AviatorExtendUtil.execute(expression);
        expression = "abs(1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "abs(-1.1)";
        AviatorExtendUtil.execute(expression);
        expression = "abs('1')";
        AviatorExtendUtil.execute(expression);
        expression = "abs('-1')";
        AviatorExtendUtil.execute(expression);
        expression = "abs('1.1')";
        AviatorExtendUtil.execute(expression);
        expression = "abs('-1.1')";
        AviatorExtendUtil.execute(expression);
        expression = "abs('a')";
        AviatorExtendUtil.execute(expression);
        expression = "abs(a)";
        AviatorExtendUtil.execute(expression);

        expression = "abs(a)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", 1);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", -1);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1.1);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", -1.1);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1.1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "-1.1");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.execute(expression, dataMap);
    }

}
