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
    }

    private static String printTwoBase(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int init = 31;
        for (int i = init; i >= 0; i--) {
            stringBuilder.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return stringBuilder.toString();
    }

}
