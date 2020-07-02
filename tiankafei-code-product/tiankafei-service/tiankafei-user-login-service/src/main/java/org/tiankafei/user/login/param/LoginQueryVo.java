package org.tiankafei.user.login.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "用户登录对象", description = "用户登录对象")
public class LoginQueryVo implements Serializable {




}
