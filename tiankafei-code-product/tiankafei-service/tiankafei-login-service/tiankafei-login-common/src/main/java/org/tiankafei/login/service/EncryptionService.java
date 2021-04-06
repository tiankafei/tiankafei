package org.tiankafei.login.service;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface EncryptionService {

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public String encryption(String str);

    /**
     * 生成token
     *
     * @param str
     * @return
     */
    public String token(String str);

}
