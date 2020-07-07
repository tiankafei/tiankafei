package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
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
 * @since 1.0
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
     * 节点类型：1目录，2菜单，3按钮
     */
    @ApiModelProperty(value = "节点类型：1目录，2菜单，3按钮")
    @Size(max = 1, message = "节点类型：1目录，2菜单，3按钮长度不能超过 1 ！")
    @TableField("feature_type")
    private String featureType;

    /**
     * 打开方式：1页签，2新窗口
     */
    @ApiModelProperty(value = "打开方式：1页签，2新窗口")
    @Size(max = 1, message = "打开方式：1页签，2新窗口长度不能超过 1 ！")
    @TableField("open_type")
    private String openType;

    /**
     * 功能的url地址
     */
    @ApiModelProperty(value = "功能的url地址")
    @Size(max = 50, message = "功能的url地址长度不能超过 50 ！")
    @TableField("url")
    private String url;

    /**
     * 权限关键字
     */
    @ApiModelProperty(value = "权限关键字")
    @Size(max = 100, message = "权限关键字长度不能超过 100 ！")
    @TableField("keys")
    private String keys;

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
    @TableField("status")
    private Boolean status;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    @TableField("serial_number")
    private Integer serialNumber;

    /**
     * 图标的名称
     */
    @ApiModelProperty(value = "图标的名称")
    @Size(max = 20, message = "图标的名称长度不能超过 20 ！")
    @TableField("icon")
    private String icon;

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
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id")
    @TableField("create_user_id")
    private Long createUserId;

}
