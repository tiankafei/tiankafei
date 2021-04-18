package org.tiankafei.common.algorithm;

import java.math.BigDecimal;

/**
 * 普通方式运算符操作
 *
 * @author tiankafei
 */
public class BigOperation implements BaseOperation {

    @Override
    public int add(int a, int b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).intValue();
    }

    @Override
    public int sub(int a, int b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b)).intValue();
    }

    @Override
    public int mul(int a, int b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).intValue();
    }

    @Override
    public int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 0, BigDecimal.ROUND_DOWN).intValue();
    }

    @Override
    public int mod(int a, int b) {
        return BigDecimal.valueOf(a).divideAndRemainder(BigDecimal.valueOf(b))[1].intValue();
    }

    @Override
    public int avg(int a, int b) {
        return (int) (BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).longValue() / 2);
    }

    @Override
    public int avg(Integer[] arr) {
        long length = arr.length;

        BigDecimal resultDecimal = BigDecimal.valueOf(0);

        for (int index = 0; index < length; index++) {
            resultDecimal = resultDecimal.add(BigDecimal.valueOf(arr[index]));
        }

        return (int) (resultDecimal.longValue() / length);
    }

    @Override
    public int negNum(int x) {
        return Math.negateExact(x);
    }
}
