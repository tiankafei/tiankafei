package org.tiankafei.common.algorithm;

/**
 * 位运算工具类
 *
 * @author tiankafei
 */
public class BitOperationUtil {

    public static void main(String[] args) {
        System.out.println(add(46, 20));
        System.out.println(sub(46, 20));
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

}
