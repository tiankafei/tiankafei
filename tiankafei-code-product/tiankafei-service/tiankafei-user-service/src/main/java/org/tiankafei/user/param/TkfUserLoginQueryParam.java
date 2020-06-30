package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 用户登录信息表 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @date 2020-06-30
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户登录信息表 查询参数对象", description = "用户登录信息表查询参数")
public class  TkfUserLoginQueryParam implements Serializable {




}