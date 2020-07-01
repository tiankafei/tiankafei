package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.tiankafei.web.common.vo.BaseQueryVo;

import java.sql.Timestamp;

/**
 * <pre>
 * 用户基本信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户基本信息表 对象", description = "用户基本信息表 查询参数")
public class SysUserInfoQueryVo extends BaseQueryVo {

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
     * 昵称，中文名
     */
    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 20, message = "昵称，中文名长度不能超过 20 ！")
    private String nickname;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 100, message = "邮箱长度不能超过 100 ！")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 13, message = "手机号码长度不能超过 13 ！")
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
    private Timestamp expirationDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    /**
     * 性别：1男，2女
     */
    @ApiModelProperty(value = "性别：1男，2女")
    private Integer gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date bornTime;

}