package org.tiankafei.web.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@ApiModel("主键状态VO")
public class IdStatusParam implements Serializable {

    @ApiModelProperty("主键ID")
    private String id;

    @ApiModelProperty("状态,1:启用 0:禁用")
    private Integer status;

}
