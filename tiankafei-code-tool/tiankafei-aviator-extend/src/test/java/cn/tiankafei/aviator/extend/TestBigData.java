package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestBigData {

    private int count = 10000 * 1;

    static {
        AviatorExtendUtil.initFun();
    }

    @Test
    public void test1() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String expression = "1+1";
        for (int i = 0; i < count; i++) {
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test3() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test11() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test22() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test33() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String expression = "1+1";
        for (int i = 0; i < count; i++) {
            AviatorExtendUtil.execute(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
