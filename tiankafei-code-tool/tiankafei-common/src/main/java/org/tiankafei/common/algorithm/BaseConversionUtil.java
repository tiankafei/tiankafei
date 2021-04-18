package org.tiankafei.common.algorithm;

/**
 * 进制转换工具类
 *
 * @author tiankafei
 */
public class BaseConversionUtil {

    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println("(1 << 31) - 1 : " + ((1 << 31) - 1));
        System.out.println("1 << 31 : " + (1 << 31));
        System.out.println("\t\t0的二进制 ：" + printTwoBase(0));
        System.out.println("\t\t4的二进制 ：" + printTwoBase(4));
        System.out.println(num + "的二进制 ：" + printTwoBase(Integer.MAX_VALUE));
        System.out.println("\t\t-1的二进制 ：" + printTwoBase(-1));
        System.out.println("========================");

        int times = 100000;
        for (int index = 0; index < times; index++) {
            int value = randomValue(times);
//            boolean flag = (value % 2) == mod2(value);
//            boolean flag = (value % 4) == mod4(value);
//            boolean flag = (value % 8) == mod8(value);
//            boolean flag = (value % 16) == mod16(value);
//            boolean flag = (value % 32) == mod32(value);
//            boolean flag = (value % 64) == mod64(value);
//            boolean flag = (value % 128) == mod128(value);
//            boolean flag = (value % 256) == mod256(value);
//            boolean flag = (value % 512) == mod512(value);
//            boolean flag = (value % 1024) == mod1024(value);
//            boolean flag = (value % 2048) == mod2048(value);
            boolean flag = (value % 4096) == mod4096(value);
            if (!flag) {
                System.out.println("例外情况：值是：" + value);
            }

//            flag = (value * 2) == mul2(value);
//            flag = (value * 4) == mul4(value);
//            flag = (value * 8) == mul8(value);
//            flag = (value * 16) == mul16(value);
//            flag = (value * 32) == mul32(value);
//            flag = (value * 64) == mul64(value);
//            flag = (value * 128) == mul128(value);
//            flag = (value * 256) == mul256(value);
//            flag = (value * 512) == mul512(value);
//            flag = (value * 1024) == mul1024(value);
//            flag = (value * 2048) == mul2048(value);
            flag = (value * 4096) == mul4096(value);
            if (!flag) {
                System.out.println("例外情况：值是：" + value);
            }

//            flag = (value / 2) == div2(value);
//            flag = (value / 4) == div4(value);
//            flag = (value / 8) == div8(value);
//            flag = (value / 16) == div16(value);
//            flag = (value / 32) == div32(value);
//            flag = (value / 64) == div64(value);
//            flag = (value / 128) == div128(value);
//            flag = (value / 256) == div256(value);
//            flag = (value / 512) == div512(value);
//            flag = (value / 1024) == div1024(value);
//            flag = (value / 2048) == div2048(value);
            flag = (value / 4096) == div4096(value);
            if (!flag) {
                System.out.println("例外情况：值是：" + value);
            }
        }
        System.out.println("========================");
    }

    /**
     * 打印数字的二进制
     *
     * @param num 数字
     * @return 二进制
     */
    public static String printTwoBase(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int init = 31;
        for (int i = init; i >= 0; i--) {
            stringBuilder.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return stringBuilder.toString();
    }

    /**
     * 随机生成一个[0, MaxValue)的值
     *
     * @param maxValue 最大值
     * @return
     */
    public static Integer randomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    /**
     * 随机生成固定长度的，最大值是【maxValue】的数组
     * @param len   固定的长度
     * @param maxValue  最大值
     * @return
     */
    public static Integer[] randomFixLenArray(int len, int maxValue) {
        Integer[] arr = new Integer[len];

        for (int index = 0; index < len; index++) {
            int v = (int) (Math.random() * maxValue);
            arr[index] = v;
        }

        return arr;
    }

    /**
     * 随机生成最大长度是【maxLen】的，最大值是【maxValue】的数组
     * @param maxLen    最大长度
     * @param maxValue  最大值
     * @return
     */
    public static Integer[] randomValueArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);

        return randomFixLenArray(len, maxValue);
    }

    public static Integer mod2(int num) {
        return num & 1;
    }

    public static Integer mod4(int num) {
        return num & 3;
    }

    public static Integer mod8(int num) {
        return num & 7;
    }

    public static Integer mod16(int num) {
        return num & 15;
    }

    public static Integer mod32(int num) {
        return num & 31;
    }

    public static Integer mod64(int num) {
        return num & 63;
    }

    public static Integer mod128(int num) {
        return num & 127;
    }

    public static Integer mod256(int num) {
        return num & 255;
    }

    public static Integer mod512(int num) {
        return num & 511;
    }

    public static Integer mod1024(int num) {
        return num & 1023;
    }

    public static Integer mod2048(int num) {
        return num & 2047;
    }

    public static Integer mod4096(int num) {
        return num & 4095;
    }

    public static Integer mul2(int num) {
        return num << 1;
    }

    public static Integer mul4(int num) {
        return num << 2;
    }

    public static Integer mul8(int num) {
        return num << 3;
    }

    public static Integer mul16(int num) {
        return num << 4;
    }

    public static Integer mul32(int num) {
        return num << 5;
    }

    public static Integer mul64(int num) {
        return num << 6;
    }

    public static Integer mul128(int num) {
        return num << 7;
    }

    public static Integer mul256(int num) {
        return num << 8;
    }

    public static Integer mul512(int num) {
        return num << 9;
    }

    public static Integer mul1024(int num) {
        return num << 10;
    }

    public static Integer mul2048(int num) {
        return num << 11;
    }

    public static Integer mul4096(int num) {
        return num << 12;
    }

    public static Integer div2(int num) {
        return num >> 1;
    }

    public static Integer div4(int num) {
        return num >> 2;
    }

    public static Integer div8(int num) {
        return num >> 3;
    }

    public static Integer div16(int num) {
        return num >> 4;
    }

    public static Integer div32(int num) {
        return num >> 5;
    }

    public static Integer div64(int num) {
        return num >> 6;
    }

    public static Integer div128(int num) {
        return num >> 7;
    }

    public static Integer div256(int num) {
        return num >> 8;
    }

    public static Integer div512(int num) {
        return num >> 9;
    }

    public static Integer div1024(int num) {
        return num >> 10;
    }

    public static Integer div2048(int num) {
        return num >> 11;
    }

    public static Integer div4096(int num) {
        return num >> 12;
    }

}
