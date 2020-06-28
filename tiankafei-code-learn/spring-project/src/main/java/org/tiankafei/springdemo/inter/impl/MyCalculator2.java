package org.tiankafei.springdemo.inter.impl;

import org.tiankafei.springdemo.inter.Calculator;
import org.tiankafei.springdemo.util.LogUtil;

public class MyCalculator2 implements Calculator {

    @Override
    public int add(int i, int j) {
        LogUtil.start(i,j);
        int result = i + j;
        LogUtil.stop(result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        LogUtil.start(i,j);
        int result = i - j;
        LogUtil.stop(result);
        return result;
    }

    @Override
    public int mult(int i, int j) {
        LogUtil.start(i,j);
        int result = i * j;
        LogUtil.stop(result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        LogUtil.start(i,j);
        int result = i / j;
        LogUtil.stop(result);
        return result;
    }
}