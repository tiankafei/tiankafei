package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 系统功能菜单信息表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Data
@Accessors(chain = true)
@TableName("sys_feature_info")
@ApiModel(value = " 系统功能菜单信息表 实体对象" , description = "系统功能菜单信息表")
public class SysFeatureInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    /**
     * 功能代码
     */
    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    @TableField("feature_code")
    @NotBlank(message = "功能代码不能为空")
    private String featureCode;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @TableField("feature_name")
    @NotBlank(message = "功能名称不能为空")
    private String featureName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    /**
     * 是否中间节点：1是，0否
     */
    @ApiModelProperty(value = "是否中间节点：1是，0否")
    @Size(max = 1, message = "是否中间节点：1是，0否长度不能超过 1 ！")
    @TableField("is_middle_node")
    private Boolean isMiddleNode;

    /**
     * 功能的url地址
     */
    @ApiModelProperty(value = "功能的url地址")
    @Size(max = 50, message = "功能的url地址长度不能超过 50 ！")
    @TableField("url")
    private String url;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    @Size(max = 1, message = "状态：1启用，0停用长度不能超过 1 ！")
    @TableField("status")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Date updateTime;

    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    @TableField("create_user_id")
    private Long createUserId;

}
