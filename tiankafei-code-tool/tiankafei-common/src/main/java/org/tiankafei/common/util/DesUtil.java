package org.tiankafei.common.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.tiankafei.common.exceptions.CommonException;

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
     * 生成密钥key对象
     *
     * @param keyStr
     * @return
     */
    private static SecretKey keyGenerator(String keyStr) {
        try {
            byte[] input = hexString2Bytes(keyStr);
            DESKeySpec desKey = new DESKeySpec(input);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            return securekey;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new CommonException("加密初始化失败！");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CommonException("获取加密方法失败！");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw new CommonException("生成密钥失败！");
        }
    }

    /**
     * 解析char
     *
     * @param c
     * @return
     */
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
     * 从十六进制字符串到字节数组转换
     *
     * @param hexstr
     * @return
     */
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
     * @param data
     * @param key
     * @return
     */
    private static String encrypt(String data, String key) {
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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CommonException("获取加密方法失败！");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new CommonException("没有获取到加密方法！");
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw new CommonException("加密填充失败！");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new CommonException("加密无效的块大小！");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new CommonException("加密无效的key值！");
        }
    }

    /**
     * 解密数据
     *
     * @param data
     * @param key
     * @return
     */
    private static String decrypt(String data, String key) {
        try {
            Key deskey = keyGenerator(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化Cipher对象，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, deskey);
            // 执行解密操作
            return new String(cipher.doFinal(Base64.decodeBase64(data)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CommonException("获取解密方法失败！");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new CommonException("没有获取到解密方法！");
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw new CommonException("解密填充失败！");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new CommonException("解密无效的块大小！");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new CommonException("解密无效的key值！");
        }
    }

    /**
     * 加密字符串
     *
     * @param encryptionString
     * @return
     */
    public static String encryptionString(String encryptionString) {
        String encryptData = encrypt(encryptionString, DES_KEY);
        return encryptData;
    }

    /**
     * 解密字符串
     *
     * @param decryptionString
     * @return
     */
    public static String decryptionString(String decryptionString) {
        String decryptData = decrypt(decryptionString, DES_KEY);
        return decryptData;
    }

}