package org.tiankafei.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.entity.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * <pre>
 * 用户登录信息表
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_login")
@ApiModel(value = " 用户登录信息表 实体对象", description = "用户登录信息表")
public class SysUserLoginEntity extends BaseEntity {

    /**
     * 主键，当
     * 用户数据量非常大的时候，要进行分库分表，自增主键不能保证每一个用户的id唯一性，
     * 故采用mybatis-plus提供的自定义id生成器：雪花算法
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @TableField(value = "username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @TableField(value = "password")
    private String password;

    /**
     * 状态：1正常，2停用，3指定有效期
     */
    @ApiModelProperty(value = "状态：1正常，2停用，3指定有效期")
    @Size(max = 1, message = "状态：1正常，2停用，3指定有效期长度不能超过 1 ！")
    @TableField(value = "status")
    private String status;

    /**
     * 有效期截至时间
     */
    @ApiModelProperty(value = "有效期截至时间")
    @TableField(value = "expiration_date")
    private Timestamp expirationDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

}
