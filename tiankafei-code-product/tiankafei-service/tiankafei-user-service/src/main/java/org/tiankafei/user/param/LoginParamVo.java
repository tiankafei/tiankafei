package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * @Author 魏双双
 * @Date 2020/7/7
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "登录参数 对象", description = "登录参数 对象")
public class LoginParamVo extends BaseQueryVo {

    /**
     * 登录类型
     */
    @ApiModelProperty(value = "登录类型：1用户名，2邮箱，3手机号码")
    private Integer loginType;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户输入的用户账号")
    @NotBlank(message = "登录用户账号不允许为空")
    private String keywords;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @NotBlank(message = "登录用户密码不允许为空")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "验证码不允许为空")
    private String verificationCode;

}
