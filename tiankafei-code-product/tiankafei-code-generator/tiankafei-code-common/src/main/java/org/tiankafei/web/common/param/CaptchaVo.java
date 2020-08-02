package org.tiankafei.web.common.param;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class CaptchaVo implements Serializable {

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 验证码表达式
     */
    private String expression;

}
