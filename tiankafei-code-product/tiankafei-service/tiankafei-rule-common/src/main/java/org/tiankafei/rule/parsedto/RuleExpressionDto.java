package org.tiankafei.rule.parsedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tiankafei
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规则表达式 对象", description = "规则表达式 对象")
public class RuleExpressionDto {

    @ApiModelProperty(value = "规则id")
    private String ruleId;

    @ApiModelProperty(value = "当前规则表达式")
    private String expression;

    @ApiModelProperty(value = "替换后的规则表达式")
    private String newExpression;

    @ApiModelProperty(value = "当前规则表达式元素的别名集合")
    private List<String> aliasNameList;

    @ApiModelProperty(value = "当前规则表达式元素的别名映射集合")
    private Map<String, ElementMapDto> aliasNameMap;

    @ApiModelProperty(value = "当前规则表达式中的行列表达式集合")
    private List<RankRangeDto> rankRangeDtoList;

    @ApiModelProperty(value = "规则执行类型：1全是一维，2普通二维，3包含聚合函数，4全是常量")
    private String ruleExecuteType;

    @ApiModelProperty(value = "每一个数据集中的数据唯一标识:key(datasetUniqueIdentifier)——>value(dataUniqueIdentifier)")
    private Map<String, Set<String>> datasetUniqueIdentifierSetMap;

}
