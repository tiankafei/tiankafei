package org.tiankafei.base.util;

import java.security.MessageDigest;
import org.tiankafei.base.exceptions.BaseException;

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
     * @Description: 返回字符串MD5加密
     * @Param: [strObj]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static String getMd5StringCode(String strObj) throws BaseException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //该函数返回值为存放哈希值结果的byte数组
            String resultString = byteToString(md.digest(strObj.getBytes()));
            return resultString;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BaseException(ex.getMessage());
        }
    }

    /**
     * @Description: 转换字节数组为16进制字符串
     * @Param: [bByte]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }


    /**
     * @Description: 返回形式为数字跟字符串
     * @Param: [bByte]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
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
     * @Description: 返回数字MD5加密
     * @Param: [strObj]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static String getMd5IntegerCode(String strObj) throws BaseException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //该函数返回值为存放哈希值结果的byte数组
            String resultString = byteToInteger(md.digest(strObj.getBytes()));
            return resultString;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BaseException(ex.getMessage());
        }
    }

    /**
     * @Description: 转换字节数组为16进制数字
     * @Param: [bByte]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static String byteToInteger(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToNum(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * @Description: 返回形式只为数字
     * @Param: [bByte]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

}