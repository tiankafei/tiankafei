package org.tiankafei.user.login.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.constraints.MobilePhone;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "用户登录对象", description = "用户登录对象")
public class LoginQueryVo implements Serializable {

    /**
     * 登录类型
     */
    @ApiModelProperty(value = "登录类型：1用户名，2邮箱，3手机号码")
    private Integer loginType;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户输入的用户账号")
    private String userAccount;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 100, message = "邮箱长度不能超过 100 ！")
    @Email(message = "请输入有效的邮箱")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 13, message = "手机号码长度不能超过 13 ！")
    @MobilePhone
    private String telephone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    private String verificationCode;

}
