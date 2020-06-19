package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2019/12/10
 * @Version V1.0
 **/
@Slf4j
public class TestAge {

    @Test
    public void test() {

        String expression = "AGE(1989, 09)";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"1989\",\"09\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"a\",09)";
        AviatorExtendUtil.execute(expression);
        expression = "age(1989,\"a\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"a\",\"b\")";
        AviatorExtendUtil.execute(expression);

        expression = "age(1989,09,1999,08)";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"1989\",\"09\",\"1999\",\"08\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"a\",\"09\",\"1999\",\"09\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"1989\",\"a\",\"1999\",\"09\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"1989\",\"09\",\"a\",\"09\")";
        AviatorExtendUtil.execute(expression);
        expression = "age(\"1989\",\"09\",\"1999\",\"a\")";
        AviatorExtendUtil.execute(expression);
        AviatorExtendUtil.execute(expression);
        expression = "age(\"a\",\"b\",\"c\",\"d\")";
        AviatorExtendUtil.execute(expression);

        expression = "age(a, b)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", 1989);
        dataMap.put("b", 9);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1989");
        dataMap.put("b", "09");
        AviatorExtendUtil.execute(expression, dataMap);

        expression = "age(a, b, c, d)";

        dataMap.put("a", 1989);
        dataMap.put("b", 9);
        dataMap.put("c", 1999);
        dataMap.put("d", 8);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1989");
        dataMap.put("b", "09");
        dataMap.put("c", "1999");
        dataMap.put("d", "08");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        dataMap.put("b", "09");
        dataMap.put("c", "1999");
        dataMap.put("d", "08");
        AviatorExtendUtil.execute(expression, dataMap);
    }

}
