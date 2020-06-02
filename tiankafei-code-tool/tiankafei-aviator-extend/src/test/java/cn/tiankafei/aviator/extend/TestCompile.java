package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import com.google.common.base.Stopwatch;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestCompile {

    static {
        AviatorFunctionManager aviatorFunctionManager = new AviatorFunctionManager();
        aviatorFunctionManager.initFun();
    }

    @Test
    public void test1() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1);
        dataMap.put("b", 1);
        String expression = "a+b";
        AviatorExtendUtil.execute(expression, dataMap);

        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        String expression = "a+b";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "1");
        dataMap.put("b", "1");
        AviatorExtendUtil.execute(expression, dataMap);

        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test3() {
        Stopwatch stopwatch = Stopwatch.createStarted();

//        String expression = "IF(a1+a2==1,a4,a5)==\"1\"";
//        String expression = "IF(a1+a2==1,a4==a1,a5==v3)";
        String expression = "ABS(IF(a1+a2==1,a4,a5))";
        Map<String, Object> dataMap = new HashMap<>();
        AviatorExtendUtil.execute(expression, dataMap);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
