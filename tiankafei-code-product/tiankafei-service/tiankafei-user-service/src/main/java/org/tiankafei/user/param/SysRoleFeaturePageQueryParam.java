package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import org.tiankafei.web.common.param.OrderQueryParam;

/**
 * <pre>
 * 系统角色对应的功能配置表 分页查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统角色对应的功能配置表 分页查询参数对象", description = "系统角色对应的功能配置表 分页查询参数对象")
public class SysRoleFeaturePageQueryParam extends OrderQueryParam {




}