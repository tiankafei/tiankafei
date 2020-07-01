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

import java.util.Date;

/**
 * <pre>
 * 系统功能菜单信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统功能菜单信息表 对象", description = "系统功能菜单信息表 查询参数")
public class SysFeatureInfoQueryVo extends BaseQueryVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 功能代码
     */
    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    @NotBlank(message = "功能代码不能为空")
    private String featureCode;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @NotBlank(message = "功能名称不能为空")
    private String featureName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 是否中间节点：1是，0否
     */
    @ApiModelProperty(value = "是否中间节点：1是，0否")
    @Size(max = 1, message = "是否中间节点：1是，0否长度不能超过 1 ！")
    private Boolean isMiddleNode;

    /**
     * 功能的url地址
     */
    @ApiModelProperty(value = "功能的url地址")
    @Size(max = 50, message = "功能的url地址长度不能超过 50 ！")
    private String url;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parentId;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    @Size(max = 1, message = "状态：1启用，0停用长度不能超过 1 ！")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

}