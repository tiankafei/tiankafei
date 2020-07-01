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
 * 角色信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "角色信息表 对象", description = "角色信息表 查询参数")
public class SysRoleInfoQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 角色代码
     */
    @ApiModelProperty(value = "角色代码")
    @Size(max = 20, message = "角色代码长度不能超过 20 ！")
    @NotBlank(message = "角色代码不能为空")
    private String roleCode;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @Size(max = 100, message = "角色名称长度不能超过 100 ！")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 角色状态:1启用，0停用
     */
    @ApiModelProperty(value = "角色状态:1启用，0停用")
    @Size(max = 1, message = "角色状态:1启用，0停用长度不能超过 1 ！")
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
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

}