package org.tiankafei.elasticsearch.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author 甜咖啡
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "索引参数对象")
public class IndexParam {

    @ApiModelProperty(value = "索引名称")
    @NotBlank(message = "索引名称不能为空")
    private String indexName;

}
