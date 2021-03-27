package org.tiankafei.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.exceptions.CommonException;

/**
 * 密码加密工具类
 *
 * @author geekidea
 * @date 2018-11-08
 */
@Slf4j
public class PasswordUtil {

    /**
     * 密码加盐，再加密
     *
     * @param pwd
     * @param salt
     * @return
     */
    public static String encrypt(String pwd, String salt) {
        if (StringUtils.isBlank(pwd)) {
            throw new CommonException("密码不能为空");
        }
        if (StringUtils.isBlank(salt)) {
            throw new CommonException("盐值不能为空");
        }
        return DigestUtils.sha256Hex(pwd + salt);
    }

}
