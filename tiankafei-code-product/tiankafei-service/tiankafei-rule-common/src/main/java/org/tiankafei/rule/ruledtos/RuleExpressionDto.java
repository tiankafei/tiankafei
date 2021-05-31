package org.tiankafei.rule.ruledtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则表达式 对象", description = "规则表达式 对象")
public class RuleExpressionDto {

    @ApiModelProperty(value = "当前规则表达式元素的别名集合")
    private List<String> aliasNameList;

    @ApiModelProperty(value = "当前规则表达式元素的别名映射集合")
    private Map<String, ElementMapDto> aliasNameMap;

    @ApiModelProperty(value = "当前规则表达式")
    private String expression;

}
