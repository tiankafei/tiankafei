package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import org.tiankafei.web.common.param.OrderQueryParam;

/**
 * <pre>
 * 用户登录信息表 分页查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-06-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户登录信息表 分页查询参数对象", description = "用户登录信息表 分页查询参数对象")
public class TkfUserLoginPageQueryParam extends OrderQueryParam {




}
