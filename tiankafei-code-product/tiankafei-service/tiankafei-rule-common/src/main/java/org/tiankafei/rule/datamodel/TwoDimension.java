package org.tiankafei.rule.datamodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 二维数据
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "二维数据 对象", description = "二维数据 对象")
public class TwoDimension {

    @ApiModelProperty(value = "二维数据的唯一标识符")
    private String twoDimensionUniqueIdentifier;

    @ApiModelProperty(value = "二维行数据集合")
    private List<RowDimension> rowDimensionList;

}
