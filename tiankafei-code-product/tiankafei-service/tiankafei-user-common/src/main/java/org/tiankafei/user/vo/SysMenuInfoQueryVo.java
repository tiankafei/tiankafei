package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * <pre>
 * 系统功能菜单信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统功能菜单信息表 对象", description = "系统功能菜单信息表 查询参数")
public class SysMenuInfoQueryVo extends BaseQueryVo {

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
    private String menuCode;

    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    @Size(max = 100, message = "功能名称长度不能超过 100 ！")
    @NotBlank(message = "功能名称不能为空")
    private String menuName;

    /**
     * 图标的名称
     */
    @ApiModelProperty(value = "图标的名称")
    @Size(max = 20, message = "图标的名称长度不能超过 20 ！")
    private String icon;

    /**
     * 菜单类型：1目录，2菜单，3按钮
     */
    @ApiModelProperty(value = "菜单类型：1目录，2菜单，3按钮")
    @Size(max = 1, message = "菜单类型：1目录，2菜单，3按钮长度不能超过 1 ！")
    private String menuType;

    /**
     * 打开方式：1页签，2新窗口
     */
    @ApiModelProperty(value = "打开方式：1页签，2新窗口")
    @Size(max = 1, message = "打开方式：1页签，2新窗口长度不能超过 1 ！")
    private String openType;

    /**
     * 功能的url路径
     */
    @ApiModelProperty(value = "功能的url路径")
    @Size(max = 50, message = "功能的url路径长度不能超过 50 ！")
    private String path;

    /**
     * 是否外部链接：1是，0否
     */
    @ApiModelProperty(value = "是否外部链接：1是，0否")
    private Boolean isOutsideUrl;

    /**
     * 状态：1启用，0停用
     */
    @ApiModelProperty(value = "状态：1启用，0停用")
    private Boolean status;

    /**
     * 权限关键字标识
     */
    @ApiModelProperty(value = "权限关键字标识")
    @Size(max = 60, message = "权限关键字标识长度不能超过 60 ！")
    private String keys;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parentId;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序")
    private Integer serialNumber;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

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
     * 子系统功能菜单信息表对象集合
     */
    @ApiModelProperty(value = "子系统功能菜单信息表对象集合")
    private List<SysMenuInfoQueryVo> menuInfoList;

}