package org.tiankafei.user.login.entity;

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
 * 用户登录信息表
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_login")
@ApiModel(value = " 用户登录信息表 实体对象", description = "用户登录信息表")
public class LoginEntity extends BaseEntity {

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
    @TableField("username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Size(max = 100, message = "邮箱长度不能超过 100 ！")
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @Size(max = 13, message = "手机号码长度不能超过 13 ！")
    @TableField("telephone")
    private String telephone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    @TableField("password")
    private String password;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Size(max = 2, message = "状态长度不能超过 2 ！")
    @TableField("status")
    private String status;

    /**
     * 有效期截至时间
     */
    @ApiModelProperty(value = "有效期截至时间")
    @TableField("expiration_date")
    private Timestamp expirationDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Timestamp createTime;

}
