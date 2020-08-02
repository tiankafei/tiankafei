package org.tiankafei.user.entity;

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
 * 用户登录信息表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_login")
@ApiModel(value = "UserLoginEntity 对象", description = "用户登录信息表")
public class UserLoginEntity extends Model<UserLoginEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @TableField("username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "状态：1正常，2停用，3指定有效期")
    @Size(max = 1, message = "状态：1正常，2停用，3指定有效期长度不能超过 1 ！")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "乐观锁版本")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("delete_mark")
    @TableLogic
    private Integer deleteMark;

    @ApiModelProperty(value = "有效期截至时间")
    @TableField("expiration_date")
    private Timestamp expirationDate;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String EMAIL = "email";

    public static final String TELEPHONE = "telephone";

    public static final String PASSWORD = "password";

    public static final String STATUS = "status";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String EXPIRATION_DATE = "expiration_date";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
