package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 系统角色对应的功能配置表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统角色对应的功能配置表 检查是否存在参数对象")
public class RoleMenuCheckParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
