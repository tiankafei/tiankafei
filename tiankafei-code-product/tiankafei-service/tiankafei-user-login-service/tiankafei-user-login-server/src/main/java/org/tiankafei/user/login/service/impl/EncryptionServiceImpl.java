package org.tiankafei.user.login.service.impl;

import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.service.EncryptionService;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Service
public class EncryptionServiceImpl implements EncryptionService {

    @Override
    public String encryption(String str) {
        return SecureUtil.md5(str);
    }

    @Override
    public String token(String str) {
        return SecureUtil.md5(str);
    }

}
