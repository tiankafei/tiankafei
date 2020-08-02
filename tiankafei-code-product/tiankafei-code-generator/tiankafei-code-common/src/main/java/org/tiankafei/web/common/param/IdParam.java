package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@ApiModel("ID参数")
public class IdParam implements Serializable {

    @NotBlank(message = "ID不能为空")
    @ApiModelProperty("id")
    private String id;

}
