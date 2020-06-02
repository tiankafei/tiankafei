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
public class TestAnd {

    @Test
    public void test() {

        String expression = "1==1 && 2==3 && 'a'=='a'";
        AviatorExtendUtil.execute(expression);
        expression = "'a'=='a' && 2==2 && 'a'=='a'";
        AviatorExtendUtil.execute(expression);

        expression = "a==b && c==d";
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
