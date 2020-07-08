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
import java.util.Date;

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
public class SysRoleMenuQueryVo extends BaseQueryVo {

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

}