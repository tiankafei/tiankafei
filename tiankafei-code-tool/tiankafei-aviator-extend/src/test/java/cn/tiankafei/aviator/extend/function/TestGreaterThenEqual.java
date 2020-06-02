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
public class TestGreaterThenEqual {

    @Test
    public void test() {

        String expression = "1>=0";
        AviatorExtendUtil.execute(expression);
        expression = "'1'>=0";
        AviatorExtendUtil.execute(expression);
        expression = "1>='0'";
        AviatorExtendUtil.execute(expression);
        expression = "'1'>='0'";
        AviatorExtendUtil.execute(expression);
        expression = "'a'>='0'";
        AviatorExtendUtil.execute(expression);
        expression = "'a'>='b'";
        AviatorExtendUtil.execute(expression);

        expression = "a>=b";
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("a", 1);
        dataMap.put("b", 0);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1");
        dataMap.put("b", 0);
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", 1);
        dataMap.put("b", "0");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "1");
        dataMap.put("b", "0");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        dataMap.put("b", "0");
        AviatorExtendUtil.execute(expression, dataMap);
        dataMap.put("a", "a");
        dataMap.put("b", "b");
        AviatorExtendUtil.execute(expression, dataMap);
    }

}
