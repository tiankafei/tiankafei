package org.tiankafei.common.util;

import java.io.IOException;
import org.tiankafei.common.exceptions.BaseException;
import org.xerial.snappy.Snappy;

/**
 * snappy压缩解压工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class SnappyUtil {

    /**
     * 压缩
     *
     * @param bytes 要压缩的数据
     * @return 压缩后的数据
     * @throws BaseException 自定义异常
     */
    public static byte[] compress(byte[] bytes) throws BaseException {
        try {
            return Snappy.compress(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 压缩
     *
     * @param str 要压缩的数据
     * @return 压缩后的数据
     * @throws BaseException 自定义异常
     */
    public static byte[] compress(String str) throws BaseException {
        try {
            return Snappy.compress(str);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 解压
     *
     * @param bytes 要解压的数据
     * @return 解压后的数据
     * @throws BaseException 自定义异常
     */
    public static byte[] uncompress(byte[] bytes) throws BaseException {
        try {
            return Snappy.uncompress(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 解压
     *
     * @param bytes 要解压的数据
     * @return 解压后的数据
     * @throws BaseException 自定义异常
     */
    public static String uncompressString(byte[] bytes) throws BaseException {
        try {
            return Snappy.uncompressString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

}
