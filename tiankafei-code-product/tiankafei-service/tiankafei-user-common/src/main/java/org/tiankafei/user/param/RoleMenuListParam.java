package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统角色对应的功能配置表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统角色对应的功能配置表 查询参数对象", description = "系统角色对应的功能配置表查询参数")
public class RoleMenuListParam implements Serializable {


}