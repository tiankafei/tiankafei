package org.tiankafei.rule.rulemodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 一维数据集合
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "一维数据 对象", description = "一维数据 对象")
public class OneDimension {

    @ApiModelProperty(value = "数据唯一标识符")
    private String dataUniqueIdentifier;

    @ApiModelProperty(value = "值")
    private Object value;

}
