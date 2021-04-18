package org.tiankafei.common.algorithm;

import java.util.Arrays;

/**
 * 位运算工具类
 *
 * @author tiankafei
 */
public class OperationMain {

    static BaseOperation bigOperation = new BigOperation();
    static BaseOperation bitOperation = new BitOperation();

    public static void main(String[] args) {
        System.out.println("开始测试！");
        add();
        sub();
        mul();
        div();
        mod();
        avg();
        avgArray();
        System.out.println("测试结束！");

        System.out.println(bigOperation.add(46, -20));
        System.out.println(bigOperation.sub(46, -20));
        System.out.println(bigOperation.mul(46, -20));
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(bigOperation.div(Integer.MIN_VALUE, -23));
        System.out.println(bigOperation.div(Integer.MIN_VALUE, -23) == Integer.MIN_VALUE / -23);
        System.out.println(bigOperation.avg(2, 4));
        System.out.println(bigOperation.avg(12, 50));
//
        Integer[] arr = new Integer[]{};
        System.out.println(bigOperation.avg(Arrays.asList(1, 3, 5, 7, 9).toArray(arr)));
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println(bigOperation.avg(Arrays.asList(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 5, Integer.MAX_VALUE - 7).toArray(arr)));
//
        System.out.println(bigOperation.mod(110, 50));
    }

    public static void add() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.add(a, b);
            int s2 = bitOperation.add(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }
    }

    public static void sub() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.sub(a, b);
            int s2 = bitOperation.sub(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }
    }

    public static void mul() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.mul(a, b);
            int s2 = bitOperation.mul(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }
    }

    public static void div() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.div(a, b);
            int s2 = bitOperation.div(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }

        int a = Integer.MIN_VALUE;
        int b = 20;
        int s1 = bigOperation.div(a, b);
        int s2 = bitOperation.div(a, b);
        boolean flag = s1 == s2;
        if (!flag) {
            System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
        }
    }

    public static void mod() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.mod(a, b);
            int s2 = bitOperation.mod(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }

        int a = Integer.MIN_VALUE;
        int b = 22;
        int s1 = bigOperation.mod(a, b);
        int s2 = bitOperation.mod(a, b);
        boolean flag = s1 == s2;
        if (!flag) {
            System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
        }
    }

    public static void avg() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            int a = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int b = BaseConversionUtil.randomValue(Integer.MAX_VALUE);
            int s1 = bigOperation.avg(a, b);
            int s2 = bitOperation.avg(a, b);
            boolean flag = s1 == s2;
            if (!flag) {
                System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }

        int a = Integer.MAX_VALUE - 2;
        int b = Integer.MAX_VALUE - 4;
        int s1 = bigOperation.avg(a, b);
        int s2 = bitOperation.avg(a, b);
        boolean flag = s1 == s2;
        if (!flag) {
            System.out.println("出错了！值分别为：a=" + a + ", b=" + b + ", 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
        }
    }

    public static void avgArray() {
        int times = 100000;
        for (int index = 0; index < times; index++) {
            Integer[] arr = BaseConversionUtil.randomFixLenArray(10, Integer.MAX_VALUE);
            int s1 = bigOperation.avg(arr);
            int s2 = bitOperation.avg(arr);
            boolean flag = s1 == s2;
            if (!flag) {
                bigOperation.printArray(arr);
                System.out.println("出错了！, 普通运算结果为：" + s1 + ",位运算结果为：" + s2);
            }
        }
    }

//    /**
//     * 位运算相加
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int add(int a, int b) {
//        int x = a;
//        int y = b;
//        while (b != 0) {
//            x = a ^ b;
//            y = (a & b) << 1;
//            a = x;
//            b = y;
//        }
//        return x;
//    }
//
//    /**
//     * 位运算相减
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int sub(int a, int b) {
//        return add(a, negNum(b));
//    }
//
//    /**
//     * 求两个数的平均值
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int avg(int a, int b) {
//        return add(a, b) >> 1;
//    }
//
//    /**
//     * 计算一个数组的平均值
//     *
//     * @param arr
//     * @return
//     */
//    public static int avg(Integer[] arr) {
//        int avg = 0;
//        int mod = 0;
//        int length = arr.length;
//        for (int index = 0; index < length; index++) {
//            avg += div(arr[index], length);
//            mod += arr[index] % length;
//        }
//        return avg + div(mod, length);
//    }
//
//    /**
//     * 取得给定值的相反数
//     *
//     * @param x
//     * @return
//     */
//    public static int negNum(int x) {
//        return add(~x, 1);
//    }
//
//    public static boolean isNeg(int x) {
//        return x < 0;
//    }
//
//    /**
//     * 位运算乘法
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int mul(int a, int b) {
//        int res = 0;
//        while (b != 0) {
//            if ((b & 1) != 0) {
//                res = add(a, res);
//            }
//
//            a <<= 1;
//            b >>>= 1;
//        }
//        return res;
//    }
//
//    public static int div(int a, int b) {
//        int res = 0;
//
//        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
//            return 1;
//        } else if (b == Integer.MIN_VALUE) {
//            return 0;
//        } else if (a == Integer.MIN_VALUE) {
//            if (b == negNum(1)) {
//                return Integer.MAX_VALUE;
//            } else {
//                // (a + 1) / b == c
//                // a - (b * c) = d
//                // d / b = e
//                // c + e
//
//                int c = div(add(a, 1), b);
//                res = add(c, div(sub(a, mul(b, c)), b));
//            }
//        } else {
//            res = divide(a, b);
//        }
//
//        return res;
//    }
//
//    /**
//     * 真正两个数的除法运算
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    private static int divide(int a, int b) {
//        boolean f1 = isNeg(a);
//        boolean f2 = isNeg(b);
//
//        int res = 0;
//
//        a = f1 ? negNum(a) : a;
//        b = f2 ? negNum(b) : b;
//
//        for (int i = 30; i >= 0; i--) {
//            if (a >> i >= b) {
//                // 1 左移i位 或 上res：在指定位置置成1
//                res = res | (1 << i);
//                // a 右移i位大于等于b, 那么b左移i位就会和a很接近，然后用a减掉很接近的这个值，继续周而复始
//                a = sub(a, b << i);
//            }
//        }
//
//        // f1 ^ f2 相同为0，false。不同为1，true
//        return f1 ^ f2 ? negNum(res) : res;
//    }
//
//    /**
//     * 求两个数的模
//     *
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int mod(int a, int b) {
//        a = isNeg(a) ? negNum(a) : a;
//        b = isNeg(b) ? negNum(b) : b;
//
//        for (int i = 30; i >= 0; i--) {
//            if (a >> i >= b) {
//                // a 右移i位大于等于b, 那么b左移i位就会和a很接近，然后用a减掉很接近的这个值，继续周而复始
//                a = sub(a, b << i);
//            }
//        }
//
//        return a;
//    }

}
