package org.tiankafei.common.algorithm;

/**
 * 位运算工具类
 *
 * @author tiankafei
 */
public class BitOperationUtil {

    public static void main(String[] args) {
        System.out.println(add(46, -20));
        System.out.println(sub(46, -20));
        System.out.println(mul(46, -20));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(div(Integer.MIN_VALUE, -23));
        System.out.println(div(Integer.MIN_VALUE, -23) == Integer.MIN_VALUE / -23);

    }

    /**
     * 位运算相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
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

    /**
     * 位运算相减
     *
     * @param a
     * @param b
     * @return
     */
    public static int sub(int a, int b) {
        return add(a, negNum(b));
    }

    /**
     * 取得给定值的相反数
     *
     * @param x
     * @return
     */
    public static int negNum(int x) {
        return add(~x, 1);
    }

    public static boolean isNeg(int x) {
        return x < 0;
    }

    /**
     * 位运算乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int mul(int a, int b) {
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

    public static int div(int a, int b) {
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
    private static int divide(int a, int b) {
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

}
