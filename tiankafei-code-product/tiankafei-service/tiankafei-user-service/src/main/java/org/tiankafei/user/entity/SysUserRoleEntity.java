package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * <pre>
 * 用户拥有的角色关系表
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel(value = " 用户拥有的角色关系表 实体对象", description = "用户拥有的角色关系表")
public class SysUserRoleEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 状态：1在用，0停用
     */
    @ApiModelProperty(value = "状态：1在用，0停用")
    @TableField("status")
    @NotNull(message = "状态：1在用，0停用不能为空")
    private Boolean status;

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
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField("update_user_id")
    private Long updateUserId;

}
