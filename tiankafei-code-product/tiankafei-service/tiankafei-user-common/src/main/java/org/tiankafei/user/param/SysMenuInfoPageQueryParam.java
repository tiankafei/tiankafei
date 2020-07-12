package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.OrderQueryParam;

/**
 * <pre>
 * 系统功能菜单信息表 分页查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统功能菜单信息表 分页查询参数对象", description = "系统功能菜单信息表 分页查询参数对象")
public class SysMenuInfoPageQueryParam extends OrderQueryParam {


}
