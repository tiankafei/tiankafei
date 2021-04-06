package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

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
@ApiModel(value = "UserLoginEntity对象", description = "用户登录信息表")
public class UserLoginVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Size(max = 30, message = "用户名长度不能超过 30 ！")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "邮箱")
    @Size(max = 50, message = "邮箱长度不能超过 50 ！")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Size(max = 11, message = "手机号码长度不能超过 11 ！")
    private String telephone;

    @ApiModelProperty(value = "密码")
    @Size(max = 64, message = "密码长度不能超过 64 ！")
    private String password;

    @ApiModelProperty(value = "状态：1正常，2停用，3指定有效期")
    @Size(max = 1, message = "状态：1正常，2停用，3指定有效期长度不能超过 1 ！")
    private String status;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleteMark;

    @ApiModelProperty(value = "有效期截至时间")
    private Timestamp expirationDate;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String EMAIL = "email";

    public static final String TELEPHONE = "telephone";

    public static final String PASSWORD = "password";

    public static final String STATUS = "status";

    public static final String VERSION = "version";

    public static final String DELETE_MARK = "delete_mark";

    public static final String EXPIRATION_DATE = "expiration_date";

    public static final String TENANT_ID = "tenant_id";


}
