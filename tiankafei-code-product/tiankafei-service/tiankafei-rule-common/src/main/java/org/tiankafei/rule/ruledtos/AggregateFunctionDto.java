package org.tiankafei.rule.ruledtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "聚合函数对象", description = "聚合函数对象")
public class AggregateFunctionDto {

    @ApiModelProperty(value = "函数名")
    private String methodName;

}
