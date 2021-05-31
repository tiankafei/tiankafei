package org.tiankafei.rule.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据集模型
 *
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "数据集模型 对象", description = "数据集模型 对象")
public class DatasetModel {

    @ApiModelProperty(value = "数据集的唯一标识符")
    private String datasetUniqueIdentifier;

    @ApiModelProperty(value = "一维数据集合")
    private List<OneDimension> oneDimensionList;

    @ApiModelProperty(value = "二维数据集合")
    private List<TwoDimension> twoDimensionList;

}
