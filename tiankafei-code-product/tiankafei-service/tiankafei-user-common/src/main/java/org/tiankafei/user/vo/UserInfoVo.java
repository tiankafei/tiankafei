package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <pre>
 * 用户基本信息表 查询结果对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户基本信息表 对象", description = "用户基本信息表 查询参数")
public class UserInfoVo extends BaseQueryVo {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 昵称，中文名
     */
    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 30, message = "昵称，中文名长度不能超过 30 ！")
    private String nickname;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    private String telephone;

    /**
     * 性别：1男，2女，3未知
     */
    @ApiModelProperty(value = "性别：1男，2女，3未知")
    @Size(max = 1, message = "性别：1男，2女，3未知长度不能超过 1 ！")
    private String gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Timestamp bornTime;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    @Size(max = 100, message = "用户头像长度不能超过 100 ！")
    private String avatar;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    private String remark;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    @Size(max = 2, message = "用户类型长度不能超过 2 ！")
    private String userType;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer deptId;

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
     * 登录用户对象
     */
    @ApiModelProperty(value = "登录用户对象")
    private @Valid UserLoginVo userLoginQueryVo;

    /**
     * 用户对应的角色集合
     */
    @ApiModelProperty(value = "用户对应的角色集合", hidden = true)
    private List<UserRoleVo> userRoleList;

    @ApiModelProperty(value = "用户分配的角色集合")
    private List<RoleInfoVo> roleInfoList;

    @ApiModelProperty(value = "已经组装成树结构的功能菜单集合")
    private List<MenuInfoVo> menuInfoList;

}