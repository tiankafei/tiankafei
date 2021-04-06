package org.tiankafei.user.param;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

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
@ApiModel(value = "用户拥有的角色关系表 删除参数对象")
public class UserRoleDeleteParam implements Serializable {

    private static final long serialVersionUID = 1L;


}
