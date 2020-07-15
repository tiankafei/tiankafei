package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * <pre>
 * 用户登录信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户登录信息表 对象", description = "用户登录信息表 查询参数")
public class SysUserLoginQueryVo extends BaseQueryVo {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    private String telephone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 状态：1正常，2停用，3指定有效期
     */
    @ApiModelProperty(value = "状态：1正常，2停用，3指定有效期")
    @Size(max = 1, message = "状态：1正常，2停用，3指定有效期长度不能超过 1 ！")
    @NotBlank(message = "状态不能为空")
    private String status;

    /**
     * 有效期截至时间
     */
    @ApiModelProperty(value = "有效期截至时间")
    private Timestamp expirationDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

}