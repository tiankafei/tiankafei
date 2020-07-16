package org.tiankafei.user.login.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.cache.CacheManagerRepository;
import org.tiankafei.cache.CacheQueryRepository;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.web.common.bean.CaptchaClient;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.param.CaptchaParamVo;
import org.tiankafei.web.common.utils.ImageCaptchaUtil;

import java.io.ByteArrayOutputStream;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private CacheManagerRepository cacheManagerRepository;

    @Autowired
    private CacheQueryRepository cacheQueryRepository;

    @Autowired
    private CaptchaClient captchaClient;

    /**
     * 生成验证码
     *
     * @return
     * @throws VerificationException
     */
    @Override
    public CaptchaParamVo createCaptcha(String uuid) throws VerificationException {
        if (StringUtils.isNotBlank(uuid)) {
            // 当传入的uuid不为空时，删除之前的验证码缓存
            String key = ImageCaptchaUtil.getCaptchaKey(uuid);
            cacheManagerRepository.deleteObject(key);
        }
        uuid = IdUtil.simpleUUID();
        // 组装验证码的key值
        String key = ImageCaptchaUtil.getCaptchaKey(uuid);
        // 生成验证码及图片
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String captchaCode = captchaClient.buildImage(CaptchaEnum.RUO_YI_UTIL.getCode(), outputStream);
        log.info("生成的验证码是：{}", captchaCode);
        // 验证码放进缓存当中
        cacheManagerRepository.setCacheObject(key, captchaCode, 5, TimeUnit.MINUTES);

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
        String key = ImageCaptchaUtil.getCaptchaKey(uuid);
        String captchaCode = cacheQueryRepository.<String>getCacheObject(key);
        if (captcha.equalsIgnoreCase(captchaCode)) {
            cacheManagerRepository.deleteObject(key);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
