package org.tiankafei.rule.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 一维数据集合
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "二维行数据 对象", description = "二维行数据 对象")
public class TwoRowDimension {

    @ApiModelProperty(value = "每一行的系统主键值")
    private String id;

    @ApiModelProperty(value = "行号")
    private Integer rowIndex;

    @ApiModelProperty(value = "行的数据集合")
    private List<OneDimension> dimensionList;

}
