package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <pre>
 * 系统角色对应的功能配置表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统角色对应的功能配置表 对象", description = "系统角色对应的功能配置表 查询参数")
public class RoleMenuVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    @NotNull(message = "菜单id不能为空")
    private Integer menuId;

    /**
     * 系统功能菜单信息表 对象
     */
    @ApiModelProperty(value = "系统功能菜单信息表 对象")
    private MenuInfoVo menuInfoQueryVo;

}