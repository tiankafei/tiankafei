package org.tiankafei.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.vo.BaseQueryVo;

/**
 * <p>
 * 用户拥有的角色关系表
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserRoleEntity对象", description = "用户拥有的角色关系表")
public class UserRoleVo extends BaseQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    @ApiModelProperty(value = "状态：1在用，0停用")
    @NotNull(message = "状态：1在用，0停用不能为空")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(value = "创建用户ID")
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID")
    private Long updateUserId;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String UPDATE_USER_ID = "update_user_id";


}
