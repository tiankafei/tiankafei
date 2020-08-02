package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "验证码返回对象", description = "验证码返回对象")
public class CaptchaParamVo implements Serializable {

    @ApiModelProperty(value = "当前获取的随机字符串")
    private String uuid;

    @ApiModelProperty(value = "图片经过base64转义的字符串")
    private String img;

}
