package org.tiankafei.common.algorithm;

/**
 * 基础运算类
 *
 * @author tiankafei
 */
public interface BaseOperation {

    /**
     * 两数求和
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b);

    /**
     * 两数相减
     *
     * @param a
     * @param b
     * @return
     */
    public int sub(int a, int b);

    /**
     * 两数相乘
     *
     * @param a
     * @param b
     * @return
     */
    public int mul(int a, int b);

    /**
     * 两数相除
     *
     * @param a
     * @param b
     * @return
     */
    public int div(int a, int b);

    /**
     * 两数求模
     *
     * @param a
     * @param b
     * @return
     */
    public int mod(int a, int b);

    /**
     * 数组求平均值
     *
     * @param arr
     * @return
     */
    public int avg(Integer[] arr);

    /**
     * 两数求平均值
     *
     * @param a
     * @param b
     * @return
     */
    int avg(int a, int b);

    /**
     * 求相反数
     *
     * @param x
     * @return
     */
    public int negNum(int x);

    /**
     * 判断是否是负数
     *
     * @param x
     * @return
     */
    default boolean isNeg(int x) {
        return x < 0;
    }

    default <T> void printArray(T[] t){
        for (int index = 0, length = t.length; index < length; index++) {
            System.out.print(t[index] + ", ");
        }
        System.out.println();
    }

}
