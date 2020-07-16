package org.tiankafei.user.login.service;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface EncryptionService {

    /**
     * 加密
     * @param str
     * @return
     */
    public String encryption(String str);

}
