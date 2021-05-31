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
@ApiModel(value = "行列范围对象", description = "行列范围对象")
public class RankRangeDto {

    @ApiModelProperty(value = "行代码")
    private String rowCode;

    @ApiModelProperty(value = "列代码")
    private String colCode;

    @ApiModelProperty(value = "元素列表")
    private String items;

}
