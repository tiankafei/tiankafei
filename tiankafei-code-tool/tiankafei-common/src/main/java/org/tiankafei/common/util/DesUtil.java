package org.tiankafei.common.util;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.tiankafei.common.exceptions.BaseException;

/**
 * DES加密算法类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class DesUtil {

    /**
     * 算法名称/加密模式/填充方式
     * DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
     */
    private static final String CIPHER_ALGORITHM = "DES/ECB/NoPadding";
    /**
     * DES加密密钥
     */
    private static final String DES_KEY = "A1B2C3D4E5F60708";

    private DesUtil() {

    }

    /**
     * @Description: 生成密钥key对象
     * @Param: [keyStr]
     * @Return: javax.crypto.SecretKey
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static SecretKey keyGenerator(String keyStr) throws BaseException {
        try {
            byte[] input = hexString2Bytes(keyStr);
            DESKeySpec desKey = new DESKeySpec(input);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            return securekey;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * @Description: 解析char
     * @Param: [c]
     * @Return: int
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static int parse(char c) {
        char str = 'a';
        if (c >= str) {
            return (c - str + 10) & 0x0f;
        }
        str = 'A';
        if (c >= str) {
            return (c - str + 10) & 0x0f;
        }
        return (c - '0') & 0x0f;
    }

    /**
     * @Description: 从十六进制字符串到字节数组转换
     * @Param: [hexstr]
     * @Return: byte[]
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static byte[] hexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    /**
     * 加密数据
     * 该部分是为了与加解密在线测试网站（http://tripledes.online-domain-tools.com/）的十六进制结果进行核对
     *
     * @Param: [data, key]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static String encrypt(String data, String key) throws BaseException {
        try {
            Key deskey = keyGenerator(key);
            // 实例化Cipher对象，它用于完成实际的加密操作
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            SecureRandom random = new SecureRandom();
            // 初始化Cipher对象，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
            byte[] results = cipher.doFinal(data.getBytes());
            // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
            return Base64.encodeBase64String(results);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * @Description: 解密数据
     * @Param: [data, key]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    private static String decrypt(String data, String key) throws BaseException {
        try {
            Key deskey = keyGenerator(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化Cipher对象，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, deskey);
            // 执行解密操作
            return new String(cipher.doFinal(Base64.decodeBase64(data)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * @Description: 加密字符串
     * @Param: [encryptionString]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static String encryptionString(String encryptionString) throws BaseException {
        try {
            String encryptData = encrypt(encryptionString, DES_KEY);
            return encryptData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * @Description: 解密字符串
     * @Param: [decryptionString]
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public static String decryptionString(String decryptionString) throws BaseException {
        try {
            String decryptData = decrypt(decryptionString, DES_KEY);
            return decryptData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

}