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

/**
 * <pre>
 * 系统角色对应的功能配置表
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel(value = " 系统角色对应的功能配置表 实体对象", description = "系统角色对应的功能配置表")
public class SysRoleMenuEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @TableField(value = "role_id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    @TableField(value = "menu_id")
    @NotNull(message = "菜单id不能为空")
    private Integer menuId;

}
