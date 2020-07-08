package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * 系统部门表信息 查询参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统部门表信息 查询参数对象", description = "系统部门表信息查询参数")
public class SysDepartmentQueryParam implements Serializable {


}
