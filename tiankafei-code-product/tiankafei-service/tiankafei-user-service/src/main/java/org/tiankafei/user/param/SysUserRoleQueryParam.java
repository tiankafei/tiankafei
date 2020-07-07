package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class SysUserRoleQueryParam implements Serializable {




}
