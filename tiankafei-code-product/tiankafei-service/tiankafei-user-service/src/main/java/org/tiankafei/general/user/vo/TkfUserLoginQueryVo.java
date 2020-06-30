package org.tiankafei.general.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.tiankafei.web.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * <pre>
 * 用户登录信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-06-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户登录信息表 对象", description = "用户登录信息表 查询参数")
public class TkfUserLoginQueryVo extends BaseQueryVo {

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
    private String username;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
    @Size(max = 80, message = "电子邮件长度不能超过 80 ！")
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
    private String password;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过 2 ！")
    private String status;

    /**
     * 有效期截至时间
     */
    @ApiModelProperty(value = "有效期截至时间")
    private Date expirationDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}