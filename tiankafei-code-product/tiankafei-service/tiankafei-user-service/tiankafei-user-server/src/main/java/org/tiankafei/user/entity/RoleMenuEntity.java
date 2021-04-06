package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统角色对应的功能配置表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel(value = "RoleMenuEntity 对象", description = "系统角色对应的功能配置表")
public class RoleMenuEntity extends Model<RoleMenuEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    @NotNull(message = "菜单id不能为空")
    private Integer menuId;

    @ApiModelProperty(value = "租户ID")
    @TableField("tenant_id")
    private Long tenantId;


    public static final String ID = "id";

    public static final String ROLE_ID = "role_id";

    public static final String MENU_ID = "menu_id";

    public static final String TENANT_ID = "tenant_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
