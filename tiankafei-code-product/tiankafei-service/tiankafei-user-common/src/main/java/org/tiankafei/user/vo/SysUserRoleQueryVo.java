package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * <pre>
 * 用户拥有的角色关系表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户拥有的角色关系表 对象", description = "用户拥有的角色关系表 查询参数")
public class SysUserRoleQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 状态：1在用，0停用
     */
    @ApiModelProperty(value = "状态：1在用，0停用")
    @NotNull(message = "状态：1在用，0停用不能为空")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;

    /**
     * 角色信息表 对象
     */
    @ApiModelProperty(value = "角色信息表 对象")
    private SysRoleInfoQueryVo roleInfoQueryVo;

}