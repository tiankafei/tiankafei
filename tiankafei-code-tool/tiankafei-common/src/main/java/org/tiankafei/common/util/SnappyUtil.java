package org.tiankafei.common.util;

import java.io.IOException;
import org.tiankafei.common.exceptions.CommonException;
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
     */
    public static byte[] compress(byte[] bytes) {
        try {
            return Snappy.compress(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("压缩失败！");
        }
    }

    /**
     * 压缩
     *
     * @param str 要压缩的数据
     * @return 压缩后的数据
     */
    public static byte[] compress(String str) {
        try {
            return Snappy.compress(str);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("压缩失败！");
        }
    }

    /**
     * 解压
     *
     * @param bytes 要解压的数据
     * @return 解压后的数据
     */
    public static byte[] uncompress(byte[] bytes) {
        try {
            return Snappy.uncompress(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("解压失败！");
        }
    }

    /**
     * 解压
     *
     * @param bytes 要解压的数据
     * @return 解压后的数据
     */
    public static String uncompressString(byte[] bytes) {
        try {
            return Snappy.uncompressString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("解压失败！");
        }
    }

}
