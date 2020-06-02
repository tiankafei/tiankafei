package cn.tiankafei.aviator.extend;

import com.google.common.base.Stopwatch;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestCompileJs {

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
        dataMap.put("c", 1);
        dataMap.put("d", 1);
        String expression = "'1'+'1'=='11'";
//        String expression = "a+b";
//        engine.compile(expression, felContext);
//        engine.compileJs(expression, felContext);
//
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Map<String, Object> dataMap = new HashMap<>();
        String expression = "1+2";
//        AviatorExtendUtil.execute(expression, dataMap);


        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
