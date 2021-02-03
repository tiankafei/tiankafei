package org.tiankafei.login.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "登录返回值 对象", description = "登录返回值 对象")
public class LoginResultDto implements Serializable {

    @ApiModelProperty(value = "用户登录成功后返回的token")
    private String token;

    @ApiModelProperty(value = "用户id")
    private Long id;

}
