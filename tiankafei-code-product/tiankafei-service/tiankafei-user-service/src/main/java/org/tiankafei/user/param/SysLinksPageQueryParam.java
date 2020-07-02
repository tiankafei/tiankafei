package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import org.tiankafei.web.common.param.OrderQueryParam;

/**
 * <pre>
 * 系统的友情链接 分页查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-07-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统的友情链接 分页查询参数对象", description = "系统的友情链接 分页查询参数对象")
public class SysLinksPageQueryParam extends OrderQueryParam {




}
