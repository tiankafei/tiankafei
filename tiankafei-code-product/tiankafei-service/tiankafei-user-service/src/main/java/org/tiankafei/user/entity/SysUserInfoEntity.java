package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import org.tiankafei.web.common.entity.BaseEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 用户基本信息表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_info")
@ApiModel(value = " 用户基本信息表 实体对象" , description = "用户基本信息表")
public class SysUserInfoEntity extends BaseEntity {

    /**
     * 主键，
     * 跟随 SysUserLoginEntity 这个对象入库之后，得到其id，然后再赋值给该对象
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id" , type = IdType.INPUT)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @TableField("username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 昵称，中文名
     */
    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 20, message = "昵称，中文名长度不能超过 20 ！")
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 100, message = "邮箱长度不能超过 100 ！")
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 13, message = "手机号码长度不能超过 13 ！")
    @TableField("telephone")
    private String telephone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @TableField("password")
    private String password;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过 2 ！")
    @TableField("status")
    private String status;

    /**
     * 有效期截至时间
     */
    @ApiModelProperty(value = "有效期截至时间")
    @TableField("expiration_date")
    private Timestamp expirationDate;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @TableField("department_id")
    private Integer departmentId;

    /**
     * 性别：1男，2女
     */
    @ApiModelProperty(value = "性别：1男，2女")
    @TableField("gender")
    private Integer gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @TableField("born_time")
    private Date bornTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Timestamp updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private Long createUserId;

}
