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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

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
@TableName("sys_menu_info")
@ApiModel(value = " 系统功能菜单信息表 实体对象", description = "系统功能菜单信息表")
public class SysMenuInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 功能代码
     */
    @ApiModelProperty(value = "功能代码")
    @Size(max = 20, message = "功能代码长度不能超过 20 ！")
    @TableField("menu_code")
    @NotBlank(message = "功能代码不能为空")
    private String menuCode;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @TableField("menu_name")
    @NotBlank(message = "功能名称不能为空")
    private String menuName;

    /**
     * 图标的名称
     */
    @ApiModelProperty(value = "图标的名称")
    @Size(max = 20, message = "图标的名称长度不能超过 20 ！")
    @TableField("icon")
    private String icon;

    /**
     * 菜单类型：1目录，2菜单，3按钮
     */
    @ApiModelProperty(value = "菜单类型：1目录，2菜单，3按钮")
    @Size(max = 1, message = "菜单类型：1目录，2菜单，3按钮长度不能超过 1 ！")
    @TableField("menu_type")
    private String menuType;

    /**
     * 打开方式：1页签，2新窗口
     */
    @ApiModelProperty(value = "打开方式：1页签，2新窗口")
    @Size(max = 1, message = "打开方式：1页签，2新窗口长度不能超过 1 ！")
    @TableField("open_type")
    private String openType;

    /**
     * 功能的url路径
     */
    @ApiModelProperty(value = "功能的url路径")
    @Size(max = 50, message = "功能的url路径长度不能超过 50 ！")
    @TableField("path")
    private String path;

    /**
     * 是否外部链接：1是，0否
     */
    @ApiModelProperty(value = "是否外部链接：1是，0否")
    @TableField("is_outside_url")
    private Boolean isOutsideUrl;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    @TableField("status")
    private Boolean status;

    /**
     * 权限关键字标识
     */
    @ApiModelProperty(value = "权限关键字标识")
    @Size(max = 60, message = "权限关键字标识长度不能超过 60 ！")
    @TableField("keys")
    private String keys;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    @TableField("serial_number")
    private Integer serialNumber;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

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
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 修改用户ID
     */
    @ApiModelProperty(value = "修改用户ID")
    @TableField("update_user_id")
    private Long updateUserId;

}