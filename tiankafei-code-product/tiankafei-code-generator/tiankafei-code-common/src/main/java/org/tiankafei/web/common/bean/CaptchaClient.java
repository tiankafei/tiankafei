package org.tiankafei.web.common.bean;

import com.google.common.collect.Maps;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.CaptchaGenerateService;

/**
 * @author tiankafei
 * @since 1.0
 */
@Component
public class CaptchaClient implements InitializingBean {

    private Map<String, CaptchaGenerateService> tokenServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CaptchaGenerateService> beansOfType = applicationContextHelper.getBeansOfType(CaptchaGenerateService.class);
        Set<Map.Entry<String, CaptchaGenerateService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, CaptchaGenerateService> entry : entries) {
            CaptchaGenerateService captchaGenerateService = entry.getValue();
            tokenServiceMap.put(captchaGenerateService.getCaptchaType().getCode(), captchaGenerateService);
        }
    }

    public String buildImage(String captchaType, OutputStream outputStream) throws VerificationException {
        return tokenServiceMap.get(captchaType).buildImage(outputStream);
    }

    public String buildImage(String captchaType, OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        return tokenServiceMap.get(captchaType).buildImage(outputStream, width, height, length, captchaTypeEnum);
    }

}
