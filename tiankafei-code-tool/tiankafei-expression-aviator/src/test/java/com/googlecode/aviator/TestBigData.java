package com.googlecode.aviator;

import cn.tiankafei.base.util.SystemTimeUtil;
import org.junit.Test;

public class TestBigData {

    private int count = 1 * 1;

    /**
     * 直接执行
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        long currentTime = SystemTimeUtil.now();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            Object object = AviatorEvaluator.execute(expression);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    /**
     * 编译执行
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        String expression = "1+1";
        Expression expression1 = AviatorEvaluator.compile(expression);
        long currentTime = SystemTimeUtil.now();
        for (int i = 0; i < count; i++) {
            Object object = expression1.execute();
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

}
