package org.tiankafei.multidatasource.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_info")
@ApiModel(value = "UserInfoEntity 对象", description = "用户基本信息表")
public class UserInfoEntity extends Model<UserInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @TableField("username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "昵称，中文名")
    @Size(max = 30, message = "昵称，中文名长度不能超过 30 ！")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty(value = "性别：1男，2女，3未知")
    @Size(max = 1, message = "性别：1男，2女，3未知长度不能超过 1 ！")
    @TableField("gender")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @TableField("born_time")
    private Timestamp bornTime;

    @ApiModelProperty(value = "用户头像")
    @Size(max = 100, message = "用户头像长度不能超过 100 ！")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注长度不能超过 100 ！")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "用户类型")
    @Size(max = 2, message = "用户类型长度不能超过 2 ！")
    @TableField("user_type")
    private String userType;

    @ApiModelProperty(value = "部门id")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
    @TableLogic
    private Integer deleteMark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String NICKNAME = "nickname";

    public static final String EMAIL = "email";

    public static final String TELEPHONE = "telephone";

    public static final String GENDER = "gender";

    public static final String BORN_TIME = "born_time";

    public static final String AVATAR = "avatar";

    public static final String REMARK = "remark";

    public static final String USER_TYPE = "user_type";

    public static final String DEPT_ID = "dept_id";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
