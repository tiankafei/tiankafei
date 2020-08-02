package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 用户拥有的角色关系表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户拥有的角色关系表 查询参数对象", description = "用户拥有的角色关系表查询参数")
public class UserRoleListParam implements Serializable {

    /**
     * 主键id集合
     */
    @ApiModelProperty(value = "主键id集合")
    String ids;

    /**
     * 用户id集合
     */
    @ApiModelProperty(value = "用户id集合")
    String userIds;

    /**
     * 角色id集合
     */
    @ApiModelProperty(value = "角色id集合")
    String roleIds;

}
