package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel("ID参数")
public class IdsParam implements Serializable {

    @NotBlank(message = "ID不能为空，如果有多个，用逗号分隔")
    @ApiModelProperty("ID不能为空，如果有多个，用逗号分隔")
    private String ids;

}