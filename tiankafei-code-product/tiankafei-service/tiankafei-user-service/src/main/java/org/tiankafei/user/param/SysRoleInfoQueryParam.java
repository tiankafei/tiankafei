package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 角色信息表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "角色信息表 查询参数对象", description = "角色信息表查询参数")
public class SysRoleInfoQueryParam implements Serializable {




}
