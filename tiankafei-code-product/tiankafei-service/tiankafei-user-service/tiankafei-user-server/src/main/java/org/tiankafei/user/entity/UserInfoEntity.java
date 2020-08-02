package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.entity.BaseEntity;

/**
 * <pre>
 * 用户基本信息表
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_info")
@ApiModel(value = " 用户基本信息表 实体对象", description = "用户基本信息表")
public class UserInfoEntity extends BaseEntity {

    /**
     * 主键，
     * 跟随 SysUserLoginEntity 这个对象入库之后，得到其id，然后再赋值给该对象
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @TableField(value = "username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 昵称，中文名
     */
    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 30, message = "昵称，中文名长度不能超过 30 ！")
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 性别：1男，2女，3未知
     */
    @ApiModelProperty(value = "性别：1男，2女，3未知")
    @Size(max = 1, message = "性别：1男，2女，3未知长度不能超过 1 ！")
    @TableField(value = "gender")
    private String gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @TableField(value = "born_time")
    private Timestamp bornTime;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    @Size(max = 100, message = "用户头像长度不能超过 100 ！")
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    @TableField(value = "remark")
    private String remark;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    @Size(max = 2, message = "用户类型长度不能超过 2 ！")
    @TableField(value = "user_type")
    private String userType;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

}
