package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.util.AviatorExtendUtil;
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
public class TestAndMore {

    @Test
    public void test() {

        String expression = "and(1==1, 2==3, 'a'=='a')";
        AviatorExtendUtil.execute(expression);
        expression = "and('a'=='a', 2==2, 'a'=='a')";
        AviatorExtendUtil.execute(expression);

        expression = "and(a==b, c==d)";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", 1);
        dataMap.put("b", 1);
        dataMap.put("c", 2);
        dataMap.put("d", 2);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", '1');
        dataMap.put("b", '1');
        dataMap.put("c", '0');
        dataMap.put("d", '0');
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        dataMap.put("b", '1');
        dataMap.put("c", '0');
        dataMap.put("d", 0);
        AviatorExtendUtil.execute(expression, dataMap);
    }

}
