package org.tiankafei.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.tiankafei.common.exceptions.CommonException;

/**
 * MD5加密算法类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class Md5Util {

    /**
     * 全局数组
     */
    private final static String[] STR_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private Md5Util() {

    }

    /**
     * 返回字符串MD5加密
     *
     * @param strObj
     * @return
     */
    public static String getMd5StringCode(String strObj) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //该函数返回值为存放哈希值结果的byte数组
            String resultString = byteToString(md.digest(strObj.getBytes()));
            return resultString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CommonException("获取加密方法失败！");
        }
    }

    /**
     * 转换字节数组为16进制字符串
     *
     * @param bByte
     * @return
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }


    /**
     * 返回形式为数字跟字符串
     *
     * @param bByte
     * @return
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return STR_DIGITS[iD1] + STR_DIGITS[iD2];
    }

    /**
     * 返回数字MD5加密
     *
     * @param strObj
     * @return
     */
    public static String getMd5IntegerCode(String strObj) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //该函数返回值为存放哈希值结果的byte数组
            String resultString = byteToInteger(md.digest(strObj.getBytes()));
            return resultString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CommonException("获取加密方法失败！");
        }
    }

    /**
     * 转换字节数组为16进制数字
     *
     * @param bByte
     * @return
     */
    private static String byteToInteger(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToNum(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * 返回形式只为数字
     *
     * @param bByte
     * @return
     */
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

}