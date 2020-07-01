package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 系统角色对应的功能配置表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_feature")
@ApiModel(value = " 系统角色对应的功能配置表 实体对象" , description = "系统角色对应的功能配置表")
public class SysRoleFeatureEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 功能id
     */
    @ApiModelProperty(value = "功能id")
    @TableField("feature_id")
    @NotNull(message = "功能id不能为空")
    private Integer featureId;

}
