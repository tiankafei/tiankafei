package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.param.BaseOrderQueryParam;

/**
 * <pre>
 * 用户拥有的角色关系表 分页参数对象
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户拥有的角色关系表 分页列表参数对象")
public class UserRolePageParam extends BaseOrderQueryParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "逻辑删除字段：2已删除，0未删除")
    private Integer deleteMark;

}
