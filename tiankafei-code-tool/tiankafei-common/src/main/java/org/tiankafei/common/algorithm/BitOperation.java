package org.tiankafei.common.algorithm;

/**
 * 二进制运算符操作
 *
 * @author tiankafei
 */
public class BitOperation implements BaseOperation {

    @Override
    public int add(int a, int b) {
        int x = a;
        int y = b;
        while (b != 0) {
            x = a ^ b;
            y = (a & b) << 1;
            a = x;
            b = y;
        }
        return x;
    }

    @Override
    public int sub(int a, int b) {
        return add(a, negNum(b));
    }

    @Override
    public int mul(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(a, res);
            }

            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    @Override
    public int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        int res = 0;

        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                // (a + 1) / b == c
                // a - (b * c) = d
                // d / b = e
                // c + e

                int c = div(add(a, 1), b);
                res = add(c, div(sub(a, mul(b, c)), b));
            }
        } else {
            res = divide(a, b);
        }

        return res;
    }

    /**
     * 真正两个数的除法运算
     *
     * @param a
     * @param b
     * @return
     */
    private int divide(int a, int b) {
        boolean f1 = isNeg(a);
        boolean f2 = isNeg(b);

        int res = 0;

        a = f1 ? negNum(a) : a;
        b = f2 ? negNum(b) : b;

        for (int i = 30; i >= 0; i--) {
            if (a >> i >= b) {
                // 1 左移i位 或 上res：在指定位置置成1
                res = res | (1 << i);
                // a 右移i位大于等于b, 那么b左移i位就会和a很接近，然后用a减掉很接近的这个值，继续周而复始
                a = sub(a, b << i);
            }
        }

        // f1 ^ f2 相同为0，false。不同为1，true
        return f1 ^ f2 ? negNum(res) : res;
    }

    @Override
    public int mod(int a, int b) {
        int res = 0;

        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            // 能除尽
            return 0;
        } else if (b == Integer.MIN_VALUE) {
            // 必然除不尽
            return a;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                // 大数除以1余数为0
                return 0;
            } else {
                // (a + 1) / b == c1
                // a - (b * c1) = d (res)

                int c1 = div(add(a, 1), b);
                res = sub(a, mul(b, c1));
            }
        } else {
            res = modle(a, b);
        }

        return res;
    }

    private int modle(int a, int b) {
        boolean f1 = isNeg(a);
        boolean f2 = isNeg(b);

        a = f1 ? negNum(a) : a;
        b = f2 ? negNum(b) : b;

        for (int i = 30; i >= 0; i--) {
            if (a >> i >= b) {
                // a 右移i位大于等于b, 那么b左移i位就会和a很接近，然后用a减掉很接近的这个值，继续周而复始
                a = sub(a, b << i);
            }
        }
        // f1 ^ f2 相同为0，false。不同为1，true
        return f1 ^ f2 ? negNum(a) : a;
    }

    @Override
    public int avg(int a, int b) {
        if (a > b) {
            return add(b, sub(a, b) >> 1);
        } else if (a < b) {
            return add(a, sub(b, a) >> 1);
        } else {
            return a;
        }
    }

    @Override
    public int avg(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        if (arr.length == 1) {
            return arr[0];
        }
        int avg = 0;
        int mod = 0;
        for (int index = 0; index < length; index++) {
            avg = add(avg, div(arr[index], length));
            mod = add(mod, mod(arr[index], length));
        }
        return add(avg, div(mod, length));
    }

    @Override
    public int negNum(int x) {
        return add(~x, 1);
    }
}
