package org.tiankafei.user.login.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.cache.UserInfoCache;
import org.tiankafei.web.common.param.CaptchaParamVo;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.web.common.utils.ImageCaptcha;
import org.tiankafei.web.common.exception.VerificationException;

import java.io.ByteArrayOutputStream;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private UserInfoCache userInfoCache;

    /**
     * 生成验证码
     *
     * @return
     * @throws VerificationException
     */
    @Override
    public CaptchaParamVo createCaptcha() throws VerificationException {
        String uuid = IdUtil.randomUUID();
        // 组装验证码的key值
        String key = ImageCaptcha.getCaptchaKey(uuid);
        // 生成验证码及图片
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String captchaCode = ImageCaptcha.require(outputStream).build().finish();
        // 验证码放进缓存当中
        userInfoCache.setCaptchaCode(key, captchaCode);

        CaptchaParamVo captchaParamVo = new CaptchaParamVo().setUuid(uuid).setImg(Base64.encode(outputStream.toByteArray()));
        return captchaParamVo;
    }

    /**
     * 校验验证码
     *
     * @param captcha
     * @return
     * @throws VerificationException
     */
    @Override
    public boolean verifyCaptcha(String uuid, String captcha) throws VerificationException {
        // 组装验证码的key值
        String key = ImageCaptcha.getCaptchaKey(uuid);
        String captchaCode = userInfoCache.getCaptchaCode(key);
        if(captcha.equalsIgnoreCase(captchaCode)){
            userInfoCache.removeKey(key);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
